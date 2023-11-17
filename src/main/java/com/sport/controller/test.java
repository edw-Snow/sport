package com.sport.controller;

import com.sport.mapper.TestMapper;
import com.sport.common.pojo.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class test {
    @Autowired
    private TestMapper testMapper;
    @RequestMapping("/search")
    public Dish hello(){
        Dish mystr = testMapper.search();
        System.out.println(mystr);
        return mystr;
//        return testMapper.search();
    }
}
