package com.bfs.service;

import com.bfs.entity.WaterFlow;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-20
 */
public interface WaterFlowService {

    int saveWF(WaterFlow waterFlow);

    PageInfo<WaterFlow> findAllWFS(Integer pageNow, Integer pageSize);

    String getMonum();

    String getConum();

    Date getLastWF();

    int newWFAndInsert(String moh,String coh);

    int deleteById(Long id);

    int minAbs(String moh, String coh);

    PageInfo<WaterFlow> getTimeList(Date startTime,Date endTime);




}
