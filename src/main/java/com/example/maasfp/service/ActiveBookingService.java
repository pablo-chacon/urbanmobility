package com.example.maasfp.service;

import com.example.maasfp.model.Booking;
import com.example.maasfp.repository.ActiveBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveBookingService {

    @Autowired
    private ActiveBookingRepository repository;

    public Booking newBooking(Booking booking) {
        return repository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return booking;
    }

    public void deleteBooking(Long bookingId) {

    }

    public Booking getBooking(Long bookingId) {
        return null;
    }
}
