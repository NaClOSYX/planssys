package com.naclo.dao;

import com.naclo.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface CustomerDao {
    Customer queryByUsername(@Param("username") String username);

    int insertCustomer(Customer customer);

    int updateCustomerById(Customer customer);
}