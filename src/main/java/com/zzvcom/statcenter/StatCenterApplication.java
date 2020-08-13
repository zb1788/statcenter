package com.zzvcom.statcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"com.zzvcom.statcenter.business.**.mapper"})
public class StatCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatCenterApplication.class, args);
    }

}
