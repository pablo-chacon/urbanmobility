package com.example.maasfp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.JAVA_OBJECT)
    private Long id;

    private String origin;
    private String destination;
    private String departure;
    private String arrival;
    private String transportationType;
    private int price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String provider;
    private double campaignCode;

}