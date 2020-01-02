package com.offcn.service.impl;

import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/24
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Map<String, Object> getPersonMap() {
        Map map = new HashMap();
        map.put("list", new ArrayList<>());
        map.put("ProviderVersion", "获取远程调用失败");
        return map;
    }

    @Override
    public void createPerson(Person person) {
        System.out.println("创建用户失败:" + person);

    }

    @Override
    public Person getPerson(Long id) {
        System.out.println("获取id：" + id + " 的用户失败");
        return null;
    }

    @Override
    public void updatePerson(Long id, Person person) {
        System.out.println("更新id:" + id + "的用户失败");

    }

    @Override
    public void deletePerson(Long id) {
        System.out.println("删除id为:" + id + "的用户失败");

    }

}
