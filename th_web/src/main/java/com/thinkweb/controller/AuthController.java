package com.thinkweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by  Think Cat on 2015/10/14.
 */
@Controller
@RequestMapping("auth")
public class AuthController {

    @RequestMapping(value = "")
    public String index(){
        return "auth/auth";
    }
}
