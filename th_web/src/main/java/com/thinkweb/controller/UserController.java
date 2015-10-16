package com.thinkweb.controller;

import com.thinkcat.common.Pager;
import com.thinkcat.domain.AdminUser;
import com.thinkcat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by  Think Cat on 2015/10/15.
 */
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String userIndex(){
        //default page limit 10 ,pageNum 1

        return "auth/user";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUserIndex(){
        return "auth/addUser";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(AdminUser user){
        int count = userService.insertUser(user);
        return "auth/auth";
    }

}
