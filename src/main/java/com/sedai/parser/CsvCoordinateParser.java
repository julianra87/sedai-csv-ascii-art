package com.sedai.parser;

import com.sedai.model.Coordinate;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvCoordinateParser {

    public List<Coordinate> parse(String csvFilePath) {
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
                    coordinates.add(new Coordinate(id, postcode, latitude, longitude));
                } catch (NumberFormatException e) {
                    // skip invalid records
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return coordinates;
    }

}
