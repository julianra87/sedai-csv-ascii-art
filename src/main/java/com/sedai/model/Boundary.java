package com.sedai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boundary {
    double minLat;
    double maxLat;
    double minLon;
    double maxLon;
}
