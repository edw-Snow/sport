package com.sport.common.pojo.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ScoreQueryRequest implements Serializable {
    private Integer sex;

    private Double hundredUseTime;

    private Double threeLevelJump;

    private Double shot;

    private Integer specialProjectId;

    private Double specialProjectNum;

    private Integer wxuserId;

    private String openId;

    private Map<String, String> specialProjectBizParams;

    private Integer cultureScore;
}
