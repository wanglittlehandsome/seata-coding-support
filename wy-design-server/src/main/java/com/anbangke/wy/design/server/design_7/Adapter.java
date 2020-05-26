package com.anbangke.wy.design.server.design_7;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:42
 * @email 784665813@qq.com
 */
@Slf4j
public class Adapter implements ITarget {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        log.info("Adapter.request");
        adaptee.onRequest();
    }
}
