package com.sport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

