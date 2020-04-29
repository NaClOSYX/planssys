package com.naclo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.naclo.dao.*;
import com.naclo.pojo.Customer;
import com.naclo.pojo.FlightView;
import com.naclo.pojo.Ticket;
import com.naclo.utils.SeatNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseController {
    @Autowired
    CustomerDao customerDao;
    @Autowired
    SeatNumViewDao seatNumViewDao;
    @Autowired
    TicketDao ticketDao;
    @Autowired
    SeatNumUtil seatNumUtil;
    @Autowired
    FlightViewDao flightViewDao;
    
    @RequestMapping("/purchase/economy/{flightId}")
    public String purchaseEconomy(@PathVariable("flightId") int flightId,Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserName = authentication.getName();
        Customer customer = customerDao.queryByUsername(currentUserName);

        Ticket ticket = new Ticket();
        ticket.setCustomerId(customer.getCustomerId());
        ticket.setFlightId(flightId);

        //根据vip等级打折
        Integer vipLevelCode = customer.getVipLevelCode();
        double disCount = seatNumUtil.getDisCount(vipLevelCode);
        FlightView flightView = flightViewDao.queryById(flightId);
        int economyPrice = flightView.getEconomyPrice();
        int price= (int) (economyPrice*disCount);
        ticket.setTicketPrice(price);

        //随机生成座位号
        String seatNum = seatNumUtil.randomSeatNum(flightId, "E");
        ticket.setSeatNum(seatNum);

        ticketDao.insertTicket(ticket);
        model.addAttribute("seatNum",seatNum);
        return "success";
    }

    @RequestMapping("/purchase/first/{flightId}")
    public String purchaseFirst(@PathVariable("flightId") int flightId,Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserName = authentication.getName();
        Customer customer = customerDao.queryByUsername(currentUserName);

        Ticket ticket = new Ticket();
        ticket.setCustomerId(customer.getCustomerId());
        ticket.setFlightId(flightId);
        
        //根据vip等级打折
        Integer vipLevelCode = customer.getVipLevelCode();
        double disCount = seatNumUtil.getDisCount(vipLevelCode);
        FlightView flightView = flightViewDao.queryById(flightId);
        int firstPrice = flightView.getFirstPrice();
        int price= (int) (firstPrice*disCount);
        ticket.setTicketPrice(price);

        //随机生成座位号
        String seatNum = seatNumUtil.randomSeatNum(flightId, "F");
        ticket.setSeatNum(seatNum);

        ticketDao.insertTicket(ticket);
        model.addAttribute("seatNum",seatNum);
        return "success";
    }
}
