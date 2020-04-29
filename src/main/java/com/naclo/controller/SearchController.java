package com.naclo.controller;

import com.naclo.dao.FlightViewDao;
import com.naclo.dao.SeatNumViewDao;
import com.naclo.pojo.FlightView;
import com.naclo.pojo.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    FlightViewDao flightViewDao;
    @Autowired
    SeatNumViewDao seatNumViewDao;

    @RequestMapping("/searchCity")
    public String searchCity(@RequestParam("startCity") String startCity,
                             @RequestParam("endCity") String endCity,
                             @RequestParam("startDate") String startDate,
                             Model model) throws ParseException {
        List<FlightView> flightViews;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(startDate);
        flightViews = flightViewDao.queryByCityAndDate(startCity, endCity, date);
        if (flightViews.size() == 0) {
            flightViews = flightViewDao.queryByCity(startCity, endCity);
        }
        model.addAttribute("flightViews", flightViews);
        return "/index";
    }

    @RequestMapping("/")
    public String showAllFlights(Model model) {
        List<FlightView> flightViews = flightViewDao.queryAll();
        model.addAttribute("flightViews", flightViews);
        return "/index";
    }

    @RequestMapping("/flightInfo/{flightId}")
    public String deleteTicket(@PathVariable("flightId") int flightId, Model model) {
        FlightView flightView = flightViewDao.queryById(flightId);

        int countFirstSeat = seatNumViewDao.getAllFirstSeatCountById(flightId);
        int countEconomySeat = seatNumViewDao.getAllEconomySeatCountById(flightId);

        int restFirstSeat = flightView.getFirstClassNum() - countFirstSeat;
        int restEconomySeat = flightView.getEconomyClassNum() - countEconomySeat;

        model.addAttribute("flightView", flightView);
        model.addAttribute("restFirstSeat", restFirstSeat);
        model.addAttribute("restEconomySeat", restEconomySeat);

        return "flightInfo";
    }
}
