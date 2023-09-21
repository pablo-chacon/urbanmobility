package com.example.maasfp.service;

import com.example.maasfp.model.Accounts;

import com.example.maasfp.model.Booking;
import com.example.maasfp.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingsRepository repository;

    public Booking saveBookings(Booking booking) {
        return repository.save(booking);
    }

    public Booking updateBooking(Accounts oldAccounts) {
        return null;
    }

    public void deleteBooking(Long bookingId) {

    }

    public Booking getAccount(Long bookingId) {
        return null;
    }
}
