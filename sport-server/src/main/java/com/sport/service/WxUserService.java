package com.sport.service;

import com.sport.dto.QueryWxUserDTO;
import com.sport.dto.UserLoginDTO;
import com.sport.vo.WxUserLoginVO;
import com.sport.result.PageResult;
import com.sport.result.Result;

public interface WxUserService {
    WxUserLoginVO login(UserLoginDTO userLoginDTO);

    Result<PageResult> queryWxUserByCondition(QueryWxUserDTO queryWxUserDTO);
}
