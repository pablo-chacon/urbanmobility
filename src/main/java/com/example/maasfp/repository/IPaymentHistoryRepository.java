package com.example.maasfp.repository;

import com.example.maasfp.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
}
