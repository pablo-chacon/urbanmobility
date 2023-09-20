package com.example.maasfp.repository;

import com.example.maasfp.model.Provider;
import com.example.maasfp.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

}