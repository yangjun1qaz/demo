package com.example.demo.controller;

import com.example.demo.bean.Person;
import com.example.demo.bean.PersonConverter;
import com.example.demo.bean.PersonDTO;
import com.example.demo.bean.User;
import org.dromara.soul.client.common.annotation.SoulClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/5/6 15:52
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private PersonConverter personConverter;

    @RequestMapping(value = "/soulTest", method = RequestMethod.GET)
    @ResponseBody
    @SoulClient(path = "/test/soulTest", desc = "测试")
    public String test() {
        return "hello soul";
    }

    @RequestMapping(value = "/hellosoul", method = RequestMethod.GET)
    @ResponseBody
    @SoulClient(path = "/test/hellosoul", desc = "测试")
    public String hellosoul() {
        return "soul run...";
    }


    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public void testMap() {
        Person person = new Person();
        person.setBirthday(new Date());
        person.setEmail("EMAIL@qq.com");
        person.setId(1000l);
        person.setName("brayden");
        User user = new User();
        user.setAge(12);
        person.setUser(user);
        PersonDTO personDTO = personConverter.domain2dto(person);
        System.out.println(personDTO);
    }
}
