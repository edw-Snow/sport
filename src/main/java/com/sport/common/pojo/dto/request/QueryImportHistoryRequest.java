package com.sport.common.pojo.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class QueryImportHistoryRequest implements Serializable {
    private List<String> ids;

    private Integer pageNo;

    private Integer pageSize;

    private Date startTime;

    private Date endTime;
}
