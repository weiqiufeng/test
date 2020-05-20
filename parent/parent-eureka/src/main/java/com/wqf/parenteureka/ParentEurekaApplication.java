package com.wqf.parenteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ParentEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentEurekaApplication.class, args);
    }

}
