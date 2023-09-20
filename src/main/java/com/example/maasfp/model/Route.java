package com.example.maasfp.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    private String origin;
    private String destination;
    private String transportType;
    private String estimatedDeparture;
    private String estimatedArrival;
    private String award;
    private String supplier;
    private double promotionalDiscount;


}

