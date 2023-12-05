package com.sport.controller.v1;

import com.sport.annotation.AdminRule;
import com.sport.dto.AdminLoginDTO;
import com.sport.dto.QueryWxUserDTO;
import com.sport.vo.AdminLoginVO;
import com.sport.result.PageResult;
import com.sport.result.Result;
import com.sport.service.AdminUserService;
import com.sport.service.WxUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private WxUserService wxUserService;

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    @RequestMapping("/login")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO){
        return adminUserService.login(adminLoginDTO);
    }

    /**
     * 条件查询用户信息
     * @param queryWxUserDTO
     * @return
     */
    @PostMapping("/queryWxUser")
    @AdminRule
    private Result<PageResult> queryWxUserByCondition(@RequestBody QueryWxUserDTO queryWxUserDTO){
        return wxUserService.queryWxUserByCondition(queryWxUserDTO);
    }
}
