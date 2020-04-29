package com.naclo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/index.html", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    @RequestMapping("/admin/{str}")
    public String admin(@PathVariable("str") String str) {
        return "admin/" + str;
    }

    @RequestMapping("/user/{str}")
    public String user(@PathVariable("str") String str) {
        return "user/" + str;
    }

    @RequestMapping("/error/{str}")
    public String error(@PathVariable("str") String str) {
        return "error/" + str;
    }

}
