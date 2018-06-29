package com.bfs.service;

import com.bfs.entity.Water;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;


public interface WaterService {
    void addWaterList(MultipartFile file) throws Exception;
    PageInfo<Water> getWaterListWithPage(Integer pageNow,String waterDepth);
    int updateWater(Water water);
    Water selectById(Integer id);
}
