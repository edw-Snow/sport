package com.sport.service;

import com.sport.common.pojo.dto.AdminUserLoginDTO;
import com.sport.common.pojo.vo.AdminUserLoginVO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.transform.Result;

public interface AdminService {
    AdminUserLoginVO adminLogin(AdminUserLoginDTO adminUserLoginDTO);
}
