package com.sport.service.Impl;

import com.sport.common.constant.JwtClaimConstant;
import com.sport.common.constant.MessageConstant;
import com.sport.common.pojo.dto.AdminUserLoginDTO;
import com.sport.common.pojo.entity.AdminUser;
import com.sport.common.pojo.vo.AdminUserLoginVO;
import com.sport.common.property.JwtProperty;
import com.sport.common.util.JwtUtil;
import com.sport.common.wrapper.ErrorResponseWrapper;
import com.sport.mapper.AdminUserMapper;
import com.sport.service.AdminService;
//import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired
    private JwtProperty jwtProperty;

    @Override
    public AdminUserLoginVO adminLogin(AdminUserLoginDTO adminUserLoginDTO) {
        String username = adminUserLoginDTO.getUsername();
        String password = adminUserLoginDTO.getPassword();
        AdminUser adminUser = adminUserMapper.getByUsername(username);

        if (adminUser == null) {
            throw new RuntimeException("用户名不存在");
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!adminUser.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        //生成token
        AdminUserLoginVO adminUserLoginVO = new AdminUserLoginVO();
        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimConstant.USER_ID,adminUser.getUserId());
        String token = JwtUtil.creatJwt(jwtProperty.getAdminSecretKey(), jwtProperty.getAdminTtl(), claims);
        //TODO 转换成VO对象
        return adminUserLoginVO;
    }
}
