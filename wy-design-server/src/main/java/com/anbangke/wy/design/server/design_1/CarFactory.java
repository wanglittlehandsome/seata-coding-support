package com.anbangke.wy.design.server.design_1;

import lombok.extern.slf4j.Slf4j;


/**
 * @author wangerxiao
 * @date 2020/5/26 10:49
 * @email 784665813@qq.com
 */
@Slf4j
public class CarFactory {

    public static Car newCar(String name) {
        Car car = null;
        switch (name) {
            case "LZ":
                car = new LZCar();
                break;
            case "BMW":
                car = new BMWCar();
                break;
            case "Benz":
                car = new BenzCar();
                break;
            default:
                car = null;
                break;
        }
        log.info("Created car name is {}", name);
        return car;
    }

    public static void main(String[] args) {
        CarFactory.newCar("Benz").drive();
    }
}
