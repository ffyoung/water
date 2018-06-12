package com.bfs.controller;

import com.bfs.entity.User;
import com.bfs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-11
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

    private static String teem = "123456789";

    @RequestMapping("login")
    public String loginIndex(){
       return "freemarker/login";
    }

    @RequestMapping(value = "main")
    @ResponseBody
    public Map<String,Object> hello(User user){

        resultMap.put("status",200);
        resultMap.put("teemId",teem);
        User count = userMapper.loginSure(user);
        if(count == null){
            resultMap.put("status",400);
            resultMap.put("teemId","123456");
        }
        resultMap.put("teemId",teem);
        return resultMap;
    }

    @RequestMapping(value = "index/${teem_id}")
    public String index(@PathVariable("teem_id") String teemid){
        if(teem.equals(teemid)){
            return "freemarker/main";
        }else {
            return "freemarker/login";
        }

    }


}
