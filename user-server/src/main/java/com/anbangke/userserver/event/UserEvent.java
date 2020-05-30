package com.anbangke.userserver.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * @author wangerxiao
 * @date 2020/5/30 22:05
 * @email 784665813@qq.com
 */
@Setter
@Getter
@ToString
public class UserEvent extends ApplicationEvent {

    private Long id;

    private String userName;

    private String phone;

    private String requestId;

    public UserEvent(Object source) {
        super(source);
    }

    public UserEvent(Object source, Long id, String userName, String phone) {
        super(source);
        this.id = id;
        this.userName = userName;
        this.phone = phone;
    }
}
