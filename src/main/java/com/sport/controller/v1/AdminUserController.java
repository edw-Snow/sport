package com.sport.controller.v1;

import com.sport.common.pojo.dto.AdminUserDTO;
import com.sport.common.pojo.vo.AdminUserVO;
import com.sport.common.result.Result;
import com.sport.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * 管理员登录
     * @param adminUserDTO
     * @return
     */
    @RequestMapping("/login")
    public Result<AdminUserVO> login(@RequestBody AdminUserDTO adminUserDTO){
        AdminUserVO adminUserVO = adminUserService.login(adminUserDTO);
        return Result.success(adminUserVO);
    }

}
