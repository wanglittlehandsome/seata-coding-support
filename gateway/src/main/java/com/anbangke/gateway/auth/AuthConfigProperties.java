package com.anbangke.gateway.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author wangerxiao
 * @date 2020/5/24 19:27
 * @email 784665813@qq.com
 */
@Configuration
@ConfigurationProperties(prefix = AuthConfigProperties.AUTH_CONFIG_PREFIX)
@Data
public class AuthConfigProperties {

    public static final String AUTH_CONFIG_PREFIX = "auth.token";

    private int maxAliveSecond = 60 * 60 * 24;

    private int maxIdleSecond = 60 * 60 * 24;

    private String traceId = "traceId";

    private String userContext = "userContext";

    private String key = "token";

}
