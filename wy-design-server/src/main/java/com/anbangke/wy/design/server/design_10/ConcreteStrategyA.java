package com.anbangke.wy.design.server.design_10;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 1:11
 * @email 784665813@qq.com
 */
@Slf4j
public class ConcreteStrategyA implements Strategy {
    @Override
    public void strategy(String input) {
        log.info("Strategy A for input : {}", input);
    }
}
