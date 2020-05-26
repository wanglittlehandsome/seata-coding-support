package com.anbangke.wy.design.server.design_8;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:49
 * @email 784665813@qq.com
 */
@Slf4j
public class BMWCar extends AbstractCar {

    @Override
    public void run() {
        transmission.gear();
        log.info("BMW is running");
    }
}
