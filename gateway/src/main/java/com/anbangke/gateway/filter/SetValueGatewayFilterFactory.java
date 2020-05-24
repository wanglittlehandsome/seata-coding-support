package com.anbangke.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author wangerxiao
 * @date 2020/5/23 23:19
 * @email 784665813@qq.com
 */
@Component
@Slf4j
public class SetValueGatewayFilterFactory extends AbstractGatewayFilterFactory<SetValueGatewayFilterFactory.Config> implements Ordered {

    private static final String REQUEST_START_TIME = "request_start_time";

    public SetValueGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            exchange.getAttributes().put(REQUEST_START_TIME, System.currentTimeMillis());
            //If you want to build a "pre" filter you need to manipulate the
            //request before calling chain.filter
            ServerHttpRequest request = exchange.getRequest();
            //use builder to manipulate the request
            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    @Override
    public int getOrder() {
        return 1;
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
