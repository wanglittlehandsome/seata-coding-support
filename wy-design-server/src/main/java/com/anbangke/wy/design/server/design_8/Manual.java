package com.anbangke.wy.design.server.design_8;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:50
 * @email 784665813@qq.com
 */
@Slf4j
public class Manual extends Transmission {

    @Override
    public void gear() {
        log.info("{} transmission", this.getClass().getSimpleName());
    }
}
