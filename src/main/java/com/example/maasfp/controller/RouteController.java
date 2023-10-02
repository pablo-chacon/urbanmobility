package com.example.maasfp.controller;


import com.example.maasfp.model.Account;
import com.example.maasfp.model.Route;
import com.example.maasfp.service.AccountService;
import com.example.maasfp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/route/")
public class RouteController {

    @Autowired
    RouteService routeService;
    AccountService accountService;

    List<Route> routes = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();


    public RouteController(RouteService routeService, AccountService accountService) {
        this.routeService = routeService;
        this.accountService = accountService;
    }

    @GetMapping
    public List<Route> getAllRoute(){
        return routeService.getAllRoutes();
    }

    @GetMapping("{id}")
    public Route getRouteById(@PathVariable("id") long id) {
        return routeService.getRouteById(id);
    }

    @PostMapping
    public ResponseEntity<Route> newRoute(@RequestBody Route route) {
        routeService.createNewRoute(route);
        return new ResponseEntity<>(route, HttpStatus.CREATED);
    }



}
