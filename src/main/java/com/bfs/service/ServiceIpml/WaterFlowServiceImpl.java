package com.bfs.service.ServiceIpml;

import com.bfs.entity.Water;
import com.bfs.entity.WaterFlow;
import com.bfs.mapper.WaterFlowMapper;
import com.bfs.mapper.WaterMapper;
import com.bfs.service.WaterFlowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-20
 */
@Service
public class WaterFlowServiceImpl implements WaterFlowService {

    private Date temDate;

    private BigDecimal totalFlow = new BigDecimal("0");

    private BigDecimal timeFlow = new BigDecimal("0");

    private final long nd = 1000 * 24 * 60 * 60;
    private final long nh = 1000 * 60 * 60;
    private final long nm = 1000 * 60;


    @Autowired
    private WaterFlowMapper waterFlowMapper;

    @Autowired
    private WaterMapper waterMapper;

    public int saveWF(WaterFlow waterFlow) {
        return waterFlowMapper.saveWF(waterFlow);
    }

    /**
     * 利用PageHelper进行分页
     * @return
     */
    public PageInfo<WaterFlow> findAllWFS(Integer pageNow, Integer pageSize) {
        pageNow = (pageNow == null) ? 1 : pageNow;
        pageSize = (pageSize == null) ? 25 : pageSize;

        if(pageSize > 100){
            pageSize = 100;
        }
        PageHelper.startPage(pageNow,pageSize);
        List<WaterFlow> wfList = waterFlowMapper.findAllWFS();
        PageInfo<WaterFlow> page = new PageInfo<>(wfList);
        return page;
    }

    @Override
    public String getMonum() {
        return waterFlowMapper.getMonum();
    }

    @Override
    public String getConum() {
        return waterFlowMapper.getConum();
    }

    @Override
    public Date getLastWF() {
        return waterFlowMapper.getLastWFendDate();
    }

    /**
     * 先存储一个WaterFlow对象然后再展示
     * WaterFlow对象一共10个属性
     * 1.监测断面编号
     * 2.对比断面编号
     * 3.流速
     * 4.开始时间
     * 5.结束时间
     * 6.监测断面水位
     * 7.对比断面水位
     * 8.流量
     * 9.时段累积输配水量
     * 10.区间累积水量
     * 11.备注
     * @return temp 判断是否新增成功
     */
    public int newWFAndInsert(String moh,String coh) {

        //初始化一个WaterFlow对象
        WaterFlow waterFlow = new WaterFlow();

        //初始化一个当前时间，当请求到来时指定最新的时间
        Date date = new Date();

        Water water = waterMapper.selectOne(moh);

        WaterFlow lastWF = waterFlowMapper.getLastWF();

        /** 1.监测断面编号 */
        String monum = "10010";
        waterFlow.setMonum(monum);

        /** 2.对比断面编号 */
        String conum = "10012";
        waterFlow.setConum(conum);

        /** 3.流速 */
        BigDecimal ls = new BigDecimal(water.getVolicity());
        waterFlow.setVelocity(ls);

//        得到数据库中最后一行的结束时间作为下一次插入的起始时间，保证时间的连续性
        Date lastWFDate = waterFlowMapper.getLastWFendDate();

        if( lastWFDate == null){
            // 第一次请求lastDate与newDate相同
            /** 4.上一次的时间（开始时间） */
            waterFlow.setStartDate(date);
            /** 5.当前时间（结束时间） */
            waterFlow.setEndDate(date);
        }else {
            // 给newDate赋值当前时间
            /** 4.上一次的时间 （开始时间） */
            waterFlow.setStartDate(lastWFDate);
            /** 5.当前时间 （结束时间） */
            waterFlow.setEndDate(date);
        }

        /**
         *      给temDate赋值，为了确保第二次显示的列表当中
         *  能够使上一次记录的newDate和当前记录的lastDate保持一致
         */
        temDate = waterFlow.getEndDate();

        //  传值监测水位H
        BigDecimal bd = new BigDecimal(moh);
        /** 6.水位H1 */
        waterFlow.setMoh(bd);

        // 传值H2下游水位
        bd = new BigDecimal(coh);
        /** 7.水位H2 */
        waterFlow.setCoh(bd);

        // 根据监测水位moh水位查询出流量Q
        BigDecimal Qn = new BigDecimal(water.getFlow());
        /** 8.流量Q */
        waterFlow.setFlow(Qn);


        //生一个long对象，用来保存开始和结束时间的差值
        long times = waterFlow.getEndDate().getTime() - waterFlow.getStartDate().getTime();

        //换算成秒
        long es = times % nd % nh % nm / 1000;

        //生成BigDecimal对象
        BigDecimal ds = new BigDecimal(es);

        //将查询出来的流量Q乘以时间得出时段流量timeFlow.....（Qw）
        Qn = Qn.multiply(ds);

        // 时段累积水量
        timeFlow = timeFlow.add(Qn);
        /** 9.时段累积水量Q总 */
        waterFlow.setTimeFlow(timeFlow);

        // 求和
        try {
            totalFlow = lastWF.getTotalFlow().add(timeFlow);
        }catch (Exception e){
            totalFlow = totalFlow.add(timeFlow);
        }
        /** 10.区间累积水量Q总 */
        waterFlow.setTotalFlow(totalFlow);

        /** 11.备注 */
        waterFlow.setRemark("备注");

        // 调用WaterFlowMapper对WaterFlow对象进行添加
        int temp = waterFlowMapper.saveWF(waterFlow);

        return temp;
    }

    @Override
    public int deleteById(Long id) {
        return waterFlowMapper.deleteById(id);
    }

    /**
     * 1.条件当moh与coh的绝对值小于一定值
     * 2.此时Qn=0,Vq=0,水流静止，时段流量不在增加，区间流量不在增加。
     * @param moh
     * @param coh
     * @return
     */
    public int minAbs(String moh, String coh) {

        //初始化一个WaterFlow对象
        WaterFlow waterFlow = new WaterFlow();

        //初始化一个当前时间，当请求到来时指定最新的时间
        Date date = new Date();

        WaterFlow lastWF = waterFlowMapper.getLastWF();

        /** 1.监测断面编号 */
        String monum = "10010";
        waterFlow.setMonum(monum);

        /** 2.对比断面编号 */
        String conum = "10012";
        waterFlow.setConum(conum);

        /** 3.流速 */
        BigDecimal ls = new BigDecimal(0);
        waterFlow.setVelocity(ls);

        Date lastWFDate = waterFlowMapper.getLastWFendDate();

        if( lastWFDate == null){
            // 第一次请求lastDate与newDate相同
            /** 4.上一次的时间（开始时间） */
            waterFlow.setStartDate(date);
            /** 5.当前时间（结束时间） */
            waterFlow.setEndDate(date);
        }else {
            // 给newDate赋值当前时间
            /** 4.上一次的时间 （开始时间） */
            waterFlow.setStartDate(lastWFDate);
            /** 5.当前时间 （结束时间） */
            waterFlow.setEndDate(date);
        }

        /**
         *      给temDate赋值，为了确保第二次显示的列表当中
         *  能够使上一次记录的newDate和当前记录的lastDate保持一致
         */
        temDate = waterFlow.getEndDate();

        //  传值监测水位H
        BigDecimal bd = new BigDecimal(moh);
        /** 6.水位H1 */
        waterFlow.setMoh(bd);

        // 传值H2下游水位
        bd = new BigDecimal(coh);
        /** 7.水位H2 */
        waterFlow.setCoh(bd);

        // 根据监测水位moh水位查询出流量Q
        BigDecimal Qn = new BigDecimal(0);
        /** 8.流量Q */
        waterFlow.setFlow(Qn);

        // 时段累积水量
        /** 9.时段累积水量Q总 */
        timeFlow = Qn;
        waterFlow.setTimeFlow(Qn);

        // 求和
        try {
            totalFlow = lastWF.getTotalFlow().add(timeFlow);
        }catch (Exception e){
            totalFlow = totalFlow.add(timeFlow);
        }
        /** 10.区间累积水量Q总 */
        waterFlow.setTotalFlow(totalFlow);

        /** 11.备注 */
        waterFlow.setRemark("备注");

        // 调用WaterFlowMapper对WaterFlow对象进行添加
        int temp = waterFlowMapper.saveWF(waterFlow);

        return temp;
    }

    @Override
    public PageInfo<WaterFlow> getTimeList(Date startTime, Date endTime) {
        List<WaterFlow> wfList = waterFlowMapper.getTimeList(startTime,endTime);
        PageInfo<WaterFlow> page = new PageInfo<>(wfList);
        return page;
    }
}
