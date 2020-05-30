package com.anbangke.wy.design.server.design_11;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangerxiao
 * @date 2020/5/30 10:35
 * @email 784665813@qq.com
 */
@Slf4j
public class SubjectProxyHandle implements InvocationHandler {

    private Object target;

    public SubjectProxyHandle(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("create proxy for {} failed!", clazz.getName());
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preAction();
        Object result = method.invoke(target, args);
        afterAction();
        log.info("Proxy class name {}", proxy.getClass().getName());
        return result;
    }

    private void preAction() {
        log.info("preAction()");
    }

    private void afterAction() {
        log.info("afterAction()");
    }
}
