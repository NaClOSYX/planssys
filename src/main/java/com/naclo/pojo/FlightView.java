package com.naclo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightView {
    int flightId;
    String startCity;
    String endCity;
    Date startDate;
    Date startTime;
    Date endTime;
    String companyName;
    int firstClassNum;
    int firstPrice;
    int economyClassNum;
    int economyPrice;
}
