package com.anbangke.userserver.anno;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangerxiao
 * @date 2020/5/25 0:51
 * @email 784665813@qq.com
 */
@Slf4j
@Component
public class AuthHandle implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    private static List<String> allAuth = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        scanAuthClass();
        scanAuthMethod();
        scanAuthBean();
    }



    /**
     * 扫描指定类，并自动加载
     * @date: 2020/5/25 17:40
     */
    private void scanAuthBean() {
        if (!ClassPathAuthScanner.AuthBean.beanNameList.isEmpty()) {
            ClassPathAuthScanner.AuthBean.beanNameList.forEach(beanName -> {
                Class<?> beanClass = null;
                try {
                    beanClass = Class.forName(beanName);
                } catch (ClassNotFoundException e) {
                    log.error("ClassNotFoundException:", e);
                }
                Object clazz = applicationContext.getBean(beanClass);
                for (Method method : clazz.getClass().getDeclaredMethods()) {
                    Auth auth = method.getAnnotation(Auth.class);
                    if (auth != null) {
                        allAuth.add(auth.mapping());
                    }
                }
            });
        }
    }

    private void scanAuthClass() {
        Map<String, Object> clazzMap = applicationContext.getBeansWithAnnotation(Auth.class);
        clazzMap.values().forEach(obj -> {
            final Class<? extends Object> clazz = obj.getClass();
            Auth auth = clazz.getAnnotation(Auth.class);
            if (auth != null) {
                allAuth.add(auth.mapping());
            }
        });
    }

    private void scanAuthMethod() {
        Map<String, Object> clazzMap = applicationContext.getBeansWithAnnotation(Auth.class);
        clazzMap.values().forEach(obj -> {
            final Class<? extends Object> clazz = obj.getClass();
            for (Method method : clazz.getDeclaredMethods()) {
                Auth auth = method.getAnnotation(Auth.class);
                if (auth != null) {
                    allAuth.add(auth.mapping());
                }
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return this.applicationContext;
    }

    public List<String> getAllAuth() {
        return allAuth;
    }

}
