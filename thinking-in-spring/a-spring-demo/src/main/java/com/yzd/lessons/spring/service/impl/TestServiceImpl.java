package com.yzd.lessons.spring.service.impl;


import com.yzd.lessons.spring.repository.Person;
import com.yzd.lessons.spring.repository.PersonRepository;
import com.yzd.lessons.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 *
 * @author : yanzhidong
 * @date : 2020/7/26 
 * @version : V1.0
 *
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person funNoTransactional(Person person) {
        Person save = personRepository.save(person);
        System.out.println(1 / 0);
        return save;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Person funHasTransactional(Person person) {
        Person save = personRepository.save(person);
        System.out.println(1 / 0);
        return save;
    }

    @Override
    public Person noTransactional2Has(Person person) {
        return funHasTransactional(person);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Person hasTransactional2No(Person person) {
        return funNoTransactional(person);
    }


}
