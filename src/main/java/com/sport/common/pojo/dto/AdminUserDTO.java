package com.sport.common.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminUserDTO implements Serializable {
    private String username;
    private String password;
}
