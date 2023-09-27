package com.example.maasfp.service;


import com.example.maasfp.model.Route;

import java.util.List;

public interface InterfaceBookingService {
    /*Update eventual discount*/
    Route updateRoute(Long accountId);

    /*Get all routes*/
    List<Route> getAllRoutes();

    Route getRouteById(Long id);

    /*Create a new route*/
    Route createNewRoute(Route newRoute);

}
