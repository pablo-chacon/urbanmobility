package com.example.maasfp.service;


import com.example.maasfp.model.Route;

import java.util.List;

public interface InterfaceRouteService {
    /*Update eventual discount*/
    Route updateRoute(Long accountId);

    /*Fetch a list of routes from all the contractors*/
    List<Route> fetchAllRoutes();

    /*Create a new route*/
    Route createNewRoute(Route newRoute);

}
