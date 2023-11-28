package com.sport;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SportAckendApplicationTests {


    public static void main(String[] args) {
        String name= JSON.toJSONString("da");
        System.out.println(name);
    }
}
