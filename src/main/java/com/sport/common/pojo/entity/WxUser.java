package com.sport.common.pojo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class WxUser {
    private Integer userId;
    private String gender;
    private String wxuserId;
    private String openId;
    private String nickName;
    private String phone;
    private String address;
    private String avatar;
    private Date createTime;
    private Date updateTime;
}
