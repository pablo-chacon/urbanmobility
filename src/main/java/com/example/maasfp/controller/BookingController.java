package com.example.maasfp.controller;


import com.example.maasfp.model.Account;
import com.example.maasfp.model.Booking;
import com.example.maasfp.service.AccountService;
import com.example.maasfp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/route/")
public class BookingController {

    @Autowired
    BookingService bookingService;
    AccountService accountService;


    public BookingController(BookingService bookingService, AccountService accountService) {
        this.bookingService = bookingService;
        this.accountService = accountService;
    }


    @GetMapping
    public List<Booking> getAllRoute(){
        return bookingService.getAllRoutes();
    }


    @GetMapping("{id}")
    public Booking getRouteById(@PathVariable("id") long id) {
        return bookingService.updateRouteById(id);
    }

    @PostMapping
    public ResponseEntity<Booking> newRoute(@RequestBody Booking booking) {
        BookingService.createAccount(booking);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }


    @PutMapping("update/{id}")
    public Route updateRoute () {
        Optional<Account> account = accountService.getAccountById(id);
        return bookingService.updateRouteById(account.get().getId());
    }

}
