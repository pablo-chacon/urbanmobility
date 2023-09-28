package com.example.maasfp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTypeUnitTests {

    /**
     * Test construction of Accounts object.
     * @throws Exception if any error occurs during the construction.
     */
    @Test
    public void testAccountsConstruction() throws Exception {
        // Create an Accounts object with the provided values.
        Account account = Account.builder()
                .id(1L)
                .username("foobar")
                .email("foo@bar.com")
                .paymentMethod("Credit card")
                .accountType("provider")
                .build();

        // Verify that the Accounts object is constructed correctly.
        assertEquals(1L, account.getId(), "ID not set correctly.");
        assertEquals("foobar", account.getUsername(), "Username not set correctly.");
        assertEquals("foo@bar.com", account.getEmail(), "Email not set correctly.");
        assertEquals("Credit Card", account.getPaymentMethod(), "Payment method not set correctly.");
        assertEquals("premium", account.getAccountType(), "Account type not set correctly.");
    }

    /**
     * Test to ensure that the Accounts object throws an exception when the username is null.
     * Title: Null Username Test
     * Description: Exception is thrown if username is null.
     * @throws Exception if error occurs during validation.
     */
    @Test
    public void testNullUsernameException() throws Exception {
        // Attempt creation of Account with null username.
        assertThrows(IllegalArgumentException.class, () -> {
            Account.builder()
                    .id(1L)
                    .username(null)
                    .email("foo@bar.com")
                    .paymentMethod("Credit Card")
                    .accountType("User")
                    .build();
        }, "Expected null username exception.");
    }

    /**
     * Test Accounts object throws exception if account type is empty.
     * @throws Exception if error occurs during the validation.
     */
    @Test
    public void testEmptyAccountTypeException() throws Exception {
        // Attempt creation of empty account type.
        assertThrows(IllegalArgumentException.class, () -> {
            Account.builder()
                    .id(1L)
                    .username("foobar")
                    .email("foo@bar.com")
                    .paymentMethod("Credit Card")
                    .accountType("")
                    .build();
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