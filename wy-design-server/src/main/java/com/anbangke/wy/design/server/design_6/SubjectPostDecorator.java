package com.anbangke.wy.design.server.design_6;

import com.anbangke.wy.design.server.design_5.ISubject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:33
 * @email 784665813@qq.com
 */
@Slf4j
public class SubjectPostDecorator implements ISubject {

    private ISubject subject;

    public SubjectPostDecorator(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        subject.action();
        postAction();
    }

    private void postAction() {
        log.info("postAction()");
    }
}
