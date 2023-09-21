package com.example.maasfp.service;


import com.example.maasfp.model.Accounts;

public interface InterfaceUserService {

    Accounts saveAccount(Accounts newAccounts);


    Accounts updateAccount(Accounts oldAccounts);



    void deleteAccount(Long accountId);


    Accounts getAccount(Long accountId);
}
