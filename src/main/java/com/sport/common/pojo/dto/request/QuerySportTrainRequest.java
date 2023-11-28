package com.sport.common.pojo.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class QuerySportTrainRequest implements Serializable {
    private List<Integer> ids;

    private Integer wxuserId;

    private String openId;

    private Date startTime;

    private Date endTime;

    private String phone;

    private Integer pageNo;

    private Integer pageSize;
}
