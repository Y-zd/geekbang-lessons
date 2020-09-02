package com.yzd.lessons.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 *
 * @author : yanzhidong
 * @date : 2020/8/14 
 * @version : V1.0
 *
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
