package com.offcn.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
@Service
public class PersonServiceImpl implements PersonService {
    //远程调用客户端
    @Autowired
    private RestTemplate restTemplate;
    //disconveryClient客户端
    String url = "http://PERSONPROVIDER/person";

    @Override
    //熔断触发的方法
    @HystrixCommand(fallbackMethod = "getPersonMapFallbackMethod")
    public Map getPersonMap() {
        long startTime = System.currentTimeMillis();
        Map map = restTemplate.getForObject(url + "/getall", Map.class);
        long endTime = System.currentTimeMillis();
        System.out.println("程序执行时间:" + (endTime - startTime));
        return map;
    }

    @Override
    public void createPerson(Person user) {

        restTemplate.postForObject(url + "/save", user, String.class);

    }

    @Override
    public Person getPerson(Long id) {

        return restTemplate.getForObject(url + "/get/" + id, Person.class);
    }

    @Override
    public void updatePerson(Long id, Person user) {
        restTemplate.put(url + "/update/" + id, user);

    }

    @Override
    public void deletePerson(Long id) {
        restTemplate.delete(url + "/delete/" + id);
    }

    private Map getPersonMapFallbackMethod() {
        System.out.println("触发熔断机制");
        Map map = new HashMap();
        map.put("list", new ArrayList<>());
        map.put("ProviderVersion", "获取远程调用失败");
        return map;
    }
}
