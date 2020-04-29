package com.naclo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airline {
    private Integer airlineId;
    private String startCity;
    private String endCity;
    private Integer mileage;
}