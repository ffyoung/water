package com.bfs.mapper;

import com.bfs.entity.WaterFlow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-14
 */
public interface WaterFlowMapper {


    @Insert("INSERT into t_water_flow(id,last_date,new_date,top_hight,bottom_hight,flow,total_flow) values(null, #{lastDate}, #{newDate}, #{topHight}, #{bottomHight}, #{flow}, #{totalFlow})")
    int saveWF(WaterFlow waterFlow);


    @Select("select * from t_water_flow")
    @Results({
            @Result(property = "lastDate",  column = "last_date"),
            @Result(property = "newDate", column = "new_date"),
            @Result(property = "topHight", column = "top_hight"),
            @Result(property = "bottomHight", column = "bottom_hight"),
            @Result(property = "totalFlow", column = "total_flow")
    })
    List<WaterFlow> findAllWFS();





}
