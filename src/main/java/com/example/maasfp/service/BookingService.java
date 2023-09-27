package com.example.maasfp.service;

import com.example.maasfp.model.Route;
import com.example.maasfp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements InterfaceBookingService {
    @Autowired
    BookingRepository repository;

    @Override
    public Route updateRoute(Long accountId) {
        return null;
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
        route.setAccount(route.getAccount());
        return repository.save(route);
    }*/
}
