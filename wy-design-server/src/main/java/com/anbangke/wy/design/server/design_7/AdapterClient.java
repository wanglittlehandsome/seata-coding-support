package com.anbangke.wy.design.server.design_7;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:43
 * @email 784665813@qq.com
 */
public class AdapterClient {

    public static void main(String[] args) {
        ITarget target = new ConcreteTarget();
        target.request();

        ITarget adapter = new Adapter();
        adapter.request();
    }
}
