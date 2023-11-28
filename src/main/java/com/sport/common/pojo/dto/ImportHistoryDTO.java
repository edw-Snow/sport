package com.sport.common.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ImportHistoryDTO implements Serializable {
    private String id;

    private Integer totalNum;

    private Integer successNum;

    private Integer failNum;

    private List<String> failPhoneList;

    private Date createTime;

    private Integer isDelete;
}
