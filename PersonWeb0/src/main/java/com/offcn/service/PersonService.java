package com.offcn.service;

import com.offcn.pojo.Person;

import java.util.Map;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
public interface PersonService {
    public Map getPersonMap();

    public void createPerson(Person person);

    public Person getPerson(Long id);

    public void updatePerson(Long id, Person person);

    public void deletePerson(Long id);

}
