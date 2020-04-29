package com.naclo.dao;

import com.naclo.pojo.FlightView;
import com.naclo.pojo.TicketView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface FlightViewDao {

    List<FlightView> queryByCityAndDate(@Param("startCity") String startCity,
                                             @Param("endCity") String endCity,
                                             @Param("startDate") Date startDate);
    List<FlightView> queryByCity(@Param("startCity") String startCity,
                                 @Param("endCity") String endCity);
    List<FlightView> queryAll();
    FlightView queryById(@Param("flightId") int flightId);
}
