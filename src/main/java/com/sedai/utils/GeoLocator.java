package com.sedai.utils;

import com.sedai.model.Coordinate;
import com.sedai.model.Boundary;

import java.util.List;

public class GeoLocator {

    public static Boundary calculateBoundaries (List<Coordinate> coordinates){
        double minLat = coordinates.stream().mapToDouble(Coordinate::getLatitude).min().getAsDouble();
        double maxLat = coordinates.stream().mapToDouble(Coordinate::getLatitude).max().getAsDouble();
        double minLon = coordinates.stream().mapToDouble(Coordinate::getLongitude).min().getAsDouble();
        double maxLon = coordinates.stream().mapToDouble(Coordinate::getLongitude).max().getAsDouble();

        return new Boundary(minLat,maxLat,minLon,maxLon);
    }
}
