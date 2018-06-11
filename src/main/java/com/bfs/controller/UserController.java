package com.bfs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-11
 */
@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("/login")
    public String userLogin(){
       return "freemarker/login";
    }


    @RequestMapping("/hello")
    public String hello(){
        return "freemarker/page/hello";
    }
}
