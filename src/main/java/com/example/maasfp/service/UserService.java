package com.example.maasfp.service;

import com.example.maasfp.model.Accounts;
import com.example.maasfp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public Accounts saveAccount(Accounts newAccounts) {
        return repository.save(newAccounts);
    }

    @Override
    public Accounts updateAccount(Accounts oldAccounts) {
        return null;
    }

    @Override
    public void deleteAccount(Long accountId) {

    }

    @Override
    public Accounts fetchedAccount(Long accountId) {
        return null;
    }
}