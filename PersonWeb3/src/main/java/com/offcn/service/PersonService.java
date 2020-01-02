package com.offcn.service;

import com.offcn.pojo.Person;
import com.offcn.service.impl.PersonServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
@FeignClient(value = "PERSONPROVIDER", fallback = PersonServiceImpl.class)
public interface PersonService {
    @GetMapping("/person/getall")
    Map getPersonMap();

    @PostMapping("/person/save")
    void createPerson(Person person);

    @GetMapping("/person/get/{id}")
    Person getPerson(@PathVariable Long id);

    @PutMapping("/person/update/{id}")
    void updatePerson(@PathVariable Long id, Person person);

    @DeleteMapping("/person/delete/{id}")
    void deletePerson(@PathVariable Long id);

}
