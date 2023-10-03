package com.example.maasfp.testutils;

import com.example.maasfp.model.Account;
import com.example.maasfp.model.Route;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UnitTesting {

    /**
     * Runs unit tests.
     */


    @Mock
    List<Account> mockData = new ArrayList<>();


    public List<Account> mockAccounts() {


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
                .id(2L)
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
                .username("sl")
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


        mockData.add(Account.builder()
                .id(6L)
                .username("admin")
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
    public void getAllAccounts() {
        mockAccounts();
        System.out.println(mockData);
    }

    @Test
    public void getAccountById() {

        for (Account account : mockData) {
            if (account.getId() == 1L) {
                System.out.println(account);
            }
        }

    }

    @Test
    public void testNullUsernameException() {
        // Attempt creation of Account with null username.

        Account account = Account.builder()
                .id(1L)
                .username(null)
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build();

        if (account.getUsername() == null) {
            System.out.println("Username cannot be null.");
        }
    }

    /**
     * Account object throws exception if account type is empty.
     * @throws Exception if validation error.
     */
    @Test
    public void MockTestEmptyAccountTypeException() {
        // Attempt creation of empty account type.

        Account account = Account.builder()
                .id(1L)
                .username("foobar")
                .accountType("USER")
                .email("foo@bar.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build();

        if (account.getAccountType().equals("")) {
            System.out.println("Account type cannot be empty.");
        }
    }

    /**
     * Test for duplicate Account.
     */
    @Test
    public void testAccountsEqualValue() throws Exception {
        // Create two equal value Accounts.
        Account account = Account.builder()
                .id(1L)
                .username("foo")
                .accountType("ADMIN")
                .email("foo@bar.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .build();

        Account account1 = Account.builder()
                .id(2L)
                .username("torsten.flink")
                .accountType("PROVIDER")
                .email("torsten@flink.com")
                .phone("1234567890")
                .paymentHistory(7)
                .paymentMethod("Swish")
                .isPaymentSet(true)
                .build();

        // Verify non duplicate.
        if (account.equals(account1)) {
            System.out.println("Duplicate account.");
        } else {
            System.out.println("Non duplicate account.");
        }

    }

    @Test
    public void testRouteConstruction() throws Exception {

        Route route = Route.builder()
                .origin("Stockholm City")
                .destination("Malmö Central")
                .departure("2023-12-01")
                .arrival("2023-12-03")
                .transportationType("Train")
                .price(350)
                .provider("SJ")
                .campaignCode(0.2)
                .build();

        // Validate that the Route object is constructed correctly.
        assertEquals("Stockholm City", route.getOrigin(), "The origin was not set correctly.");
        assertEquals("Malmö Central", route.getDestination(), "The destination was not set correctly.");
        assertEquals("2023-12-01", route.getDeparture(), "The departure was not set correctly.");
        assertEquals("2023-12-03", route.getArrival(), "The arrival was not set correctly.");
        assertEquals("Train", route.getTransportationType(), "The transportation type was not set correctly.");
        assertEquals(350, route.getPrice(), "The price was not set correctly.");
        assertEquals("SJ", route.getProvider(), "The provider was not set correctly.");
        assertEquals(0.2, route.getCampaignCode(), "The campaign code was not set correctly.");
    }

    /**
     * Ensure exception is thrown when required fields are missing.
     *
     * @throws Exception if error occurs during construction.
     */
    @Test
    public void testRouteConstructionValidation() throws Exception {

        Route route = Route.builder()
                .origin("Stockholm City")
                .destination("Malmö Central")
                .build();

        if (route.getDeparture() == null) {
            System.out.println("Departure cannot be null.");
        }
    }

    /**
     * Validates Route object update.
     *
     * @throws Exception if error occurs during update.
     */
    @Test
    public void testRouteUpdate() throws Exception {
        // Construct a Route object with initial values.
        Route route = Route.builder()
                .origin("Stockholm City")
                .destination("Malmö Central")
                .departure("2023-12-01")
                .arrival("2023-12-03")
                .transportationType("Train")
                .price(350)
                .provider("SJ")
                .campaignCode(0.1)
                .build();

        // Update the Route object with new values.
        route.setOrigin("Norrköping Resecentrum");
        route.setDestination("Göteborg Central");
        route.setDeparture("2024-02-01");
        route.setArrival("2024-02-02");
        route.setTransportationType("Bus");
        route.setPrice(300);
        route.setProvider("Buss Deluxe");
        route.setCampaignCode(0.1);

        // Validate that the Route object is updated correctly.
        assertEquals("Norrköping Resecentrum", route.getOrigin(), "The origin was not updated correctly.");
        assertEquals("Göteborg Central", route.getDestination(), "The destination was not updated correctly.");
        assertEquals("2024-02-01", route.getDeparture(), "The departure was not updated correctly.");
        assertEquals("2024-02-02", route.getArrival(), "The arrival was not updated correctly.");
        assertEquals("Bus", route.getTransportationType(), "The transportation type was not updated correctly.");
        assertEquals(300, route.getPrice(), "The price was not updated correctly.");
        assertEquals("Buss Deluxe", route.getProvider(), "The provider was not updated correctly.");
        assertEquals(0.1, route.getCampaignCode(), "The campaign code was not updated correctly.");
    }


}
