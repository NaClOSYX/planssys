package com.naclo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Integer ticketId;
    private Integer customerId;
    private Integer flightId;
    private String seatNum;
    private Date purchaseTime;
    private Integer ticketPrice;
    private Integer ticketStateCode;
}