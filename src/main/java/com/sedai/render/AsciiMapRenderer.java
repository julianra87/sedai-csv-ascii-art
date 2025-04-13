package com.sedai.render;

import com.sedai.model.Boundary;
import com.sedai.model.Coordinate;
import com.sedai.utils.GeoLocator;

import java.util.List;

public class AsciiMapRenderer {

    private final int rows;
    private final int cols;
    private final char[][] grid;
    private double minLat, maxLat, minLon, maxLon;

    public AsciiMapRenderer(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new char[rows][cols];
    }

    public void plot(List<Coordinate> coordinates) {
        Boundary boundaries = GeoLocator.calculateBoundaries(coordinates);
        minLat = boundaries.getMinLat();
        maxLat = boundaries.getMaxLat();
        minLon = boundaries.getMinLon();
        maxLon = boundaries.getMaxLon();

        for (Coordinate coord : coordinates) {
            int row = latToRow(coord.getLatitude());
            int col = lonToCol(coord.getLongitude());

            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                grid[row][col] = '*';
            }
        }
    }

    private int latToRow(double lat) {
        return (int) ((maxLat - lat) / (maxLat - minLat) * rows);
    }

    private int lonToCol(double lon) {
        return (int) ((lon - minLon) / (maxLon - minLon) * cols);
    }

    public void render() {
        for (char[] row : grid) {
            for (char ch : row) {
                System.out.print(ch == '\0' ? ' ' : ch);
            }
            System.out.println();
        }
    }
}
