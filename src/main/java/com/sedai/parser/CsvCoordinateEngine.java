package com.sedai.parser;

import com.sedai.model.Coordinate;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvCoordinateEngine {

    private final double latLowerBound = 49.9;
    private final double latUpperBound = 60.9;
    private final double longLowerBound = -8.6;
    private final double longUpperBound = 1.8;

    public List<Coordinate> parse(String csvFilePath, boolean cleanEntries) {
        List<Coordinate> coordinates = new ArrayList<>();

        try (Reader in = new FileReader(csvFilePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(in);

            for (CSVRecord record : records) {
                try {
                    double id = Double.parseDouble(record.get("id"));
                    String postcode = record.get("postcode");
                    double latitude = Double.parseDouble(record.get("latitude"));
                    double longitude = Double.parseDouble(record.get("longitude"));
                    Coordinate coordinate = new Coordinate(id, postcode, latitude, longitude);
                    if (cleanEntries) {
                        if(checkIfUkBoundCoordinate(coordinate)){
                            coordinates.add(coordinate);
                        }
                    }else {
                        coordinates.add(coordinate);
                    }
                } catch (NumberFormatException e) {
                    // skip invalid records
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return coordinates;
    }

    public Boolean checkIfUkBoundCoordinate(Coordinate coordinate) {
        return coordinate.getLatitude() >= latLowerBound && coordinate.getLatitude() <= latUpperBound &&
                coordinate.getLongitude() >= longLowerBound && coordinate.getLongitude() <= longUpperBound;
    }
}
