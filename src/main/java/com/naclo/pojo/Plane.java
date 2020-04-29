package com.naclo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    private Integer planeId;
    private String planeType;
    private Integer firstClassNum;
    private Integer economyClassNum;
}