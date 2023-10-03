/*package com.example.maasfp.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTypeUnitTests {

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

        Mockito.verify(mockData).add(Account.builder()
                .id(1L)
                .username("foo.ba")
                .accountType("USER")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build());


        mockData.add(Account.builder()
                .id(2L)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .paymentHistory(7)
                .paymentMethod("Swish")
                .isPaymentSet(true)
                .build());

        Mockito.verify(mockData).add(Account.builder()
                .id(2L)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .paymentHistory(7)
                .paymentMethod("Swish")
                .isPaymentSet(true)
                .build());

        assertEquals("PROVIDER", mockData.get(1).getAccountType(), "Account type not set correctly.");


        mockData.add(Account.builder()
                .id(3L)
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
                .id(4L)
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



        Mockito.verify(mockData).add(Account.builder()
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


        Mockito.verify(mockData).add(Account.builder()
                .id(1L)
                .username("foobar")
                .email("foo@bar.com")
                .paymentMethod("Credit Card")
                .accountType("")
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


    /**
     * Test to ensure that the Accounts object throws an exception when the username is null.
     * Title: Null Username Test
     * Description: Exception is thrown if username is null.
     * @throws Exception if error occurs during validation.
     */
  /*  @Test
    public void testNullUsernameException() throws Exception {
        // Attempt creation of Account with null username.
        assertThrows(IllegalArgumentException.class, () -> {

            Mockito.verify(mockData).add(Account.builder()
                    .id(1L)
                    .username(null)
                    .build());
        }, "Expected null username exception.");
    }
*/
    /**
     * Test Accounts object throws exception if account type is empty.
     * @throws Exception if error occurs during the validation.
     */
 /*   @Test
    public void MockTestEmptyAccountTypeException() throws Exception {
        // Attempt creation of empty account type.
        assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(mockData).add(Account.builder()
                    .id(1L)
                    .username("foobar")
                    .accountType("")
                    .email("foo@bar.com")
                    .phone("1234567890")
                    .paymentHistory(5)
                    .paymentMethod("Credit Card")
                    .isPaymentSet(true)
                    .build());
        }, "Expected empty account type exception.");
    }
*/
    /**
     * Test ensures the Accounts object equal another Accounts object.
     * @throws Exception Validation error.
     */

 /*   @Test
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
        // Verify non equal values.
        assertEquals(account1, account2, "Not equal accounts.");
    }
}
/*
  */