package com.anbangke.userserver.test.properties;

import com.anbangke.userserver.test.PropertiesTest;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Properties;

/**
 * @author wangerxiao
 * @date 2020/5/30 23:33
 * @email 784665813@qq.com
 */
@Data
@ToString
@Slf4j
public class CustNamingService implements ICustNamingService {

    private String port;

    private String name;

    private CustEventDispatcher custEventDispatcher;

    public CustNamingService(Properties properties) {
        init(properties);
    }

    public void init(Properties properties) {
        port = Objects.toString(properties.getProperty(PropertiesTest.PropertyKeyConst.PORT), "");
        name = Objects.toString(properties.getProperty(PropertiesTest.PropertyKeyConst.NAME), "");
        log.error("CustNamingService: port={},name={}", port, name);
    }
}
