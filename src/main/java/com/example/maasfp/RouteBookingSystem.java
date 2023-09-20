package com.example.maasfp;

import com.example.maasfp.model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteBookingSystem {
    private List<Route> routes;


    public RouteBookingSystem() {
        this.routes = new ArrayList<>();
    }


    public void downloadRoutes(List<String> providers) {
        // Logic to download routes from providers
        // ...
        // Assuming routes are downloaded and stored in a list
        for (String provider : providers) {
            // Assuming the routes are obtained from the provider
            List<Route> providerRoutes = getRoutesFromProvider(provider);
            routes.addAll(providerRoutes);
        }
    }

    public void createBooking(int routeIndex) {
        if (routeIndex < 0 || routeIndex >= routes.size()) {
            throw new IllegalArgumentException("Invalid route index.");
        }

        Route route = routes.get(routeIndex);
        String supplier = route.getSupplier();

        // Logic to create a booking with the supplier
        // ...
        // Assuming the booking is successfully created
        System.out.println("Booking created with supplier: " + supplier);
    }

    /**
     * @param provider get routes.
     * @return list provider routes.
     */
    private List<Route> getRoutesFromProvider(String provider) {
        // Get routes from the provider.
        List<Route> providerRoutes = new ArrayList<>();
        providerRoutes.add(new Route("Place A", "Place B", "Train", "09:00", "11:00", "Gold Award", provider, 0.2));
        providerRoutes.add(new Route("Place C", "Place D", "Bus", "12:00", "14:00", "Silver Award", provider, 0.1));
        return providerRoutes;
    }
}





