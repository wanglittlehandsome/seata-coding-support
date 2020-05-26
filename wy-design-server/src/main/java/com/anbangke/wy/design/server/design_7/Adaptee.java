package com.anbangke.wy.design.server.design_7;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:41
 * @email 784665813@qq.com
 */
@Slf4j
public class Adaptee {


    public void onRequest() {
        log.info("{}.onRequest()", this.getClass().getSimpleName());
    }
}
