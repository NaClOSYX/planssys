package com.naclo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketView {
    int ticketId;
    String username;
    int flightId;
    String startCity;
    String endCity;
    Date startDate;
    Date startTime;
    Date endTime;
    String seatNum;
    int ticketPrice;
}
