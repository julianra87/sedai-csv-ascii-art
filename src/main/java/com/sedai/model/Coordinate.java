package com.sedai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {
    private double id;
    private String postcode;
    private double latitude;
    private double longitude;
}
