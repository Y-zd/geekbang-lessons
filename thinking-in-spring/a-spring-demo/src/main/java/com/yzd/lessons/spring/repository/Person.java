package com.yzd.lessons.spring.repository;

import javax.persistence.*;

/***
 *
 * @author : yanzhidong
 * @date : 2020/8/14 
 * @version : V1.0
 *
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
