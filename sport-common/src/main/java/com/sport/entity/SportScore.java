package com.sport.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SportScore {
    private Integer scoreId;
    private Integer userId;
    private String hundred;
    private String shot;
    private String threeLevelJump;
    private Double specialProjectScore;
    private String features;
    private Double totalScore;
    private Double basicScore;
    private Boolean isDelete;
    private Date createTime;
}

