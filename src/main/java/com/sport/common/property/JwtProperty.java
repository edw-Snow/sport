package com.sport.common.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sport.jwt")
@Data
public class JwtProperty {
    // 管理员的jwt配置
    private String adminSecretKey;
    long adminTtl;
    private String adminTokenName;

    // 小程序用户的jwt配置
    private String userSecretKey;
    long userTtl;
    private String uerTokenName;
}
