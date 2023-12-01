package com.sport.common.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "sport.wechat")
public class WeChatProperty {
    private String appid;
    private String secret;
}
