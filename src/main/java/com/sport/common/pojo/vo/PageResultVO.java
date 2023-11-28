package com.sport.common.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResultVO<T> implements Serializable {
    private Long pageNo;

    private Long pageSize;

    private List<T> result;

    private Long total;

    private Long currentPage;
}
