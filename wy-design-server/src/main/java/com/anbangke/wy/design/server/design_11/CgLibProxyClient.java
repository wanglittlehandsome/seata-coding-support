package com.anbangke.wy.design.server.design_11;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author wangerxiao
 * @date 2020/5/30 11:53
 * @email 784665813@qq.com
 */
@Slf4j
public class CgLibProxyClient {

    public static void main(String[] args) {
        MethodInterceptor methodInterceptor = new SubjectInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteSubject.class);
        enhancer.setCallback(methodInterceptor);
        ISubject subject = (ISubject) enhancer.create();
        subject.action();
    }
}
