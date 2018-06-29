package com.bfs.controller;

import com.bfs.entity.Water;
import com.bfs.mapper.WaterFlowMapper;
import com.bfs.service.WaterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("water")
public class WaterController {
    protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    @Autowired
    private WaterService waterService;
    @Autowired
    private WaterFlowMapper waterFlowMapper;
    @RequestMapping("/add")
    public String waterAdd(){
        return "freemarker/importWater";
    }

    /**
     * 导入excel数据
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    public String importExcel(HttpServletRequest request) throws Exception {
        //获取上传的文件
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
        //数据导入
        waterService.addWaterList(file);
        return "freemarker/page/hello";
    }

    /**
     * 分页查询所有
     * @param pageNow
     * @param waterDepth
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String getWaterListWithPage(@RequestParam(value = "pageNow",required = false) Integer pageNow,
                                       @RequestParam(value = "waterDepth",required = false) String waterDepth,
                                       Model model){
        model.addAttribute("results",false);
        PageInfo<Water> list = waterService.getWaterListWithPage(pageNow,waterDepth);
        if(list.getList().size() >= 1){
            model.addAttribute("results",true);
        }
        String var2 = waterFlowMapper.getConum();
        model.addAttribute("waterlist",list.getList());
        pageNow = pageNow == null?1:pageNow;
        model.addAttribute("currentPage",pageNow);
        model.addAttribute("conum",var2);
        model.addAttribute("waterDepth",waterDepth);
        model.addAttribute("list",list);
        return "freemarker/list";
    }

    /**
     * 根据Id修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateDo/{id}")
    public String update(@PathVariable Integer id,Model model){
        Water water = waterService.selectById(id);
        if (water !=null) {
            model.addAttribute(water);
        }
        return "freemarker/updatewater";
    }

    /**
     * 根据Id查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String selectById(@PathVariable Integer id,Model model) {
        List<Water> waterList = new ArrayList<>();
        Water water = waterService.selectById(id);
        if (water !=null) {
            waterList.add(water);
        }
        String var2 = waterFlowMapper.getConum();
        model.addAttribute("conum",var2);
        model.addAttribute("waterlist",waterList);
        return "freemarker/water";
    }

    /**
     * 修改执行
     * @param water
     * @return
     */
    @RequestMapping(value = "updateWater", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateWater(Water water) {
        resultMap.put("status", 400);
        int result = waterService.updateWater(water);
        if (result <= 0) {
            resultMap.put("message", "信息修改失败");
            return resultMap;
        }
        resultMap.put("message", "操作成功！");
        resultMap.put("status", 200);
        return resultMap;
    }
}
