package com.naclo.controller;

import com.naclo.dao.CustomerDao;
import com.naclo.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;


    @GetMapping("/user/userInfo")
    public String toUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Customer customer = customerDao.queryByUsername(currentUserName);
        model.addAttribute("customer", customer);
        return "user/userInfo";
    }

    @RequestMapping("/customerUpdate")
    public String register(@RequestParam("customerId") Integer customerId,
                           @RequestParam("username") String username,
                           @RequestParam("realName") String realName,
                           @RequestParam("nationality") String nationality,
                           @RequestParam("idCard") String idCard,
                           Model model) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setUsername(username);
        customer.setRealName(realName);
        customer.setNationality(nationality);
        customer.setIdCard(idCard);
        System.out.println(customer);
        Customer customer1 = customerDao.queryByUsername(username);
        System.out.println(customer1);
        System.out.println(customer);
        customerDao.updateCustomerById(customer);
        return "redirect:/user/userInfo";
    }


}
