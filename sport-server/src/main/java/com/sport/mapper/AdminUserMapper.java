package com.sport.mapper;

import com.sport.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminUserMapper {

    @Select("select * from admin_user where username = #{username}")
    AdminUser getByUsername(String username);
}
