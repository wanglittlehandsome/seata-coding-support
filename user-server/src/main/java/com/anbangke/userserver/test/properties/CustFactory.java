package com.anbangke.userserver.test.properties;


import java.util.Properties;

/**
 * @author wangerxiao
 * @date 2020/5/30 23:32
 * @email 784665813@qq.com
 */
public class CustFactory {

    public CustFactory() {

    }

    public static ICustNamingService createCustNamingService(Properties properties) {
        return NamingServiceFactory.createNamingService(properties);
    }
}
