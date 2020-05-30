package com.anbangke.wy.design.server.design_11;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wangerxiao
 * @date 2020/5/30 10:39
 * @email 784665813@qq.com
 */
@Slf4j
public class JDKDynamicProxyClient {


    public static void main(String[] args) {
        InvocationHandler invocationHandler = new SubjectProxyHandle(ConcreteSubject.class);
        ISubject subject = (ISubject) Proxy.newProxyInstance(JDKDynamicProxyClient.class.getClassLoader()
                , new Class[]{ISubject.class}, invocationHandler);
        subject.action();
    }
}
