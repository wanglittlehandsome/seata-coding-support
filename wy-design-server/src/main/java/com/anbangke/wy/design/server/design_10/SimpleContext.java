package com.anbangke.wy.design.server.design_10;

/**
 * @author wangerxiao
 * @date 2020/5/27 1:11
 * @email 784665813@qq.com
 */
public class SimpleContext {

    private Strategy strategy;

    public SimpleContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategy(String input) {
        strategy.strategy(input);
    }
}
