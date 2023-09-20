package com.example.maasfp.service;

import com.example.maasfp.model.User;
import com.example.maasfp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public User saveAccount(User newUser) {
        return repository.save(newUser);
    }

    @Override
    public User updateAccount(User oldUser) {
        return null;
    }

    @Override
    public void deleteAccount(Long accountId) {

    }

    @Override
    public User fetchedAccount(Long accountId) {
        return null;
    }
}