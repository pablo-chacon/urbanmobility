package com.example.maasfp.service;

import com.example.maasfp.model.PaymentHistory;

public interface IPaymentHistoryService {
    /*Fetch object*/
    PaymentHistory paymentHistory(Long accountId);
}
