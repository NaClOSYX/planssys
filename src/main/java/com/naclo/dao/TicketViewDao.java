package com.naclo.dao;

import com.naclo.pojo.Customer;
import com.naclo.pojo.Ticket;
import com.naclo.pojo.TicketView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Mapper
@Repository
public interface TicketViewDao {
    Collection<TicketView> queryByUsername(@Param("username") String username);

}