package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PersonWeb1Start {
    public static void main(String[] args) {
        SpringApplication.run(PersonWeb1Start.class, args);
    }

    //使用LoadBalancerClient实现高可用,具体看实现类
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
