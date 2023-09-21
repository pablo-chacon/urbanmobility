package com.example.maasfp.service;


import com.example.maasfp.model.PaymentHistory;
import com.example.maasfp.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentHistoryService
implements InterfacePaymentHistoryService {
    @Autowired
    PaymentHistoryRepository repository;

    @Override
    public PaymentHistory paymentHistory(Long accountId) {
        return null;
    }
}
