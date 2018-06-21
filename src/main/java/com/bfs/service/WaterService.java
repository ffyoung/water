package com.bfs.service;

import com.bfs.entity.Water;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;


public interface WaterService {
    void addWaterList(MultipartFile file) throws Exception;
    PageInfo<Water> getWaterListWithPage(Integer pageNow,Integer pageSize,String waterDepth);
    int updateFlowByWaterDepth(Water water);
}
