package com.anbangke.wy.design.server.design_8;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:51
 * @email 784665813@qq.com
 */
public class BridgeClient {


    public static void main(String[] args) {
        AbstractCar car = new BMWCar();
        Transmission transmission = new Manual();
        car.setTransmission(transmission);
        car.run();
    }
}
