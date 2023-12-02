package com.sport.service.Impl;

import com.sport.common.constant.JwtClaimConstant;
import com.sport.common.constant.MessageConstant;
import com.sport.common.exception.CustomException;
import com.sport.common.pojo.dto.AdminLoginDTO;
import com.sport.common.pojo.entity.AdminUser;
import com.sport.common.pojo.vo.AdminLoginVO;
import com.sport.common.property.JwtProperty;
import com.sport.common.util.JwtUtil;
import com.sport.mapper.AdminUserMapper;
import com.sport.service.AdminUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired
    private JwtProperty jwtProperty;

    @Override
    public AdminLoginVO login(AdminLoginDTO adminLoginDTO) {
        String username = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();
        AdminUser adminUser = adminUserMapper.getByUsername(username);

        //账号未注册
        if (adminUser == null) {
            throw new CustomException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码错误
        password = DigestUtils.md5DigestAsHex((adminUser.getSalt()+password).getBytes());
        if (!password.equals(adminUser.getPassword())) {
            throw new CustomException(MessageConstant.PASSWORD_ERROR);
        }

        //封装VO返回
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimConstant.ADMIN_ID, adminUser.getAdminId());
        String adminToken = JwtUtil.creatJwt(jwtProperty.getAdminSecretKey(), jwtProperty.getAdminTtl(), claims);
        AdminLoginVO adminLoginVO = AdminLoginVO.builder().adminToken(adminToken).build();
        BeanUtils.copyProperties(adminUser, adminLoginVO);
        return adminLoginVO;
    }
}
