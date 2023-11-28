package com.sport.common.pojo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class VolleyBallDTO implements Serializable {
    public VolleyBallDTO(String dig, String pass, String height) {
        this.dig = dig;
        this.pass = pass;
        this.height = height;
    }

    private String dig;

    private String pass;

    private String height;
}
