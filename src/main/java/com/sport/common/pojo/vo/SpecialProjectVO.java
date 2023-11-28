package com.sport.common.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class SpecialProjectVO implements Serializable {
    private Integer id;

    private String name;

    private Map<String, String> bizParams;
}
