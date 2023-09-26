package com.example.maasfp.controller;


import com.example.maasfp.model.Account;
import com.example.maasfp.model.Route;
import com.example.maasfp.service.AccountService;
import com.example.maasfp.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/route/")
public class RouteController {
    final RouteService routeService;
    //final Route route;
    final AccountService accountService;

    public RouteController(RouteService routeService, AccountService accountService) {
        this.routeService = routeService;
        this.accountService = accountService;
    }

    @GetMapping
    public List<Route> getAllRoute(){
        return routeService.getAllRoutes();
    }

     @GetMapping("{id}")
    public Route getRouteById(@PathVariable("id") long id){
        return routeService.updateRouteById(id);

    @PostMapping("new")
    public Route createRoute() {
        return routeService.createNewRoute(route);
    }

    @PutMapping("update/{id}")
    public Route updateRoute(){
        Optional<Account> account = accountService.getAccountById(id);
        return routeService.updateRouteById(account.get().getId());
    }
}
