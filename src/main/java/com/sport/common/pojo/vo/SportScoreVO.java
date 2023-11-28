package com.sport.common.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class SportScoreVO implements Serializable {
    public static Map<String, String> e2ChineseSportScoreMap = new HashMap<>();
    public static Map<String, String> c2EnglishSportScoreMap = new HashMap<>();

    static {
        e2ChineseSportScoreMap.put("dig", "垫球");
        e2ChineseSportScoreMap.put("pass", "传球");
        e2ChineseSportScoreMap.put("high", "摸高");
        e2ChineseSportScoreMap.put("type", "泳姿");
        e2ChineseSportScoreMap.put("poolSize", "泳池大小");
        e2ChineseSportScoreMap.put("testType", "考试类型");

        c2EnglishSportScoreMap.put("垫球", "dig");
        c2EnglishSportScoreMap.put("传球", "pass");
        c2EnglishSportScoreMap.put("摸高", "high");
        c2EnglishSportScoreMap.put("泳姿", "type");
        c2EnglishSportScoreMap.put("泳池大小", "poolSize");
        c2EnglishSportScoreMap.put("考试类型", "testType");
    }

    private Integer id;

    private String sex;

    private Integer wxuserId;

    private String openId;

    private String hundred;

    private String threeLevelJump;

    private String shot;

    private Integer specialProjectId;

    private String specialProjectName;

    private String basicScore;

    private String specialProjectScore;

    private String totalScore;

    private Date createTime;

    private Date updateTime;

    private Map<String, String> features;
}
