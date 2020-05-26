package com.anbangke.wy.design.server.design_1;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/26 10:43
 * @email 784665813@qq.com
 */
@Slf4j
@Data
public class LZCar implements Car {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
    @Override
    public void drive() {
        log.info("drive:{}",this.getClass().getName());
    }
}
