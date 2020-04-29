package com.naclo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private Integer flightId;
    private Object startDate;
    private Object startTime;
    private Object endTime;
    private Integer firstPrice;
    private Integer economyPrice;
    private Integer planeId;
    private Integer airlineId;
    private Integer companyId;
    private Integer flightStateCode;
}