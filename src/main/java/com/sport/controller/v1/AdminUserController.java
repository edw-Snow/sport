package com.sport.controller.v1;

import com.sport.common.pojo.dto.AdminLoginDTO;
import com.sport.common.pojo.vo.AdminLoginVO;
import com.sport.common.result.Result;
import com.sport.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * 管理员登录
     * @param adminLoginDTO
     * @return
     */
    @RequestMapping("/login")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO){
        AdminLoginVO adminLoginVO = adminUserService.login(adminLoginDTO);
        return Result.success(adminLoginVO);
    }

}
