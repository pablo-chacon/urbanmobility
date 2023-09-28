/*package com.example.maasfp.model;

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
public class Provider {


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


    public static List<Provider> generateMockData() {
        List<Provider> mockData = new ArrayList<>();

        mockData.add(Provider.builder()
                .id(1L)
                .username("foo.bar")
                .accountType("User")
                .email("foobar@email.com")
                .phone("1234567890")
                .paymentHistory(5)
                .paymentMethod("Credit Card")
                .isPaymentSet(true)
                .build());

            mockData.add(Provider.builder()
                    .id(1L)
                    .username("foo.bar")
                    .accountType("USER")
                    .email("foobar@foo.com")
                    .phone("1234567890")
                    .paymentHistory(5)
                    .paymentMethod("Credit Card")
                    .isPaymentSet(true)
                    .build());

            mockData.add(Provider.builder()
                    .id(2L)
                    .username("sl")
                    .accountType("PROVIDER")
                    .email("provider@sl.se")
                    .phone("9876543210")
                    .paymentHistory(10)
                    .paymentMethod("post-giro")
                    .isPaymentSet(true)
                    .build());

            mockData.add(Provider.builder()
                    .id(3L)
                    .username("sj")
                    .accountType("provider")
                    .email("support@sj.se")
                    .phone("+46666666666")
                    .paymentHistory(3)
                    .paymentMethod("bank transfer")
                    .isPaymentSet(false)
                    .build());

            mockData.add(Provider.builder()
                    .id(1L)
                    .username("superuser")
                    .accountType("ADMIN")
                    .email("admin@urbanmobility.com")
                    .phone("124522890")
                    .paymentHistory(5)
                    .paymentMethod("Credit Card")
                    .isPaymentSet(true)
                    .build());

            mockData.add(Provider.builder()
                    .id(2L)
                    .username("bar.foo")
                    .accountType("USER")
                    .email("barfoo@foo.com")
                    .phone("+469876543210")
                    .paymentHistory(10)
                    .paymentMethod("PayPal")
                    .isPaymentSet(true)
                    .build());

            mockData.add(Provider.builder()
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
*/