package com.anbangke.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author wangerxiao
 * @date 2020/5/23 23:22
 * @email 784665813@qq.com
 */
@Component
@Slf4j
public class PostGatewayFilterFactory extends AbstractGatewayFilterFactory<PostGatewayFilterFactory.Config> implements Ordered {

    private static final String REQUEST_START_TIME = "request_start_time";

    public PostGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(REQUEST_START_TIME);
            if (startTime != null) {
                log.info("请求地址：{},消耗时间：{}ms", exchange.getRequest().getURI(), System.currentTimeMillis() - startTime);
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
