package com.example.maasfp.service;


import com.example.maasfp.model.Accounts;

public interface IUserService {
    /*Create new account*/
    Accounts saveAccount(Accounts newAccounts);

    /*Update field*/
    Accounts updateAccount(Accounts oldAccounts);


    /*Delete account*/
    void deleteAccount(Long accountId);

    /*Fetch account*/
    Accounts fetchedAccount(Long accountId);
}
