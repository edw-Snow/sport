package com.sport.service;

import com.sport.common.pojo.dto.UserLoginDTO;
import com.sport.common.pojo.vo.WxUserLoginVO;

public interface WxUserService {
    WxUserLoginVO login(UserLoginDTO userLoginDTO);
}
