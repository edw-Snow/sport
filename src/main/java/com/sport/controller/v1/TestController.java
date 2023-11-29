package com.sport.controller.v1;

import com.sport.common.property.JwtProperty;
import com.sport.common.result.Result;
import com.sport.common.util.JwtUtil;
import com.sport.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {
    @Autowired
    public TestMapper testMapper;

    @Autowired
    public JwtProperty jwtProperty;

    @RequestMapping("/test")
    public void test(){
        testMapper.test("lucy");
    }

    @RequestMapping("/login")
//    @AdminRule
    public Result<String> login(){
        HashMap<String, Object> map = new HashMap<>();
        String token = JwtUtil.creatJwt(jwtProperty.getAdminSecretKey(), jwtProperty.getAdminTtl(), map);
        return Result.success(token);
    }

    public static void main(String[] args) {

    }
}
