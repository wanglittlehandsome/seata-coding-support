package com.anbangke.userserver.test;

import com.alibaba.nacos.api.naming.PreservedMetadataKeys;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangerxiao
 * @date 2020/5/30 23:12
 * @email 784665813@qq.com
 */
@Configuration
public class PostConstructTest {

    private String name;

    private Map<String, String> metadata = new HashMap<>();


    @PostConstruct
    public void init() {
        metadata.put(PreservedMetadataKeys.REGISTER_SOURCE, "SPRING_CLOUD");
        name = Objects.toString(name, "默认值");
    }
}
