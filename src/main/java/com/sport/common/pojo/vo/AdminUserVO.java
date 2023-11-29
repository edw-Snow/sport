package com.sport.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserVO {
    private String name;
    private Integer adminId;
    private String adminToken;
    private String userName;
    private String gender;
    private String phone;
    private String idNumber;
    private String avatar;
    private Date createTime;
}
