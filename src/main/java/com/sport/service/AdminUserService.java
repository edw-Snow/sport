package com.sport.service;

import com.sport.common.pojo.dto.AdminUserDTO;
import com.sport.common.pojo.vo.AdminUserVO;

public interface AdminUserService {
    AdminUserVO login(AdminUserDTO adminUserDTO);
}
