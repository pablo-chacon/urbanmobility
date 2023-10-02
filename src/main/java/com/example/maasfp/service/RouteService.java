package com.example.maasfp.service;

import com.example.maasfp.model.Route;
import com.example.maasfp.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RouteService implements InterfaceRouteService {
    @Autowired
    RouteRepository repository;

    @Override
    public Route updateRoute(Long routeId) {
        return repository.findById(routeId).get();
    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }


    @Override
    public Route getRouteById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Route createNewRoute(Route newRoute) {
        return null;
    }
/*
    public Route updateRouteById(Long id) {
        Route route = repository.findById(id).get();
        route.setRoute(route.getRoute());
        return repository.save(route);
    }*/
}
