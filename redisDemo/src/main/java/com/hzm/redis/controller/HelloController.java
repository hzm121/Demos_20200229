package com.hzm.redis.controller;

import com.hzm.redis.enums.SexEnum;
import com.hzm.redis.pojo.User;
import com.hzm.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hzm
 * @date : 2020-03-07 21:49
 */
@RestController
public class HelloController {
    @Autowired
    private UserService userService;
    @GetMapping({"/hello","/"})
    public String sayHello(){
        return "Hello";
    }
    @PostMapping({"/setUser"})
    public String setUser( @RequestBody User user){
        userService.setAUser(user);
        return "往redis存了一个对象";
    }
    @GetMapping({"/getUser"})
    public User getUser(@RequestParam("id") Long id){
        User user = userService.getAUser(id);
        return user;
    }
}
