package com.offcn;

import com.netflix.zuul.ZuulFilter;
import com.offcn.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/26
 */
@SpringCloudApplication
@EnableZuulProxy
public class GateWayStart {
    public static void main(String[] args) {
        SpringApplication.run(GateWayStart.class, args);
    }

    @Bean
    public AccessFilter getZuulFilter() {
        return new AccessFilter();
    }
}
