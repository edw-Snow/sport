package com.sport.mapper;

import com.sport.pojo.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface TestMapper {
    @Select("SELECT * FROM `dish` WHERE id = 46")
    Dish search();
}
