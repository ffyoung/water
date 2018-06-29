package com.bfs.mapper;

import com.bfs.entity.WaterFlow;
import org.apache.ibatis.annotations.*;

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


    /**
     * 查询最后一条数据的结束时间
     * @return
     */
    @Select("select end_date from t_water_flow order by id desc limit 1")
    @Results({
            @Result(property = "endDate", column = "end_date"),
    })
    Date getLastWFendDate();

    /**
     * 查询最后一条数据
     * @return
     */
    @Select("select * from t_water_flow order by id desc limit 1")
    @Results({
            @Result(property = "startDate",  column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "timeFlow", column = "time_flow"),
            @Result(property = "totalFlow", column = "total_flow")
    })
    WaterFlow getLastWF();

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @Delete("delete from t_water_flow where id = #{id}")
    int deleteById(Long id);

    /**
     * 根据end_time列  查询时间的起始到结束时间的所有信息。
     * @param startTime
     * @param endTime
     * @return
     */
    @Select(" select * from t_water_flow  where end_date between #{startTime} and #{endTime}")
    List<WaterFlow> getTimeList(Date startTime,Date endTime);

}
