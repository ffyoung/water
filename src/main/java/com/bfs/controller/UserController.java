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
            resultMap.put("teemId","123456");
        }
        return resultMap;
    }

    @RequestMapping(value = "index")
    public String index(Model model, @RequestParam("th")String th,
                        @RequestParam("bh")String bh){
        //初始化一个WaterFlow对象
        WaterFlow waterFlow = new WaterFlow();
        //初始化一个当前时间，当请求到来时指定最新的时间
        Date date = new Date();
        /**
         * 先存储一个WaterFlow对象然后再展示
         * WaterFlow对象一共6个属性
         * 1.上一次的时间
         * 2.当前时间
         * 3.水位H1
         * 4.水位H2
         * 5.流量Q
         * 6.总流量total_Q
         */
        if( temNum == 0){
            //保证第一次执行，之后每一次不再执行
            temNum++;
            //第一次请求lastDate与newDate相同
            /** 1.上一次的时间 */
            waterFlow.setLastDate(date);
            /** 2.当前时间 */
            waterFlow.setNewDate(date);
        }else {
            //给newDate赋值当前时间
            /** 1.上一次的时间 */
            waterFlow.setLastDate(temDate);
            /** 2.当前时间 */
            waterFlow.setNewDate(date);
        }
        /**
         *      给temDate赋值，为了确保第二次显示的列表当中
         *  能够使上一次记录的newDate和当前记录的lastDate保持一致
         */
        temDate = waterFlow.getNewDate();


        //传值H1上游水位
        String hight = th;
        BigDecimal bd = new BigDecimal(hight);
        /** 3.水位H1 */
        waterFlow.setTopHight(bd);

        //传值H2下游水位
        hight = bh;
        bd = new BigDecimal(hight);
        /** 4.水位H2 */
        waterFlow.setBottomHight(bd);

        //根据水位查询出流量Q
        Water water = waterMapper.selectOne(hight);

        /** 5.流量Q */
        bd = new BigDecimal(water.getFlow());
        waterFlow.setFlow(bd);

        /** 6.流量Q总 */
        bd = bd.add(bd);
        waterFlow.setTotalFlow(bd);

        //调用WaterFlowMapper对WaterFlow对象进行添加
        int temp = waterFlowMapper.saveWF(waterFlow);

        //水资源列表
        List<WaterFlow> list = waterFlowMapper.findAllWFS();

        model.addAttribute("wfList",list);
        return "freemarker/main";
    }
}
