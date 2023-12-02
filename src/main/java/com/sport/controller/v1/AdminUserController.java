package com.sport.controller.v1;

import com.sport.annotation.AdminRule;
import com.sport.common.pojo.dto.AdminLoginDTO;
import com.sport.common.pojo.dto.QueryWxUserDTO;
import com.sport.common.pojo.vo.AdminLoginVO;
import com.sport.common.pojo.vo.QueryWxUserVO;
import com.sport.common.result.PageResult;
import com.sport.common.result.Result;
import com.sport.service.AdminUserService;
import com.sport.service.WxUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        AdminLoginVO adminLoginVO = adminUserService.login(adminLoginDTO);
        return Result.success(adminLoginVO);
    }

    /**
     * 条件查询用户信息
     * @param queryWxUserDTO
     * @return
     */
    @RequestMapping("/queryWxUser")
    @AdminRule
    private Result<PageResult> queryWxUserByCondition(@RequestBody QueryWxUserDTO queryWxUserDTO){
        List<QueryWxUserVO> queryWxUserVOS = wxUserService.queryWxUserByCondition(queryWxUserDTO);
        PageResult pageResult = PageResult.builder().records(queryWxUserVOS).total(queryWxUserVOS.size()).build();
        return Result.success(pageResult);
    }
}
