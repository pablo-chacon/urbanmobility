package com.example.maasfp.repository;


import com.example.maasfp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveBookingRepository extends JpaRepository<Booking, Long> {
}
