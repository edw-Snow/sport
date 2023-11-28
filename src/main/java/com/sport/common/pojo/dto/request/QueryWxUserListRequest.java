package com.sport.common.pojo.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryWxUserListRequest implements Serializable {
    private List<String> ids;

    private String openId;

    private String phone;

    private Integer pageNo;

    private Integer pageSize;
}
