package com.bfs.controller;

import com.bfs.entity.User;
import com.bfs.entity.WaterFlow;
import com.bfs.mapper.UserMapper;
import com.bfs.mapper.WaterMapper;
import com.bfs.service.WaterFlowService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    private WaterMapper waterMapper;

    @Autowired
    private WaterFlowService waterFlowService;

    protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

    @RequestMapping("login")
    public String loginIndex(){
        return "freemarker/login";
    }

    @RequestMapping(value = "main")
    @ResponseBody
    public Map<String,Object> hello(User user){

        resultMap.put("status",200);
        User count = userMapper.loginSure(user);
        if(count == null){
            resultMap.put("status",400);
        }
        return resultMap;
    }

    @RequestMapping(value = "index")
    public String index(Model model,
                        @RequestParam(value = "moh",required = false)String moh,
                        @RequestParam(value = "coh",required = false)String coh,
                        @RequestParam(value = "pn",required = false)Integer pageNow,
                        @RequestParam(value = "ps",required = false)Integer pageSize){

        // 新增一个WF对象并且执行insert操作
        if((moh == null || "".equals(moh))&& (( coh == null || "".equals(coh)))) {
            //空不执行

        }else {

            if(Math.abs(new BigDecimal(moh).subtract(new BigDecimal(coh)).doubleValue()) <= 0.005){
                int tempOne = waterFlowService.minAbs(moh, coh);
            }else{
                int tempTwo = waterFlowService.newWFAndInsert(moh, coh);
            }
        }

        // 水资源列表分页后的结果放在PageInfo中
        PageInfo<WaterFlow> list = waterFlowService.findAllWFS(pageNow,pageSize);

        //wf对象
        model.addAttribute("wfList",list.getList());
        //当前页面显示的条数
        model.addAttribute("pageSize",(pageSize == null) ? 25 : pageSize);
        //当前页面数
        model.addAttribute("currentPage",(pageNow == null) ? 1 : pageNow);
        // 监测断面编号
        model.addAttribute("monum",waterFlowService.getMonum());
        // 对比断面编号
        model.addAttribute("conum",waterFlowService.getConum());
        model.addAttribute("list",list);

        return "freemarker/main";
    }
}