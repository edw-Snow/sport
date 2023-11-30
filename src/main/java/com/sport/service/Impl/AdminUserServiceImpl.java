package com.sport.service.Impl;

import com.sport.common.constant.JwtClaimConstant;
import com.sport.common.constant.MessageConstant;
import com.sport.common.pojo.dto.AdminUserDTO;
import com.sport.common.pojo.entity.AdminUser;
import com.sport.common.pojo.vo.AdminUserVO;
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
    public AdminUserVO login(AdminUserDTO adminUserDTO) {
        String username = adminUserDTO.getUsername();
        String password = adminUserDTO.getPassword();
        AdminUser adminUser = adminUserMapper.getByUsername(username);

        //账号未注册
        if (adminUser == null) {
            throw new RuntimeException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码错误
        password = DigestUtils.md5DigestAsHex((adminUser.getSalt()+password).getBytes());
        if (!password.equals(adminUser.getPassword())) {
            throw new RuntimeException(MessageConstant.PASSWORD_ERROR);
        }

        //封装VO返回
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimConstant.ADMIN_ID, adminUser.getAdminId());
        String adminToken = JwtUtil.creatJwt(jwtProperty.getAdminSecretKey(), jwtProperty.getAdminTtl(), claims);
        AdminUserVO adminUserVO = AdminUserVO.builder().adminToken(adminToken).build();
        BeanUtils.copyProperties(adminUser, adminUserVO);
        return adminUserVO;
    }
}
