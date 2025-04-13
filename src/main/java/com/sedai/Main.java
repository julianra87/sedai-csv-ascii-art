package com.sedai;

import com.sedai.parser.CsvCoordinateParser;
import com.sedai.render.AsciiMapRenderer;

public class Main {
    public static void main(String[] args) {
        String csvPathClean = "src/main/resources/ukpostcodes-clean.csv";
        String csvPathOriginal = "src/main/resources/ukpostcodes.csv";

        String csvPath;
        if (args.length > 0 && args[0].equalsIgnoreCase("clean")) {
            csvPath = csvPathClean;
        } else {
            csvPath = csvPathOriginal;
        }

        var coordinates = new CsvCoordinateParser().parse(csvPath);

        var renderer = new AsciiMapRenderer(60, 80); // You can tweak size
        renderer.plot(coordinates);
        renderer.render();
    }
}