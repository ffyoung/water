package com.bfs.controller;

import com.bfs.entity.Water;
import com.bfs.mapper.WaterFlowMapper;
import com.bfs.service.WaterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("water")
public class WaterController {
    @Autowired
    private WaterService waterService;
    @Autowired
    private WaterFlowMapper waterFlowMapper;
    @RequestMapping("/add")
    public String waterAdd(){
        return "freemarker/importWater";
    }
    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    public String importExcel(HttpServletRequest request) throws Exception {
        //获取上传的文件
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("upfile");
        //数据导入
        waterService.addWaterList(file);
        return "freemarker/page/hello";
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getWaterListWithPage(@RequestParam("pageNow") Integer pageNow,
                                       @RequestParam("waterDepth") String waterDepth,
                                       Model model){
        model.addAttribute("results",false);
        PageInfo<Water> list = waterService.getWaterListWithPage(pageNow,waterDepth);
        if(list.getList().size() >= 1){
            model.addAttribute("results",true);
        }
        Long totalPage = list.getTotal();
        String var2 = waterFlowMapper.getConum();
        model.addAttribute("waterlist",list.getList());
        model.addAttribute("totalPage",totalPage);
        pageNow = pageNow == null?1:pageNow;
        model.addAttribute("currentPage",pageNow);
        model.addAttribute("conum",var2);
        model.addAttribute("list",list);
        model.addAttribute("waterDepth",waterDepth);
        return "freemarker/list";
    }
}
