package com.anbangke.wy.design.server.design_6;

import com.anbangke.wy.design.server.design_5.ISubject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:33
 * @email 784665813@qq.com
 */
@Slf4j
public class SubjectPreDecorator implements ISubject {

    private ISubject subject;

    public SubjectPreDecorator(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        preAction();
        subject.action();
    }

    private void preAction() {
        log.info("preAction()");
    }
}
