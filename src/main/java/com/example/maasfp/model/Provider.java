package com.example.maasfp.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Provider {

    public String id;
    public String extId;
    public String name;
    public String lat;
    public String lon;
    public String stops;

}
