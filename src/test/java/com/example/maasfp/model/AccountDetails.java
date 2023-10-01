package com.example.maasfp.model;


import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class AccountDetails {

    /**
     * Mock data for AccountDetails
     *
     * @return List<Account>
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
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .phone("1234567890")
                .build());

       /* Mockito.verify(mockData).add(Account.builder()
                .id(1L)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .paymentHistory(7)
                .paymentMethod("Swish")
                .isPaymentSet(true)
                .build());

        assertEquals("PROVIDER", mockData.get(1).getAccountType(), "Account type not set correctly.");*/
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


        /*Mockito.verify(mockData).add(Account.builder()
                .id(2L)
                .username("SL")
                .accountType("PROVIDER")
                .email("provider@sl.se")
                .phone("9876543210")
                .paymentHistory(10)
                .paymentMethod("post-giro")
                .isPaymentSet(true)
                .build());*/


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

        /*Mockito.verify(mockData).add(Account.builder()
                .id(3L)
                .username("sj")
                .accountType("PROVIDER")
                .email("foobar@barfoo.se")
                .phone("+46666666666")
                .paymentHistory(3)
                .paymentMethod("bank transfer")
                .isPaymentSet(false)
                .build());

        assertEquals("+46666666666", mockData.get(0).getPhone(), "Phone not set correctly.");*/
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



       /* Mockito.verify(mockData).add(Account.builder()
                .id(1L)
                .username(null)
                .accountType("ADMIN")
                .email("admin@urbanmobility.com")
                .phone("124522890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build());*/


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

}
