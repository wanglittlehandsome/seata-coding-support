package com.anbangke.wy.design.server.design_8;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:47
 * @email 784665813@qq.com
 */
public abstract class AbstractCar {

    protected Transmission transmission;

    public abstract void run();

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
