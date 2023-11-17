package com.sport.controller;

import com.sport.common.result.Result;
import com.sport.mapper.TestMapper;
import com.sport.common.pojo.entity.Dish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/search")
public class test {
    @Autowired
    private TestMapper testMapper;
    @RequestMapping("/search")
    public Dish hello(){
        System.out.println("hello");
        Dish mystr = testMapper.search();
        System.out.println(mystr);
        return mystr;
//        return testMapper.search();
    }

    @RequestMapping("/test")
    public Result test() {
        log.info("test");
        return Result.success();
    }
}
