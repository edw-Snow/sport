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
public class WxUser {
    private Integer userId;
    private String gender;
    private String wxuserId;
    private String openid;
    private String nickName;
    private String phone;
    private String address;
    private String avatar;
    private String name;
    private Date createTime;
    private Date updateTime;
}
