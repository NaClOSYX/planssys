package com.naclo.controller;

import com.naclo.dao.CustomerDao;
import com.naclo.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/registers")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("realName") String realName,
                           @RequestParam("nationality") String nationality,
                           @RequestParam("idCard") String idCard,
                           Model model) {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setRealName(realName);
        customer.setNationality(nationality);
        customer.setIdCard(idCard);
        Customer customer1 = customerDao.queryByUsername(username);
        if (customer1 != null) {
            model.addAttribute("msg", "用户名已存在");
            return "forward:register";
        }
        customerDao.insertCustomer(customer);
        return "redirect:/index";
    }


}
