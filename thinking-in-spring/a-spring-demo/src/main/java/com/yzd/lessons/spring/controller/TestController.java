package com.yzd.lessons.spring.controller;

import com.yzd.lessons.spring.repository.Person;
import com.yzd.lessons.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @author : yanzhidong
 * @date : 2020/7/26 
 * @version : V1.0
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;


    @PostMapping("funNoTransactional")
    public Person funNoTransactional(int age) {
        Person person = new Person();
        person.setAge(age);
        return testService.funNoTransactional(person);
    }

    @PostMapping("funHasTransactional")
    public Person funHasTransactional(int age) {
        Person person = new Person();
        person.setAge(age);
        return testService.funHasTransactional(person);
    }

    @PostMapping("noTransactional2Has")
    Person noTransactional2Has(int age) {
        Person person = new Person();
        person.setAge(age);
        return testService.noTransactional2Has(person);
    }

    @PostMapping("hasTransactional2No")
    Person hasTransactional2No(int age) {
        Person person = new Person();
        person.setAge(age);
        return testService.hasTransactional2No(person);
    }


}
