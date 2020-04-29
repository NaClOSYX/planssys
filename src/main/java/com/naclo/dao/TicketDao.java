package com.naclo.dao;

import com.naclo.pojo.Customer;
import com.naclo.pojo.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TicketDao {
    int deleteTicketById(@Param("ticketId")int ticketId);

    int insertTicket(Ticket ticket);
}
