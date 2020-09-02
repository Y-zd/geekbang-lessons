package com.yzd.lessons.spring.service;

import com.yzd.lessons.spring.repository.Person;

/***
 *
 * @author : yanzhidong
 * @date : 2020/8/14 
 * @version : V1.0
 *
 */
public interface TestService {

    Person funNoTransactional(Person person);

    Person funHasTransactional(Person person);

    Person noTransactional2Has(Person person);

    Person hasTransactional2No(Person person);

}
