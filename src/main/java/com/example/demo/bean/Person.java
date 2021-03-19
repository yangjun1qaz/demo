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
}


