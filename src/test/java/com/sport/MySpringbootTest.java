package com.sport;

import com.sport.mapper.WxUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MySpringbootTest {
    public static void main(String[] args) {

    }

    @Autowired
    private WxUserMapper wxUserMapper;
    @Test
    public void f(){
        System.out.println(1/0);
    }
}
