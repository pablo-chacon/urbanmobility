package com.example.maasfp.repository;

import com.example.maasfp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
    Account findByEmail(String email);
    Account findByAccountType(String accountType);
    Account createAccount(Account account);

}
