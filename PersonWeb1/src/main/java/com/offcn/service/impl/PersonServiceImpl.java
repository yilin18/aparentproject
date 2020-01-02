package com.offcn.service.impl;

import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    //没有加高可用轮询
    // private DiscoveryClient discoveryClient;
    private LoadBalancerClient loadBalancerClient;

    public String getServerUrl() {
        // List<ServiceInstance> list = discoveryClient.getInstances("PERSONPROVIDER");
        // ServiceInstance instance = list.get(0);
        ServiceInstance instance = loadBalancerClient.choose("PERSONPROVIDER");
        // System.out.println(instance.getUri());
        return instance.getUri() + "/person";
    }


    @Override
    public Map getPersonMap() {
        Map map = restTemplate.getForObject(getServerUrl() + "/getall", Map.class);
        return map;
    }

    @Override
    public void createPerson(Person user) {

        restTemplate.postForObject(getServerUrl() + "/save", user, String.class);

    }

    @Override
    public Person getPerson(Long id) {

        return restTemplate.getForObject(getServerUrl() + "/get/" + id, Person.class);
    }

    @Override
    public void updatePerson(Long id, Person user) {
        restTemplate.put(getServerUrl() + "/update/" + id, user);

    }

    @Override
    public void deletePerson(Long id) {


        restTemplate.delete(getServerUrl() + "/delete/" + id);
    }


}
