package com.example.maasfp.service;

import com.example.maasfp.model.Route;
import com.example.maasfp.repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService implements IRouteService {
    @Autowired
    IRouteRepository repository;

    @Override
    public Route updateRoute(Long accountId) {
        return null;
    }

    @Override
    public List<Route> fetchAllRoutes() {
        return null;
    }

    @Override
    public Route createNewRoute(Route newRoute) {
        return null;
    }
}
