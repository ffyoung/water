package com.bfs.mapper;

import com.bfs.entity.WaterFlow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-14
 */
public interface WaterFlowMapper {


    /**
      * 存储一个WaterFlow对象
     * @param waterFlow
     * @return
     */
    @Insert("INSERT into t_water_flow(id,monum,conum,velocity,start_date,end_date,moh,coh,flow,time_flow,total_flow,remark)" +
            "values(null, #{monum}, #{conum},#{velocity}, #{startDate}, #{endDate},#{moh}, #{coh}, #{flow}, #{timeFlow}, #{totalFlow}, #{remark})")
    int saveWF(WaterFlow waterFlow);

    /**
     * 查询所有WaterFlow
     * @return
     */
    @Select("select * from t_water_flow")
    @Results({
            @Result(property = "startDate",  column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "timeFlow", column = "time_flow"),
            @Result(property = "totalFlow", column = "total_flow")
    })
    List<WaterFlow> findAllWFS();


    /**
     * 查询监测断面编号
     * @return
     */
    @Select("select monum from t_water_flow group by monum ")
    String getMonum();

    /**
     * 查询对比断面编号
     * @return
     */
    @Select("select conum from t_water_flow group by conum ")
    String getConum();



    @Select("select end_date from t_water_flow order by id limit 1")
    Date getLastWF();





}
