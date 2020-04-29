package com.naclo.controller;

import com.naclo.dao.CustomerDao;
import com.naclo.dao.TicketDao;
import com.naclo.dao.TicketViewDao;
import com.naclo.pojo.Customer;
import com.naclo.pojo.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;


@Controller
public class TicketViewController {
    @Autowired
    private TicketViewDao ticketViewDao;
    @Autowired
    private TicketDao ticketDao;

    @RequestMapping("/user/ticketManager")
    public String toTicketManager(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Collection<TicketView> ticketViews = ticketViewDao.queryByUsername(currentUserName);
        model.addAttribute("ticketViews", ticketViews);
        return "user/ticketManager";
    }
    @GetMapping("/deleteTicket/{ticketId}")
    public String deleteTicket(@PathVariable("ticketId")int ticketId) {
        System.out.println(ticketId);
ticketDao.deleteTicketById(ticketId);
        return "redirect:/user/ticketManager";
    }
}
