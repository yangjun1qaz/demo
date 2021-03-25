package com.example.demo.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/9 13:37
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class Person {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;

    public Person() {
    }

    public Person(Long id, String name, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public void test() {
        System.out.println("my is test");
    }

    private void test1() {
        System.out.println("my is test1");
    }
}


