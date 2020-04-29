package com.naclo.service;

import com.naclo.dao.CustomerDao;
import com.naclo.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDao.queryByUsername(username);
        if (customer == null) {
            //log.warn("User: {} not found", login);
            throw new UsernameNotFoundException("User " + username + " was not found in db");
            //这里找不到必须抛异常
        }
        return new User(username, new BCryptPasswordEncoder().encode(customer.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
    }
}
