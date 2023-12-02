package com.sport.service;

import com.sport.common.pojo.dto.QueryWxUserDTO;
import com.sport.common.pojo.dto.UserLoginDTO;
import com.sport.common.pojo.vo.QueryWxUserVO;
import com.sport.common.pojo.vo.WxUserLoginVO;

import java.util.List;

public interface WxUserService {
    WxUserLoginVO login(UserLoginDTO userLoginDTO);

    List<QueryWxUserVO> queryWxUserByCondition(QueryWxUserDTO queryWxUserDTO);
}
