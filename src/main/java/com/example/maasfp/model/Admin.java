/*package com.example.maasfp.model;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity(name = "account")
public class Admin {


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


}

 */