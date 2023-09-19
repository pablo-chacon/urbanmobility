package com.example.maasfp.model;



import java.util.ArrayList;
import java.util.List;


public class Route {
    private String origin;
    private String destination;
    private String transportType;
    private String estimatedDeparture;
    private String estimatedArrival;
    private String award;
    private String supplier;
    private double promotionalDiscount;

    /**
     * Constructor to initialize the vehicle route.
     *
     * @param origin    The place of departure.
     * @param destination      The place of arrival.
     * @param transportType     The type of transport.
     * @param estimatedDeparture The estimated departure time.
     * @param estimatedArrival  The estimated arrival time.
     * @param award             The award for the route.
     * @param supplier          The supplier of the route.
     * @param promotionalDiscount The promotional discount for the route.
     */
    public Route(String origin, String destination, String transportType, String estimatedDeparture,
                 String estimatedArrival, String award, String supplier, double promotionalDiscount) {
        this.origin = origin;
        this.destination = destination;
        this.transportType = transportType;
        this.estimatedDeparture = estimatedDeparture;
        this.estimatedArrival = estimatedArrival;
        this.award = award;
        this.supplier = supplier;
        this.promotionalDiscount = promotionalDiscount;
    }

    /**
     * Getter for the departure place.
     *
     * @return Returns the place of departure.
     */
    public String getOrigin() {
        return origin;
    }


    public String getDestination() {
        return destination;
    }


    public String getTransportType() {
        return transportType;
    }

    /**
     * Getter for the estimated departure time.
     *
     * @return Returns the estimated departure time.
     */
    public String getEstimatedDeparture() {
        return estimatedDeparture;
    }

    public String getEstimatedArrival() {
        return estimatedArrival;
    }


    public String getAward() {
        return award;
    }


    public String getSupplier() {
        return supplier;
    }


    public double getPromotionalDiscount() {
        return promotionalDiscount;
    }
}

