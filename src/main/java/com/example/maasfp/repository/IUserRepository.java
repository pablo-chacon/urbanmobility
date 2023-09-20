package com.example.maasfp.repository;

import com.example.maasfp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Accounts, Long> {
}
