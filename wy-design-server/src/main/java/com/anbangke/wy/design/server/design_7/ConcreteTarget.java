package com.anbangke.wy.design.server.design_7;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:40
 * @email 784665813@qq.com
 */
@Slf4j
public class ConcreteTarget implements ITarget {

    @Override
    public void request() {
        log.info("{}.request()", this.getClass().getSimpleName());
    }
}
