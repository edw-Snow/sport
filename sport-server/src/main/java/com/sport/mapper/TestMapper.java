package com.sport.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    void test(String testName);
}
