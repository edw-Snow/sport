package com.sport;

import com.sport.mapper.WxUserMapper;
import com.sport.vo.AdminLoginVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MySpringbootTest {
    public static void main(String[] args) {
        AdminLoginVO adminLoginVO = new AdminLoginVO();
    }

    @Autowired
    private WxUserMapper wxUserMapper;
    @Test
    public void f(){

    }
}
