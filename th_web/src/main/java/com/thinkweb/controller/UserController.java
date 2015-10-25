package com.thinkweb.controller;

import com.thinkcat.dto.Pager;
import com.thinkcat.domain.AdminUser;
import com.thinkcat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        return "auth/user";
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ResponseBody
    public Pager<AdminUser> getUserPage(@RequestParam(name = "pageNum",defaultValue = "1")int pageNum,
                              @RequestParam(name = "pageLength",defaultValue = "10")int length){
        Pager<AdminUser> userPager = userService.findUserPager(pageNum,length);
        return userPager;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUserIndex(HttpServletRequest request){
        List<AdminUser> users = userService.findAllUser();
        request.setAttribute("userList",users);
        return "auth/addUser";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(AdminUser user){
        userService.insertUser(user);
        return "auth/user";
    }


}
