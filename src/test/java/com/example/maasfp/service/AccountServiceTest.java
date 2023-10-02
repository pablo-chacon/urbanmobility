package com.example.maasfp.service;

import com.example.maasfp.model.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {


    @Mock
    List<Account> mockData = new ArrayList<>();

    @Test
    public List<Account> MockAccounts() {
        mockData.add(Account.builder()
                .id(1L)
                .username("foo.bar")
                .accountType("USER")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build());

        mockData.add(Account.builder()
                .id(1L)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .paymentHistory(7)
                .paymentMethod("Swish")
                .isPaymentSet(true)
                .build());

        mockData.add(Account.builder()
                .id(3L)
                .username("sj")
                .accountType("PROVIDER")
                .email("support@sj.se")
                .phone("+46666666666")
                .paymentHistory(3)
                .paymentMethod("bank transfer")
                .isPaymentSet(false)
                .build());

        mockData.add(Account.builder()
                .id(1L)
                .username(null)
                .accountType("ADMIN")
                .email("admin@urbanmobility.com")
                .phone("124522890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build());

        return mockData;
    }

    @Test
    void getAccountById() {
        mockData.get(2);
    }

    @Test
    void getAllAccounts() {
        System.out.println(mockData);
    }

    @Test
    void findByAccountType() {
        for (Account account : mockData)
            if (account.getAccountType().equals("USER")) {
                System.out.println(account);
            }
    }

    @Test
    void createAccount() {
        mockData.add(Account.builder()
                .id(1L)
                .username(null)
                .accountType("ADMIN")
                .email("admin@urbanmobility.com")
                .phone("124522890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build());
    }

    @Test
    void deleteAccountById() {
        mockData.remove(1);
    }

    @Test
    void updateAccountById() {

        mockData.add(Account.builder()
                .id(mockData.get(1).getId())
                .username("sj")
                .accountType("PROVIDER")
                .email("support@sj.se")
                .phone("+46666666666")
                .paymentHistory(3)
                .paymentMethod("bank transfer")
                .isPaymentSet(false)
                .build());
    }

}



