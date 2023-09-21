package com.example.maasfp.service;

import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements InterfaceUserService {

    @Autowired
    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
    }

    @Override
    public Account saveAccount(Account newAccount) {
        return repository.save(newAccount);
    }

    @Override
    public Account updateAccount(Account oldAccount) {
        return null;
    }

    @Override
    public void deleteAccount(Long accountId) {

    }

    @Override
    public Account getAccount(Long accountId) {
        return null;
    }
}