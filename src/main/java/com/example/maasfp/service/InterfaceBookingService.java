package com.example.maasfp.service;


import com.example.maasfp.model.Booking;

public interface InterfaceBookingService {
    /*Fetch object*/
    Booking fetchActiveBookingList(Long accountId);

    /*Create new booking*/
    Booking createNewBooking(Booking booking);

    /*Delete a booking*/
    void deleteBooking(Long bookingId);
}
