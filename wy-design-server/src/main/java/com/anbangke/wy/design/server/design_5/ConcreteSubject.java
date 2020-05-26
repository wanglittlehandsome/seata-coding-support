package com.anbangke.wy.design.server.design_5;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:25
 * @email 784665813@qq.com
 */
@Slf4j
public class ConcreteSubject implements ISubject {


    @Override
    public void action() {
        log.info("{} action()", this.getClass().getSimpleName());
    }
}
