package com.example.maasfp.model;

/**
 * User POJO
 * params: username, email, paymentMethod, paymentHistory, activeBookings, accountType.
 * Account types: ADMIN, USER, CONTRACTOR.
 */


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class User {
    private String username;
    private String email;
    private String paymentMethod;
    private String paymentHistory;
    private String activeBookings;
    private AccountType accountType;

    public enum AccountType {
        ADMIN,
        USER,
        CONTRACTOR
    }


}