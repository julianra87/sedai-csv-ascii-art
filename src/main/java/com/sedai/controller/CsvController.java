package com.sedai.controller;

import com.sedai.model.Coordinate;
import com.sedai.service.CsvService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/csv")
public class CsvController {

    private final CsvService csvService;

    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordinate> getCoordinate(
            @Parameter(description = "ID of the coordinate to retrieve", example = "1")
            @PathVariable Double id) {

        Optional<Coordinate> coordinate = csvService.getCoordinate(id);
        return coordinate
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Coordinate> createCoordinate(@RequestBody Coordinate coordinate){
        Coordinate createdCoordinate = csvService.createCoordinate(coordinate);
        return new ResponseEntity<>(createdCoordinate, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Coordinate> updateCoordinate(@RequestBody Coordinate coordinate){
        Coordinate updatedCoordinate = csvService.updateCoordinate(coordinate.getId(), coordinate);
        return new ResponseEntity<>(updatedCoordinate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coordinate> deleteCoordinate(
            @Parameter(description = "ID of the coordinate to delete", example = "1")
            @PathVariable Double id) {

        csvService.deleteCoordinate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}