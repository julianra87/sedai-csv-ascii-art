package com.sedai;

import com.sedai.parser.CsvCoordinateEngine;
import com.sedai.render.AsciiMapRenderer;

public class Main {
//    public static void main(String[] args) {
//        String csvPathClean = "src/main/resources/ukpostcodes-clean.csv";
//        String csvPathOriginal = "src/main/resources/ukpostcodes.csv";
//
//        String csvPath;
//        Boolean runTypeClean = args.length > 0 && args[0].equalsIgnoreCase("clean");
//        if (runTypeClean) {
//            csvPath = csvPathClean;
//        } else {
//            csvPath = csvPathOriginal;
//        }
//
//        var coordinates = new CsvCoordinateEngine().parse(csvPath, runTypeClean);
//
//        var renderer = new AsciiMapRenderer(60, 80); // You can tweak size
//        renderer.plot(coordinates);
//        renderer.render();
//    }
}