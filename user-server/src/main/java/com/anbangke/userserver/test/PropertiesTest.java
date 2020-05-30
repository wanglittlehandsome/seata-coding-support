package com.anbangke.userserver.test;

import com.anbangke.userserver.test.properties.CustFactory;

import java.util.Properties;

/**
 * @author wangerxiao
 * @date 2020/5/30 23:23
 * @email 784665813@qq.com
 */
public class PropertiesTest {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.PORT, "16004");
        properties.put(PropertyKeyConst.NAME, "user-server");
        CustFactory.createCustNamingService(properties);
    }

    public class PropertyKeyConst {

        public static final String PORT = "port";
        public static final String NAME = "name";

    }
}
