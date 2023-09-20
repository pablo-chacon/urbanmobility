package com.example.maasfp.repository;


import com.example.maasfp.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingsRepository extends JpaRepository<Bookings, Long> {
}
