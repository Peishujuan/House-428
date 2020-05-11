package com.peishujuan.springcloud.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class JpaApp {
    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class,args);
    }
}
