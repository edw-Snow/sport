package com.sport.common.pojo.entity;

import lombok.Data;

import lombok.Data;
import java.util.Date;

@Data
public class AdminUser {
    private Integer adminId;
    private String name;
    private String salt;
    private String username;
    private String password;
    private String gender;
    private String phone;
    private String idNumber;
    private String avatar;
    private Date createTime;
}

