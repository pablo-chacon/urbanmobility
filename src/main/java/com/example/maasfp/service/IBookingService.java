package com.example.maasfp.service;


import com.example.maasfp.model.Bookings;

public interface IBookingService {
    /*Fetch object*/
    Bookings fetchActiveBookingList(Long accountId);

    /*Create new booking*/
    Bookings createNewBooking(Bookings bookings);

    /*Delete a booking*/
    void deleteBooking(Long bookingId);
}
