package com.anbangke.wy.design.server.design_5;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:26
 * @email 784665813@qq.com
 */
@Slf4j
public class ProxySubject implements ISubject {

    private ISubject subject;


    public ProxySubject() {
        this.subject = new ConcreteSubject();
    }

    @Override
    public void action() {
        preAction();
        subject.action();
        afterAction();
    }

    private void preAction() {
        log.info("preAction()");
    }

    private void afterAction() {
        log.info("afterAction()");
    }
}
