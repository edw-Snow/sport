package com.sport.mapper;

import com.sport.common.pojo.entity.AdminUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminUserMapper {
    @Insert("insert into admin_user values ()")
    void insert(AdminUser adminUser);

    @Select("select * from admin_user where username = #{username}")
    AdminUser getByUsername(String username);
}
