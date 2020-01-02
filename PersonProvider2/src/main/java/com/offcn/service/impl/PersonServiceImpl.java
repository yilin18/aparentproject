package com.offcn.service.impl;

import com.offcn.dao.PersonDao;
import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> getPersonList() {
        return personDao.findAll();
    }

    @Override
    public void createPerson(Person person) {
        personDao.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        return personDao.findById(id).get();
    }

    @Override
    public void updatePerson(Long id, Person person) {
        person.setId(id);
        personDao.saveAndFlush(person);
    }

    @Override
    public void deletePerson(Long id) {
        personDao.deleteById(id);
    }
}
