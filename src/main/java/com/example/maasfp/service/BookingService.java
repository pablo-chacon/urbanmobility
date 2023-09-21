package com.example.maasfp.service;

import com.example.maasfp.model.Account;

import com.example.maasfp.model.Booking;
import com.example.maasfp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public Booking saveBookings(Booking booking) {
        return repository.save(booking);
    }

    public Booking updateBooking(Account oldAccount) {
        return null;
    }

    public void deleteBooking(Long bookingId) {

    }

    public Booking getAccount(Long bookingId) {
        return null;
    }
}
