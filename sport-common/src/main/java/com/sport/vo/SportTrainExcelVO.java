package com.sport.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelIgnoreUnannotated
public class SportTrainExcelVO implements Serializable {
    @ExcelProperty("序号")
    private String id;

    @ExcelProperty("日期")
    private String date;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("手机")
    private String phone;

    @ExcelProperty("100米")
    private String hundred;

    @ExcelProperty(index = 5)
    private String threeLevelJump1;

    @ExcelProperty(index = 6)
    private String threeLevelJump2;

    @ExcelProperty(index = 7)
    private String threeLevelJump3;

    @ExcelProperty(index = 8)
    private String shot1;

    @ExcelProperty(index = 9)
    private String shot2;

    @ExcelProperty(index = 10)
    private String shot3;

    @ExcelProperty(index = 11)
    private String football1;

    @ExcelProperty(index = 12)
    private String football2;

    @ExcelProperty(index = 13)
    private String football3;

    @ExcelProperty(index = 14)
    private String basketball1;

    @ExcelProperty(index = 15)
    private String basketball2;

    @ExcelProperty(index = 16)
    private String basketball3;

    @ExcelProperty(index = 17)
    private String dig;

    @ExcelProperty(index = 18)
    private String pass;

    @ExcelProperty(index = 19)
    private String height;

    @ExcelProperty("乒乓球")
    private String pingpong;

    @ExcelProperty("游泳")
    private String swimming;

}
