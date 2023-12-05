package com.sport.service;

import com.sport.dto.AdminLoginDTO;
import com.sport.vo.AdminLoginVO;
import com.sport.result.Result;

public interface AdminUserService {
    Result<AdminLoginVO> login(AdminLoginDTO adminLoginDTO);
}
