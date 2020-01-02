package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PersonWeb2Start {
    public static void main(String[] args) {
        SpringApplication.run(PersonWeb2Start.class, args);
    }

    @Bean
    @LoadBalanced//开启ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
