package com.example.maasfp.controller;


import com.example.maasfp.model.Account;
import com.example.maasfp.model.Booking;
import com.example.maasfp.model.Route;
import com.example.maasfp.service.AccountService;
import com.example.maasfp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path = "api/route/")
public class RouteController {

    @Autowired
    BookingService bookingService;
    AccountService accountService;

    List<Booking> bookings = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();


    public RouteController(BookingService bookingService, AccountService accountService) {
        this.bookingService = bookingService;
        this.accountService = accountService;
    }

    @GetMapping
    public List<Booking> getAllRoute(){
        return bookingService.getAllRoutes();
    }

    @GetMapping("{id}")
    public Route getRouteById(@PathVariable("id") long id) {
        return bookingService.getRouteById(id);
    }

    @PostMapping
    public ResponseEntity<Route> newRoute(@RequestBody Route route) {
        bookingService.createNewRoute(route);
        return new ResponseEntity<>(route, HttpStatus.CREATED);
    }

    /*@PutMapping("update/{id}")
    public void updateRoute(@PathVariable Route routeId) {
        Route route = bookingService.getRouteById(routeId.getId());
        route.setRoute(route.getRoute());

    }*/

}
