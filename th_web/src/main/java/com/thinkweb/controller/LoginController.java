package com.thinkweb.controller;

import com.thinkweb.common.Constant;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Think Cat on 15/10/5.
 */

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session){
        //TODO java spring security user remeber me
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (Constant.BALNKUSER.equals(o.toString())){
            return "login";
        }
        return "index";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
