package com.bfs.mapper;

import com.bfs.entity.Water;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WaterMapper {


    void addWater(List<Water> waterList);

    @Select("select * from t_water where water_level = #{hight}")
    Water selectOne(String hight);

}
