package com.example.maasfp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity(name = "account")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, updatable = false)
    private String accountType;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private int paymentHistory;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private boolean isPaymentSet;


    public enum AccountType {
        ADMIN, USER, SUPPLIER
    }


}

/*
import jakarta.persistence.*;
import lombok.*;


 */