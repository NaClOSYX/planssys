package com.naclo.dao;

import com.naclo.pojo.seatNumView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SeatNumViewDao {
    List<seatNumView> getAllFirstSeatById(@Param("flightId")int flightId);

    List<seatNumView> getAllEconomySeatById(@Param("flightId")int flightId);


    int getAllFirstSeatCountById(@Param("flightId")int flightId);

    int getAllEconomySeatCountById(@Param("flightId")int flightId);

    int isSeatExistByIdAndSeatNum(@Param("flightId")int flightId,@Param("seatNum")String seatNum);
}
