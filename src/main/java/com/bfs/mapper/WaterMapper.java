package com.bfs.mapper;

import com.bfs.entity.Water;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface WaterMapper {
    void addWater(List<Water> waterList);

}
