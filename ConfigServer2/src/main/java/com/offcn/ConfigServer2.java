package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/25
 */
@SpringBootApplication
@EnableConfigServer
//注册到eureka注解
@EnableDiscoveryClient
public class ConfigServer2 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer2.class, args);
    }
}
