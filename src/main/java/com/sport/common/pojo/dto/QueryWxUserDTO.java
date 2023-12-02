package com.sport.common.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryWxUserDTO {
    private String wxuserId;
    private String phone;
    private String name;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalTime beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalTime endTime;
    private Integer pageNum;
    private Integer pageSize;
    private int limit;

    public int getFormIndex() {
        if (pageNum < 1) return 0;
        if (this.pageSize < 1) this.pageSize = 10;
        return pageSize * (pageNum - 1);
    }
}
