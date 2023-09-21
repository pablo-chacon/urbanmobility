package com.example.maasfp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountUnitTests {

    /**
     * Test construction of Accounts object.
     * @throws Exception if any error occurs during the construction.
     */
    @Test
    public void testAccountsConstruction() throws Exception {
        // Create an Accounts object with the provided values.
        Account account = Account.builder()
                .id(1L)
                .username("john_doe")
                .contactInfo("john.doe@example.com")
                .paymentInfo("1234-5678-9012-3456")
                .accountType("premium")
                .build();

        // Verify that the Accounts object is constructed correctly.
        assertEquals(1L, account.getId(), "The ID was not set correctly.");
        assertEquals("john_doe", account.getUsername(), "The username was not set correctly.");
        assertEquals("john.doe@example.com", account.getContactInfo(), "The contact info was not set correctly.");
        assertEquals("1234-5678-9012-3456", account.getPaymentInfo(), "The payment info was not set correctly.");
        assertEquals("premium", account.getAccountType(), "The account type was not set correctly.");
    }

    /**
     * Test to ensure that the Accounts object throws an exception when the username is null.
     * Title: Null Username Test
     * Description: Exception is thrown when the username is null.
     * @throws Exception if any error occurs during the validation.
     */
    @Test
    public void testNullUsernameException() throws Exception {
        // Attempt to create an Accounts object with a null username.
        // This should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            Account.builder()
                    .id(1L)
                    .username(null)
                    .contactInfo("john.doe@example.com")
                    .paymentInfo("1234-5678-9012-3456")
                    .accountType("premium")
                    .build();
        }, "Expected an exception due to a null username.");
    }

    /**
     * Test to ensure that the Accounts object throws an exception when the account type is empty.
     * @throws Exception if any error occurs during the validation.
     */
    @Test
    public void testEmptyAccountTypeException() throws Exception {
        // Attempt to create an Accounts object with an empty account type.
        // This should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            Account.builder()
                    .id(1L)
                    .username("john_doe")
                    .contactInfo("john.doe@example.com")
                    .paymentInfo("1234-5678-9012-3456")
                    .accountType("")
                    .build();
        }, "Expected an exception due to an empty account type.");
    }

    /**
     * Test ensures the Accounts object equal another Accounts object.

     * @throws Exception Validation error.
     */
    @Test
    public void testAccountsEquality() throws Exception {
        // Create two Accounts objects with the same values.
        Account account1 = Account.builder()
                .id(1L)
                .username("john_doe")
                .contactInfo("john.doe@example.com")
                .paymentInfo("1234-5678-9012-3456")
                .accountType("premium")
                .build();

        Account account2 = Account.builder()
                .id(1L)
                .username("john_doe")
                .contactInfo("john.doe@example.com")
                .paymentInfo("1234-5678-9012-3456")
                .accountType("premium")
                .build();

        // Verify that the two Accounts objects are equal.
        assertEquals(account1, account2, "The two Accounts objects are not equal.");
    }
}