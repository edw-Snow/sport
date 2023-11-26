package com.sport.controller.v1;

import com.sport.common.pojo.dto.AdminUserLoginDTO;
import com.sport.common.pojo.vo.AdminUserLoginVO;
import com.sport.common.result.ResponseResult;
import com.sport.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param adminUserLoginDTO
     * @return
     */
    @PostMapping("/login")
    ResponseResult<Object> adminLogin(@RequestBody AdminUserLoginDTO adminUserLoginDTO) {
        log.info("==========>管理员登录");
        AdminUserLoginVO adminUserLoginVO = adminService.adminLogin(adminUserLoginDTO);
        return ResponseResult.success(adminUserLoginVO);
    }
}
