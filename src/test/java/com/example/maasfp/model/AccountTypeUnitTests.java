package com.example.maasfp.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTypeUnitTests {

    @Mock
    List<Account> mockData = new ArrayList<>();
    @Spy
    List<Account> spyData = new ArrayList<>();

    @Test
    public  List<Account> MockAccounts() {


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

        Mockito.verify(mockData).add(Account.builder()
                .id(1L)
                .username("bar.foo")
                .accountType("USER")
                .email("barfoo@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build());

        assertEquals(1L, mockData.get(0).getId(), "ID not set correctly.");
        assertEquals("foo.bar", mockData.get(0).getUsername(), "Username not set correctly.");
        assertEquals("USER", mockData.get(0).getAccountType(), "Account type not set correctly.");
        assertEquals("foobar@email.com", mockData.get(0).getEmail(), "Email not set correctly.");
        assertEquals("1234567890", mockData.get(0).getPhone(), "Phone method not set correctly.");
        assertEquals(5, mockData.get(0).getPaymentHistory(), "Payment history not set correctly.");
        assertEquals("Credit Card", mockData.get(0).getPaymentMethod(), "Payment method not set correctly.");
        assertEquals(true, mockData.get(0).isPaymentSet(), "Payment set not set correctly.");


        spyData.add(Account.builder()
                .id(1L)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .build());

        Mockito.verify(spyData).add(Account.builder()
                .id(1L)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .build());

        assertEquals("PROVIDER", spyData.get(1).getAccountType(), "Account type not set correctly.");


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

        assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(mockData).add(Account.builder()
                    .id(2L)
                    .username(null)
                    .accountType("PROVIDER")
                    .email("provider@sl.se")
                    .phone("9876543210")
                    .paymentHistory(10)
                    .paymentMethod("post-giro")
                    .isPaymentSet(true)
                    .build());
        }, "Expected null username exception.");

        Mockito.verify(mockData).add(Account.builder()
                .id(2L)
                .email("provider@sl.se")
                .build());

        assertEquals("provider@sl.se", mockData.get(1).getAccountType(), "Email not set correctly.");

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

        assertEquals("+46666666666", mockData.get(0).getPhone(), "Phone not set correctly.");


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


        assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(mockData).add(Account.builder()
                    .id(1L)
                    .username(null)
                    .build());
        }, "Expected null username exception.");


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

        assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(mockData).add(Account.builder()
                    .id(1L)
                    .username("foobar")
                    .email("foo@bar.com")
                    .paymentMethod("Credit Card")
                    .accountType("")
                    .build());
        }, "Expected empty account type exception.");


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



    /**
     * Test to ensure that the Accounts object throws an exception when the username is null.
     * Title: Null Username Test
     * Description: Exception is thrown if username is null.
     * @throws Exception if error occurs during validation.
     */
    @Test
    public void spyTestNullUsernameException() throws Exception {
        // Attempt creation of Account with null username.
        assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(spyData).add(Account.builder()
                    .id(1L)
                    .username(null)
                    .build());
        }, "Expected null username exception.");
    }

    /**
     * Test Accounts object throws exception if account type is empty.
     * @throws Exception if error occurs during the validation.
     */
    @Test
    public void MockTestEmptyAccountTypeException() throws Exception {
        // Attempt creation of empty account type.
        assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(mockData).add(Account.builder()
                    .id(1L)
                    .username("foobar")
                    .accountType("USER")
                    .email("foo@bar.com")
                    .phone("1234567890")
                    .paymentHistory(5)
                    .paymentMethod("Credit Card")
                    .isPaymentSet(true)
                    .build());
        }, "Expected empty account type exception.");
    }

    /**
     * Test ensures the Accounts object equal another Accounts object.
     * @throws Exception Validation error.
     */
    @Test
    public void testAccountsEquality() throws Exception {
        // Create two equal value Accounts.
        Account account1 = Account.builder()
                .id(1L)
                .username("foo")
                .email("foo@bar.com")
                .paymentMethod("Credit Card")
                .accountType("ADMIN")
                .build();

        Account account2 = Account.builder()
                .id(1L)
                .username("foo")
                .email("foo@bar.com")
                .paymentMethod("Credit Card")
                .accountType("ADMIN")
                .build();
        // Verify that the two Accounts objects are equal.
        assertEquals(account1, account2, "Not equal accounts.");
    }
}