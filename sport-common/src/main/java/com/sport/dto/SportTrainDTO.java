package com.sport.dto;

import com.sport.entity.WxUser;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
public class SportTrainDTO implements Serializable {
    public SportTrainDTO() {
        this.featureMap.put("basicScore", "0");
        this.featureMap.put("specialProjectScore", "0");
        this.featureMap.put("totalScore", "0");
        this.featureMap.put("hundredScore", "0");
        this.featureMap.put("threeLevelJumpScore", "0");
        this.featureMap.put("shotScore", "0");
        this.featureMap.put("footballScore", "0");
        this.featureMap.put("basketballScore", "0");
        this.featureMap.put("volleyballScore", "0");
        this.featureMap.put("pingpongScore", "0");
        this.featureMap.put("swimmingScore", "0");
    }

    private Integer id;

    private Integer sex;

    private Date date;

    private String name;

    private String phone;

    private WxUser wxUser;

    private String hundred;

    private List<String> threeLevelJumpList = new ArrayList<>();

    private List<String> shotList = new ArrayList<>();

    private List<String> footballList = new ArrayList<>();

    private List<String> basketBallList = new ArrayList<>();

    private VolleyBallDTO volleyball;

    private String pingpong;

    private SwimmingDTO swimming;

    private Map<String, String> featureMap = new HashMap<>();

    private Date createTime;

    // 导入记录id
    private String importId;
}
