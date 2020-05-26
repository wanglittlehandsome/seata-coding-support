package com.anbangke.wy.design.server.design_10;

/**
 * @author wangerxiao
 * @date 2020/5/27 1:12
 * @email 784665813@qq.com
 */
public class SimpleClient {

    public static void main(String[] args) {
        Strategy concreteStrategyA = new ConcreteStrategyA();
        SimpleContext simpleContext = new SimpleContext(concreteStrategyA);
        simpleContext.strategy("hello");
    }
}
