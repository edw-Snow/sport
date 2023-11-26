package com.sport.controller.v1;

import com.sport.annotation.AdminRule;
import com.sport.common.constant.JwtClaimConstant;
import com.sport.common.pojo.dto.AdminUserLoginDTO;
import com.sport.common.pojo.entity.AdminUser;
import com.sport.common.property.JwtProperty;
import com.sport.common.result.ResponseResult;
import com.sport.common.util.JwtUtil;
import com.sport.mapper.TestMapper;
import com.sport.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
//@RequestMapping("/search")
public class test {
    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private JwtProperty jwtProperty;

    @RequestMapping("/test")
    @AdminRule
    public AdminUser test(HttpServletResponse response) {
        log.info("++++++++++++++");
        return testMapper.searchForAdmin();
    }


    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody AdminUserLoginDTO adminUserLoginDTO) {
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserLoginDTO,adminUser);
        String username = adminUser.getUsername();
        AdminUser adminUser1 = testMapper.login(username);
        Map<String,Object> claim =new HashMap<>();
        claim.put(JwtClaimConstant.ID,adminUser1.getUserId());
        String token = JwtUtil.creatJwt(jwtProperty.getUserSecretKey(), jwtProperty.getAdminTtl(), claim);
        return ResponseResult.success(token);
    }


}
