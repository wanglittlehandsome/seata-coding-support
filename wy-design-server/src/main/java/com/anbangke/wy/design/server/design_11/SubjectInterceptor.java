package com.anbangke.wy.design.server.design_11;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangerxiao
 * @date 2020/5/30 11:48
 * @email 784665813@qq.com
 */
@Slf4j
public class SubjectInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        preAction();
        Object result = methodProxy.invokeSuper(o, objects);
        postAction();
        return result;
    }

    private void preAction() {
        log.info("SubjectProxyHandler.preAction()");
    }

    private void postAction() {
        log.info("SubjectProxyHandler.postAction()");
    }
}
