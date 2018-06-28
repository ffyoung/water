package com.bfs.mapper;

import com.bfs.entity.Water;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WaterMapper {

    /**
     * 导入excel表
     * @param waterList
     */
    void addWater(List<Water> waterList);

    @Select("select * from t_water where water_depth = #{hight}")
    Water selectOne(String hight);

    /**
     * 分页查询
     * @param waterDepth
     * @return
     */
    List<Water> getWaterList(@Param("waterDepth") String waterDepth);

    int updateWater(Water water);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Water selectById(Integer id);


}
