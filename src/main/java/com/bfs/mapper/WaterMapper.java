package com.bfs.mapper;

import com.bfs.entity.Water;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WaterMapper {


    void addWater(List<Water> waterList);

    @Select("select * from t_water where water_depth = #{hight}")
    Water selectOne(String hight);

    List<Water> getWaterList(@Param("waterDepth") String waterDepth);

    int updateFlowByWaterDepth(Water water);


}
