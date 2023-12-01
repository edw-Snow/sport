package com.sport.service;

import com.sport.common.pojo.dto.AdminLoginDTO;
import com.sport.common.pojo.vo.AdminLoginVO;

public interface AdminUserService {
    AdminLoginVO login(AdminLoginDTO adminLoginDTO);
}
