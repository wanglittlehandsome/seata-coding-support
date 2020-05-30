package com.anbangke.userserver.test.properties;

import com.anbangke.wy.response.baseException.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @author wangerxiao
 * @date 2020/5/30 23:34
 * @email 784665813@qq.com
 */
@Slf4j
public class NamingServiceFactory {

    public NamingServiceFactory() {

    }

    public static ICustNamingService createNamingService(Properties properties) {
        try {
            Class<?> driverImplClass = Class.forName("com.anbangke.userserver.test.properties.CustNamingService");
            Constructor constructor = driverImplClass.getConstructor(Properties.class);
            ICustNamingService vendorImpl = (ICustNamingService) constructor.newInstance(properties);
            return vendorImpl;
        } catch (Throwable var4) {
            log.error("实例化CustNamingService失败:", var4);
            throw new BusinessException("实例化CustNamingService失败");
        }
    }
}
