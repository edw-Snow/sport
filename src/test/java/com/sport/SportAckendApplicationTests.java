package com.sport;

import com.sport.common.pojo.entity.AdminUser;
import com.sport.common.pojo.vo.AdminUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SportAckendApplicationTests {


    public static void main(String[] args) {
        AdminUser adminUser = AdminUser.builder().adminId(1).name("mike")
                .password("dads").build();
        AdminUserVO adminUserVO = AdminUserVO.builder().build();
        BeanUtils.copyProperties(adminUser,adminUserVO);
        System.out.println(adminUserVO);
    }
}
