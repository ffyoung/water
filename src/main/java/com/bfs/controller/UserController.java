package com.bfs.controller;

import com.bfs.entity.User;
import com.bfs.entity.Water;
import com.bfs.entity.WaterFlow;
import com.bfs.mapper.UserMapper;
import com.bfs.mapper.WaterFlowMapper;
import com.bfs.mapper.WaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private WaterFlowMapper waterFlowMapper;

    protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

    private int temNum = 0;

    private Date temDate;

    private BigDecimal totalFlow = new BigDecimal("0");

    private BigDecimal timeFlow = new BigDecimal("0");


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
    public String index(Model model, @RequestParam("moh")String moh,
                        @RequestParam("coh")String coh){
        //初始化一个WaterFlow对象
        WaterFlow waterFlow = new WaterFlow();
        //初始化一个当前时间，当请求到来时指定最新的时间
        Date date = new Date();
        /**
         * 先存储一个WaterFlow对象然后再展示
         * WaterFlow对象一共10个属性
         * 1.监测断面编号
         * 2.对比断面编号
         * 3.流速
         * 4.开始时间
         * 5.结束时间
         * 6.监测断面水位
         * 7.对比断面水位
         * 8.流量
         * 9.时段累积输配水量
         * 10.区间累积水量
         * 11.备注
         */

        /** 1.监测断面编号 */
        String monum = "10010";
        waterFlow.setMonum(monum);

        /** 2.对比断面编号 */
        String conum = "10012";
        waterFlow.setConum(conum);

        /** 3.流速 */
        BigDecimal ls = new BigDecimal("0");
        waterFlow.setVelocity(ls);

        Date lastWFDate = waterFlowMapper.getLastWF();

        if( lastWFDate == null){
            //保证第一次执行，之后每一次不再执行
            temNum++;
            // 第一次请求lastDate与newDate相同
            /** 4.上一次的时间（开始时间） */
            waterFlow.setStartDate(date);
            /** 5.当前时间（结束时间） */
            waterFlow.setEndDate(date);
        }else {
            // 给newDate赋值当前时间
            /** 4.上一次的时间 （开始时间） */
            waterFlow.setStartDate(lastWFDate);
            /** 5.当前时间 （结束时间） */
            waterFlow.setEndDate(date);
        }
        /**
         *      给temDate赋值，为了确保第二次显示的列表当中
         *  能够使上一次记录的newDate和当前记录的lastDate保持一致
         */
        temDate = waterFlow.getEndDate();


        //  传值监测水位H
        BigDecimal bd = new BigDecimal(moh);
        /** 6.水位H1 */
        waterFlow.setMoh(bd);

        // 传值H2下游水位
        bd = new BigDecimal(coh);
        /** 7.水位H2 */
        waterFlow.setCoh(bd);

        // 根据监测水位moh水位查询出流量Q
        Water water = waterMapper.selectOne(moh);
        BigDecimal Qn = new BigDecimal(water.getFlow());
        /** 8.流量Q */
        waterFlow.setFlow(Qn);

        // 时段累积水量
        timeFlow = timeFlow.add(Qn);
        /** 9.时段累积水量Q总 */
        waterFlow.setTimeFlow(timeFlow);

        // 求和
        totalFlow = totalFlow.add(timeFlow);
        /** 10.区间累积水量Q总 */
        waterFlow.setTotalFlow(totalFlow);

        /** 11.备注 */
        waterFlow.setRemark("备注");

        // 调用WaterFlowMapper对WaterFlow对象进行添加
        int temp = waterFlowMapper.saveWF(waterFlow);

        // 水资源列表
        List<WaterFlow> list = waterFlowMapper.findAllWFS();

        // 监测断面编号
        String var1 = waterFlowMapper.getMonum();
        // 对比断面编号
        String var2 = waterFlowMapper.getConum();

        model.addAttribute("wfList",list);
        model.addAttribute("monum",var1);
        model.addAttribute("conum",var2);
        return "freemarker/main";
    }
}