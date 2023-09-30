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
    private final AccountRepository repository;


    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }



    public Optional<Account> getAccountById(long accountId) {
        if (!repository.existsById(accountId)){
            throw new ResourceNotFoundException("Account with ID" + " " + accountId + " " + "does not exist");
        }
        return repository.findById(accountId);
    }

    public List<Account> getAllAccounts() {
        if(repository.findAll().isEmpty()){
            throw new ResourceNotFoundException("No account found");
        }
        return repository.findAll();
    }

    public Account findByAccountType(String accountType) {
        if(repository.findByAccountType(accountType) == null){
            throw new ResourceNotFoundException("No account found");
        }
        return repository.findByAccountType(accountType);
    }

    public Account createAccount(Account account) {
        // Check if username already exist
        String username = account.getUsername();
        if (repository.findByUsername(username) != null) {
            throw new InvalidInputException(username + "is already in use");
        }

        // Check if email already exist
        String email = account.getEmail();
        if (repository.findByEmail(email) != null) {
            throw new InvalidInputException(email + "is already in use.");
        }
        // Save account to DB.
        return repository.save(account);
    }

    public void deleteAccountById(long accountId) {
        if(!repository.existsById(accountId)){
            throw new ResourceNotFoundException("No account with " + accountId + " found");
        }
        repository.deleteById(accountId);
    }

    public Account updateAccountById(Long accountId, Account account) {
        if (!repository.existsById(accountId)){
            throw new ResourceNotFoundException("No account with " + accountId + " found");
        }
        account.setId(accountId);
        return repository.save(account);
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
