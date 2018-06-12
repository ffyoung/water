package com.bfs.controller;

import com.bfs.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("import")
public class WaterController {
    @Autowired
    private WaterService waterService;
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
}
