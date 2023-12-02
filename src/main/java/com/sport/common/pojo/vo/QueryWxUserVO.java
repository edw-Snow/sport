package com.sport.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryWxUserVO {
    private Integer userId;
    private String gender;
    private String wxuserId;
    private String name;
    private String phone;
    private String address;
    private String createTime;
    private String updateTime;
}
