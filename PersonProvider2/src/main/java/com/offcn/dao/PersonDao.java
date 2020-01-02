package com.offcn.dao;

import com.offcn.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * company: www.abc.com
 * Author: 苏依林
 * Create Data: 2019/12/23
 */
public interface PersonDao extends JpaRepository<Person, Long> {
}
