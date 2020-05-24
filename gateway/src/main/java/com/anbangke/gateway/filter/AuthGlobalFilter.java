package com.anbangke.gateway.filter;

import com.anbangke.gateway.auth.AuthConfigProperties;
import com.anbangke.gateway.auth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author wangerxiao
 * @date 2020/5/23 22:20
 * @email 784665813@qq.com
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    AuthConfigProperties authConfigProperties;
    @Autowired
    AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String reqPath = exchange.getRequest().getURI().getPath();
        String token = exchange.getRequest().getHeaders().getFirst(authConfigProperties.getKey());
        if (!authService.verifyToken(reqPath, token)) {
            log.warn("没有授权的访问，{}", reqPath);
            exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            return exchange.getResponse().setComplete();
        }
        //获取token中存储的用户唯一标识，并放入request header中，供后端业务服务使用
        String account = authService.getAccountByToken(token);
        String traceId = UUID.randomUUID().toString().replace("-", "");
        ServerHttpRequest request = exchange.getRequest().mutate()
                .header(authConfigProperties.getTraceId(), traceId)
                .header(authConfigProperties.getUserContext(), account).build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
