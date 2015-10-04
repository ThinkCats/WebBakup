package com.thinkweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by juepei on 2015/9/25.
 */
@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        System.out.println("hello");
        request.setAttribute("hello","hello world");
        return "main";
    }
}
