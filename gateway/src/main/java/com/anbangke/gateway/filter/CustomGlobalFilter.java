package com.anbangke.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wangerxiao
 * @date 2020/5/23 22:20
 * @email 784665813@qq.com
 */
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter,Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.error("custom global filter");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
