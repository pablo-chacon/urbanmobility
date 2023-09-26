package com.example.maasfp.service;

import com.example.maasfp.exceptions.InvalidInputException;
import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements InterfaceUserService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> getAccountById(long accountId) {
        if (!accountRepository.existsById(accountId)){
            throw new ResourceNotFoundException("Account with ID" + " " + accountId + " " + "does not exist");
        }
        return accountRepository.findById(accountId);
    }

    public List<Account> getAllAccounts() {
        if(accountRepository.findAll().isEmpty()){
            throw new ResourceNotFoundException("No account found");
        }
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        // Check if username already exist
        String username = account.getUsername();
        if (accountRepository.findByUsername(username) != null) {
            throw new InvalidInputException(username + "is already in use");
        }

        // Check if email already exist
        String email = account.getEmail();
        if (accountRepository.findByEmail(email) != null) {
            throw new InvalidInputException(email + "is already in use.");
        }
        // Save account to DB.
        return accountRepository.save(account);
    }

    public void deleteAccountById(long accountId) {
        if(!accountRepository.existsById(accountId)){
            throw new ResourceNotFoundException("No account with " + accountId + " found");
        }
        accountRepository.deleteById(accountId);
    }

    public Account updateAccountById(Long accountId, Account account) {
        if (!accountRepository.existsById(accountId)){
            throw new ResourceNotFoundException("No account with " + accountId + " found");
        }
        account.setId(accountId);
        return accountRepository.save(account);
    }

    @Override
    public Account saveAccount(Account newAccount) {
        return null;
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

    @Override
    public void deleteAccountById(Long accountId) {

    }

    @Override
    public Account getAccountById(Long accountId) {
        return null;
    }
}

/*
@Service
public class AccountService  {


    @Override
    public Account saveAccount(Account newAccount) {
        return null;
    }

    @Override
    public Account updateAccount(Account oldAccount) {
        return null;
    }

    @Override
    public void deleteAccountById(Long accountId) {

    }

    @Override
    public Account getAccountById(Long accountId) {
        return null;
    }

    /*@Autowired
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
    }*/



