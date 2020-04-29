package com.naclo.utils;


import com.naclo.dao.FlightViewDao;
import com.naclo.dao.SeatNumViewDao;
import com.naclo.pojo.FlightView;
import com.naclo.pojo.seatNumView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SeatNumUtil {

    @Autowired
    SeatNumViewDao seatNumViewDao;
    @Autowired
    FlightViewDao flightViewDao;

    public String randomSeatNum(int flightId, String classLevel) {
        String seatNum = classLevel;

        FlightView flightView = flightViewDao.queryById(flightId);
        List<seatNumView> allEconomySeat = seatNumViewDao.getAllEconomySeatById(flightId);
        List<seatNumView> allFirstSeat = seatNumViewDao.getAllFirstSeatById(flightId);
        int firstClassNum = flightView.getFirstClassNum();
        int economyClassNum = flightView.getEconomyClassNum();
        while (true) {
            if (classLevel == "F") {
                seatNum = "F" + randomNum(firstClassNum);
                if (seatNumViewDao.isSeatExistByIdAndSeatNum(flightId, seatNum) == 0)
                    return seatNum;
                else
                    continue;
            }
            if (classLevel == "E") {
                seatNum = "E" + randomNum(economyClassNum);
                if (seatNumViewDao.isSeatExistByIdAndSeatNum(flightId, seatNum) == 0)
                    return seatNum;
                else
                    continue;
            }
        }
    }

    public String randomNum(int max) {
        int num = (int) (Math.random() * (max + 1));
        String n;
        if (num < 10)
            n = "00" + num;
        else if (num < 100)
            n = "0" + num;
        else
            n = num + "";
        return n;
    }

    public double getDisCount(int vipLevelCode) {
        double disCount;
        switch (vipLevelCode) {
            case 0:
                disCount = 1;
                break;
            case 1:
                disCount = 0.9;
                break;
            case 2:
                disCount = 0.8;
                break;
            case 3:
                disCount = 0.7;
                break;
            default:
                disCount = 0;
        }
        return disCount;
    }
}
