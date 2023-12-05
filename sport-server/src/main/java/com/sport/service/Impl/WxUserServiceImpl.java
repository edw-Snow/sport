package com.sport.service.Impl;

import com.sport.constant.JwtClaimConstant;
import com.sport.constant.MessageConstant;
import com.sport.exception.CustomException;
import com.sport.dto.QueryWxUserDTO;
import com.sport.dto.UserLoginDTO;
import com.sport.entity.WxUser;
import com.sport.vo.QueryWxUserVO;
import com.sport.vo.WxUserLoginVO;
import com.sport.property.JwtProperty;
import com.sport.result.PageResult;
import com.sport.result.Result;
import com.sport.util.JwtUtil;
import com.sport.util.WxApiUtil;
import com.sport.mapper.WxUserMapper;
import com.sport.service.WxUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private WxApiUtil wxApiUtil;

    @Autowired
    private WxUserMapper wxUserMapper;

    @Autowired
    private JwtProperty jwtProperty;

    public WxUserLoginVO login(UserLoginDTO userLoginDTO) {
        String code = userLoginDTO.getCode();
        String openid = wxApiUtil.getOpenid(code);

        if (openid == null) {
            throw new CustomException(MessageConstant.LOGIN_FAIL);
        }

        WxUser wxUser = wxUserMapper.getByOpenid(openid);

        //新用户自动完成注册
        if (wxUser == null) {
            WxUser user = WxUser.builder().openid(openid).build();
            wxUser = wxUserMapper.insert(user);
        }
        //封装VO返回
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimConstant.USER_ID, wxUser.getUserId());
        String token = JwtUtil.creatJwt(jwtProperty.getUserSecretKey(), jwtProperty.getUserTtl(), claims);
        WxUserLoginVO wxUserLoginVO = WxUserLoginVO.builder().token(token).build();
        BeanUtils.copyProperties(wxUser, wxUserLoginVO);
        return wxUserLoginVO;
    }

    @Override
    public Result<PageResult> queryWxUserByCondition(QueryWxUserDTO queryWxUserDTO) {
        queryWxUserDTO.setLimit(queryWxUserDTO.getFormIndex());
        List<QueryWxUserVO> queryWxUserVOS = wxUserMapper.queryWxUserByCondition(queryWxUserDTO)
                .stream()
                .map(wxUser -> {
                    QueryWxUserVO queryWxUserVO = new QueryWxUserVO();
                    BeanUtils.copyProperties(wxUser, queryWxUserVO);
                    return queryWxUserVO;
                })
                .collect(Collectors.toList());
        PageResult pageResult = PageResult.builder().records(queryWxUserVOS).total(queryWxUserVOS.size()).build();
        return Result.success(pageResult);
    }
}
