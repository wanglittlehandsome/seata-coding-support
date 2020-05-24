package com.anbangke.userserver;

import com.anbangke.userserver.anno.EnableAuth;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.anbangke"})
@EnableDiscoveryClient
@EnableFeignClients
@EnableAuth("com.anbangke")
public class UserServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("服务启动完成");
    }
}
