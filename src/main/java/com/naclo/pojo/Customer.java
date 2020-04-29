package com.naclo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer customerId;
    private String username;
    private String password;
    private String realName;
    private String idCard;
    private String nationality;
    private String sex;
    private Integer mileage;
    private Integer vipLevelCode;
}