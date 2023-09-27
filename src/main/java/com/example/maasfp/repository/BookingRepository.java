package com.example.maasfp.repository;

import com.example.maasfp.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Route, Long> {
}
