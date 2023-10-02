package com.example.maasfp.service;

import com.example.maasfp.exceptions.InvalidInputException;
import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
    private final AccountRepository repository;


    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    List<Account> accounts = new ArrayList<>();



    @Override
    public Optional<Account> getAccountById(long accountId) {

        Account account = Account.builder()
                .id(1L)
                .username("foo.bar")
                .accountType("USER")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build();

        if (!repository.existsById(account.getId())){
            throw new ResourceNotFoundException("Account with ID" + " " + accountId + " " + "does not exist");
        }
        return repository.findById(accountId);
    }

    @Override
    public List<Account> getAllAccounts() {
        if(repository.findAll().isEmpty()){
            throw new ResourceNotFoundException("No account found");
        }
        return repository.findAll();
    }

    @Override
    public Account findByAccountType(String accountType) {
        if(repository.findByAccountType(accountType) == null){
            throw new ResourceNotFoundException("No account found");
        }
        return repository.findByAccountType(accountType);
    }

    @Override
    public Account createAccount(Account account) {
        // Check if username already exist
        String username = account.getUsername();
        if (repository.findByUsername(username) != null) {
            throw new InvalidInputException(username + "is already in use");
        } else if (username == null) {
            throw new InvalidInputException("Username cannot be null");
        } else if (username.length() < 3) {
            throw new InvalidInputException("Username must be at least 3 characters long");
        }

        // Check if email already exist
        String email = account.getEmail();
        if (repository.findByEmail(email) != null) {
            throw new InvalidInputException(email + "is already in use.");
        }
        // Save account to DB.
        return repository.save(account);
    }

    @Override
    public void deleteAccountById(long accountId) {
        if(!repository.existsById(accountId)){
            throw new ResourceNotFoundException("No account with " + accountId + " found");
        }
        repository.deleteById(accountId);
    }

    @Override
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
        Account account = Account.builder()
                .id(1L)
                .username("foo.bar")
                .accountType("USER")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build();

        if (!repository.existsById(accountId)){
            throw new ResourceNotFoundException("No account with " + accountId + " found");
        }
        repository.delete(account);
    }
}
