package com.example.maasfp.service;

import com.example.maasfp.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountServiceInterface {
    Optional<Account> getAccountById(long accountId);

    List<Account> getAllAccounts();

    Account findByAccountType(String accountType);

    Account createAccount(Account account);

    void deleteAccountById(long accountId);

    Account updateAccountById(Long accountId, Account account);

    Account saveAccount(Account account);
}
