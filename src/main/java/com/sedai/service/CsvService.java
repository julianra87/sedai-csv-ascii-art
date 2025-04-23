package com.sedai.service;

import com.sedai.model.Coordinate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CsvService {
    private final Map<Double, Coordinate> coordinateMap = new ConcurrentHashMap<>();

    public List<Coordinate> getCsvEntries() {
        return coordinateMap.isEmpty() ? new ArrayList<>(coordinateMap.values()) : coordinateMap.values().stream().toList();
    }

    public Optional<Coordinate> getCoordinate(Double id) {
        return Optional.ofNullable(coordinateMap.get(id));
    }

    public Coordinate createCoordinate(Coordinate Coordinate) {
        coordinateMap.put(Coordinate.getId(), Coordinate);
        return Coordinate;
    }

    public Coordinate updateCoordinate(Double id, Coordinate coordinate) {
        coordinate.setId(id);
        coordinateMap.put(id, coordinate);
        return coordinate;
    }

    public void deleteCoordinate(Double id){
        coordinateMap.remove(id);
    }

    public void uploadCsvFile(MultipartFile file) {

    }
}
