package com.anbangke.wy.design.server.design_9;

/**
 * 单例模式
 * @author wangerxiao
 * @date 2020/5/27 0:58
 * @email 784665813@qq.com
 */
public class Singleton {

    public Singleton() {
    }

    public static Singleton getInstance() {
        return InnerClass.INSTANCE;
    }

    public static class InnerClass {

        public static final Singleton INSTANCE = new Singleton();
    }
}
