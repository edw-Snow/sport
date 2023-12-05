package com.sport.mapper;

import com.sport.annotation.AutoFIllTime;
import com.sport.enumeration.OperationType;
import com.sport.dto.QueryWxUserDTO;
import com.sport.entity.WxUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WxUserMapper {
    @Select("select * from wx_user where openid =#{openid}")
    WxUser getByOpenid(String openid);

    @AutoFIllTime(value = OperationType.INSERT)
    @Insert("INSERT INTO wx_user (gender, wxuser_id, openid, nick_name, phone, address, avatar) " +
            "VALUES (#{gender}, #{wxuserId}, #{openid}, #{nickName}, #{phone}, #{address}, #{avatar})")
    WxUser insert(WxUser wxUser);

    List<WxUser> queryWxUserByCondition(QueryWxUserDTO queryWxUserDTO);
}
