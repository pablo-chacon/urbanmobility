package com.example.maasfp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RouteTests {

    /**
     * Validates Route object correctly constructed.
     * @throws Exception if error occurs during construction.
     */
    @Test
    public void testRouteConstruction() throws Exception {

        Route route = Route.builder()
                .origin("Stockholm City")
                .destination("Malmö Central")
                .departure("2023-12-01")
                .arrival("2023-12-03")
                .transportationType("Train")
                .price(350)
                .provider("SJ")
                .campaignCode(0.2)
                .build();

        // Validate that the Route object is constructed correctly.
        assertEquals("Stockholm City", route.getOrigin(), "The origin was not set correctly.");
        assertEquals("Malmö Central", route.getDestination(), "The destination was not set correctly.");
        assertEquals("2023-12-01", route.getDeparture(), "The departure was not set correctly.");
        assertEquals("2023-12-03", route.getArrival(), "The arrival was not set correctly.");
        assertEquals("Train", route.getTransportationType(), "The transportation type was not set correctly.");
        assertEquals(350, route.getPrice(), "The price was not set correctly.");
        assertEquals("SJ", route.getProvider(), "The provider was not set correctly.");
        assertEquals(0.2, route.getCampaignCode(), "The campaign code was not set correctly.");
    }

    /**
     * Ensure exception is thrown when required fields are missing.
     * @throws Exception if error occurs during construction.
     */
    @Test
    public void testRouteConstructionValidation() throws Exception {

        assertThrows(IllegalArgumentException.class, () -> {
            Route.builder()
                    .origin("Stockholm City")
                    .destination("Malmö Central")
                    .build();
        }, "Expected an exception due to missing required fields.");
    }

    /**
     * Validates Route object update.
     * @throws Exception if error occurs during update.
     */
    @Test
    public void testRouteUpdate() throws Exception {
        // Construct a Route object with initial values.
        Route route = Route.builder()
                .origin("Stockholm City")
                .destination("Malmö Central")
                .departure("2023-12-01")
                .arrival("2023-12-03")
                .transportationType("Train")
                .price(350)
                .provider("SJ")
                .campaignCode(0.2)
                .build();

        // Update the Route object with new values.
        route.setOrigin("Norrköping Resecentrum");
        route.setDestination("Göteborg Central");
        route.setDeparture("2024-02-01");
        route.setArrival("2024-02-02");
        route.setTransportationType("Bus");
        route.setPrice(300);
        route.setProvider("Buss Deluxe");
        route.setCampaignCode(0.1);

        // Validate that the Route object is updated correctly.
        assertEquals("Norrköping Resecentrum", route.getOrigin(), "The origin was not updated correctly.");
        assertEquals("Göteborg Central", route.getDestination(), "The destination was not updated correctly.");
        assertEquals("2024-02-01", route.getDeparture(), "The departure was not updated correctly.");
        assertEquals("2024-02-02", route.getArrival(), "The arrival was not updated correctly.");
        assertEquals("Bus", route.getTransportationType(), "The transportation type was not updated correctly.");
        assertEquals(300, route.getPrice(), "The price was not updated correctly.");
        assertEquals("Buss Deluxe", route.getProvider(), "The provider was not updated correctly.");
        assertEquals(0.2, route.getCampaignCode(), "The campaign code was not updated correctly.");
    }
}