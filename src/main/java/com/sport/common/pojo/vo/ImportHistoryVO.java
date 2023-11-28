package com.sport.common.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ImportHistoryVO implements Serializable {
    private String id;

    private Integer totalNum;

    private Integer successNum;

    private Integer failNum;

    private List<String> failPhoneList;

    private Date createTime;

    private Integer isDelete;
}
