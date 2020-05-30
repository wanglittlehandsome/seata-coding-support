package com.anbangke.userserver;

import com.anbangke.userserver.anno.EnableAuth;
import com.anbangke.userserver.event.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = {"com.anbangke"})
@EnableDiscoveryClient
@EnableFeignClients
@EnableAuth("com.anbangke")
@Slf4j
public class UserServerApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Environment env = context.getEnvironment();
        context.publishEvent(new UserEvent(this.getClass(), 1L, env.getProperty("spring.application.name"), "13260648441"));
        System.out.println("服务启动完成");
    }

}
