package com.anbangke.userserver.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * spring publishEvent
 *
 * @author wangerxiao
 * @date 2020/5/30 22:13
 * @email 784665813@qq.com
 */
@Component
@Slf4j
public class UserEventListener implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(UserEvent event) {
        log.error("event:{}", event.toString());
    }
}
