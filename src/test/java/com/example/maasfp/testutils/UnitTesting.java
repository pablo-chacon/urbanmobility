package com.example.maasfp.testutils;

import com.example.maasfp.model.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UnitTesting {
    /**
     * Runs unit tests.
     */


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
                .id(2L)
                .username("sl")
                .accountType("PROVIDER")
                .email("provider@sl.se")
                .phone("9876543210")
                .paymentHistory(10)
                .paymentMethod("post-giro")
                .isPaymentSet(true)
                .build());


        Mockito.verify(mockData).add(Account.builder()
                .id(2L)
                .username("SL")
                .accountType("PROVIDER")
                .email("provider@sl.se")
                .phone("9876543210")
                .paymentHistory(10)
                .paymentMethod("post-giro")
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

        Mockito.verify(mockData).add(Account.builder()
                .id(3L)
                .username("sj")
                .accountType("PROVIDER")
                .email("foobar@barfoo.se")
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


        mockData.add(Account.builder()
                .id(2L)
                .username("bar.foo")
                .accountType("USER")
                .email("barfoo@foo.com")
                .phone("+469876543210")
                .paymentHistory(10)
                .paymentMethod("PayPal")
                .isPaymentSet(true)
                .build());

        mockData.add(Account.builder()
                .id(3L)
                .username("torsten.bengtsson")
                .accountType("USER")
                .email("torsten.bengtsson@email.com")
                .phone("5893402755")
                .paymentHistory(3)
                .paymentMethod("Credit Card")
                .isPaymentSet(false)
                .build());


        return mockData;
    }

    @Test
    public void getAccountById() {
        mockData.get(2);
        System.out.println("Account by ID: " + mockData.get(2));
    }

    @Test
    public void testNullUsernameException() throws Exception {
        // Attempt creation of Account with null username.
        assertThrows(IllegalArgumentException.class, () -> {

            Mockito.verify(mockData).add(Account.builder()
                    .id(1L)
                    .username("foo.bar")
                    .email("foobar@email.com")
                    .phone("1234567890")
                    .paymentHistory(5)
                    .paymentMethod("Credit Card")
                    .isPaymentSet(true)
                    .build());
        }, "Expected null username exception.");
    }

    /**
     * Account object throws exception if account type is empty.
     * @throws Exception if validation error.
     */
    @Test
    public void MockTestEmptyAccountTypeException() throws Exception {
        // Attempt creation of empty account type.
        assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(mockData).add(Account.builder()
                    .id(1L)
                    .username("foobar")
                    .accountType(null)
                    .email("foo@bar.com")
                    .phone("1234567890")
                    .paymentHistory(5)
                    .paymentMethod("Credit Card")
                    .isPaymentSet(true)
                    .build());
        }, "Expected empty account type exception.");
    }

    /**
     * Test for duplicate Account.
     * @throws Exception Validation error.
     */
    @Test
    public void testAccountsEqualValue() throws Exception {
        // Create two equal value Accounts.
        Account account1 = Account.builder()
                .id(1L)
                .username("foo")
                .accountType("ADMIN")
                .email("foo@bar.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .build();

        Account account2 = Account.builder()
                .id(1L)
                .username("foo")
                .accountType("ADMIN")
                .email("foo@bar.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .build();
        // Verify non duplicate.
        assertEquals(account1, account2, "Not equal accounts.");
    }

    public void runUnitTests() {
        UnitTesting unitTesting = new UnitTesting();
        unitTesting.runUnitTests();
    }
}
