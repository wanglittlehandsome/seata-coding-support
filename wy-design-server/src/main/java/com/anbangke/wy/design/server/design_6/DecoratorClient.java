package com.anbangke.wy.design.server.design_6;

import com.anbangke.wy.design.server.design_5.ConcreteSubject;
import com.anbangke.wy.design.server.design_5.ISubject;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:35
 * @email 784665813@qq.com
 */
public class DecoratorClient {

    public static void main(String[] args) {
        ISubject subject = new ConcreteSubject();
        ISubject preDecorator = new SubjectPreDecorator(subject);
        ISubject postDecorator = new SubjectPostDecorator(preDecorator);
        postDecorator.action();
    }
}
