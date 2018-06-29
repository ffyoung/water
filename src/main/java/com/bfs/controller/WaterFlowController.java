package com.bfs.controller;

import com.bfs.entity.WaterFlow;
import com.bfs.service.WaterFlowService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-21
 */
@Controller
@RequestMapping("wf")
public class WaterFlowController {

    @Autowired
    private WaterFlowService waterFlowService;

    protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

    @RequestMapping(value = "delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteSF(@PathVariable Long id){
        resultMap.put("status", 400);
        int result = waterFlowService.deleteById(id);
        if (result <= 0) {
            resultMap.put("message", "删除操作失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }

    @RequestMapping(value = "betDate",method = RequestMethod.POST)
    public String getDateWF(@RequestParam("startTime")Date startTime,
                            @RequestParam("endTime")Date endTime){


        PageInfo<WaterFlow> list = waterFlowService.getTimeList(startTime,endTime);


        return "freemarker/main";
    }
}
