package com.anbangke.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * @author wangerxiao
 * @date 2020/5/23 23:19
 * @email 784665813@qq.com
 */
@Component
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {

    public PreGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            //If you want to build a "pre" filter you need to manipulate the
            //request before calling chain.filter
            ServerHttpRequest request = exchange.getRequest();
            //use builder to manipulate the request
            return chain.filter(exchange.mutate().request(request).build());
        };    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
