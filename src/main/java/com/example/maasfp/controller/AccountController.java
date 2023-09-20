package com.example.maasfp.controller;

import com.example.maasfp.model.Accounts;
import com.example.maasfp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private UserService accountService;
    // Save operation
    @PostMapping("/create_account")
    public Accounts saveAccount() {
        Accounts accounts = Accounts.builder()
                .username("Josef")
                .contactInfo("112")
                .accountType("ADMIN")
                .paymentInfo(112)
                .build();
        return accountService.saveAccount(accounts);
    }
}