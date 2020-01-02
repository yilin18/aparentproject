package com.offcn.service;

import com.offcn.pojo.Person;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
public interface PersonService {
    //获取全部用户数据
    public List<Person> getPersonList();
    //新增用户数据
    public void createPerson(Person person);
    //获取指定id用户信息
    public Person getPerson(Long id);
    //更新指定id用户信息
    public void updatePerson(Long id,Person person);
    //删除指定id用户
    public void deletePerson(Long id);

}
