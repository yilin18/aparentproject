package com.offcn.controller;

import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
@RestController
@RequestMapping("/person")
//更新配置注解
/*
* 更新配置文件信息需要访问本项目路径
* [Post请求]http://localhost:8088/actuator/refresh
* */
@RefreshScope
public class PersonController {
    @Autowired
    private PersonService personService;

    @Value("${ProviderVersion}")
    private String ProviderVersion;
    @GetMapping("/getall")
    public Map<String, Object> getPersons() {
        System.out.println("调用服务1");
        try {
            int sleep = new Random().nextInt(12000);
            Thread.sleep(sleep);
            // System.out.println("1睡眠" + sleep);
            // Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        List<Person> list = personService.getPersonList();
        map.put("list", list);
        // String ProviderVersion = "用户服务PersonProvdier001:0.01V";
        map.put("ProviderVersion", ProviderVersion);


        return map;
    }

    /***
     * 保存新增用户接口
     *
     * @param person
     * @return
     */
    @PostMapping("/save")
    public String createPerson(@RequestBody Person person) {
        try {
            personService.createPerson(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /***
     * 获取指定id用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Person findPerson(@PathVariable("id") Long id) {
        Person person = null;
        try {
            person = personService.getPerson(id);
            System.out.println("返回person:" + person);
        } catch (Exception e) {

            //e.printStackTrace();
            System.out.println("数据查询失败:");
            return person;
        }
        return person;
    }

    /***
     * 编辑指定id用户信息
     *
     * @param person
     * @param id
     * @return
     */
    @PutMapping("/update/{id}")
    public String editPerson(@RequestBody Person person, @PathVariable("id") Long id) {
        try {
            personService.updatePerson(person.getId(), person);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /***
     * 删除指定id用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        try {
            personService.deletePerson(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";

    }

    /***
     * 获取服务名称
     *
     * @return
     */
    @GetMapping("/getversion")
    public String getVersion() {
        return "用户服务PersonProvdier001:0.01V";
    }
}

