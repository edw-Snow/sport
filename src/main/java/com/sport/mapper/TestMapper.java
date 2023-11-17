package com.sport.mapper;

import com.sport.common.pojo.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
    @Select("SELECT * FROM `dish` WHERE id = 46")
    Dish search();
}
