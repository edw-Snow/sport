package com.sport.controller.v1;

import com.sport.dto.UserLoginDTO;
import com.sport.vo.WxUserLoginVO;
import com.sport.service.WxUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/user")
public class WxUserController {
    @Autowired
    private WxUserService wxUserService;


    /**
     * 微信用户登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public WxUserLoginVO login(@RequestBody UserLoginDTO userLoginDTO){
        WxUserLoginVO wxUserLoginVO = wxUserService.login(userLoginDTO);
        return wxUserLoginVO;
    }
}
