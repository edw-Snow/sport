package com.sport.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SportTrainExcelDTO implements Serializable {

    private Date date;

    private String name;

    private String phone;

    private String hundred;

    private List<String> threeLevelJumpList = new ArrayList<>();

    private List<String> shotList = new ArrayList<>();

    private List<String> footballList = new ArrayList<>();

    private List<String> basketBallList = new ArrayList<>();

    private VolleyBallDTO volleyball;

    private String pingpong;

    private String swimming;

}
