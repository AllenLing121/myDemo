package com.ling.web;

import com.ling.entity.User;
import com.ling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lian on 04/30/2019.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/getUser")
    public User readUser(){

        User user = this.userService.findUserByUserName("aa");
        System.out.println("dd");
        return user;
    }
}
