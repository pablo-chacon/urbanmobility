package com.example.maasfp.service;


import com.example.maasfp.model.User;

public interface IUserService {
    /*Create new account*/
    User saveAccount(User newUser);

    /*Update field*/
    User updateAccount(User oldUser);


    /*Delete account*/
    void deleteAccount(Long accountId);

    /*Fetch account*/
    User fetchedAccount(Long accountId);
}
