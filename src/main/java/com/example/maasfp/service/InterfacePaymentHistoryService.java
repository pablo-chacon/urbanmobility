package com.example.maasfp.service;

import com.example.maasfp.model.PaymentHistory;

public interface InterfacePaymentHistoryService {
    /*Fetch object*/
    PaymentHistory paymentHistory(Long accountId);
}
