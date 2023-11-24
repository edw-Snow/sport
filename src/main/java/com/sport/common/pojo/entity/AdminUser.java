package com.sport.common.pojo.entity;

import lombok.Data;

@Data
public class AdminUser {
    private int userId;
    private String username;
    private String password;
    private String salt;
}
