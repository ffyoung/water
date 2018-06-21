package com.bfs.controller;

import com.bfs.service.WaterFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
