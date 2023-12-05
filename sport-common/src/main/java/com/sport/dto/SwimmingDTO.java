package com.sport.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SwimmingDTO implements Serializable {
    private Integer poolSize;

    private Integer testType;

    private Integer swimmingType;

    private String swimming;
}
