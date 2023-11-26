package com.sport.mapper;

import com.sport.common.pojo.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

    @Select("SELECT * FROM admin_user")
    AdminUser searchForAdmin();

    @Select("SELECT * FROM admin_user WHERE username = #{username}")
    AdminUser login(String username);

}
