package com.example.maasfp.service;


import com.example.maasfp.model.Account;

public interface InterfaceUserService {

    Account saveAccount(Account newAccount);


    Account updateAccount(Account oldAccount);



    void deleteAccount(Long accountId);


    Account getAccount(Long accountId);
}
