package com.bfs.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-13
 */
public class WaterFlow {

    /** id */
    private Integer id;
    /** 检测断面编号 */
    private String monum;
    /** 对比断面编号 */
    private String conum;
    /** 流速 */
    private BigDecimal velocity;
    /** 开始时间 */
    private Date startDate;
    /** 结束时间 */
    private Date endDate;
    /** 检测断面水深 */
    private BigDecimal moh;
    /** 对比断面水深 */
    private BigDecimal coh;
    /** 断面流量 */
    private BigDecimal flow;
    /** 时段累计输配水量 */
    private BigDecimal timeFlow;
    /** 区间累计水量 */
    private BigDecimal totalFlow;
    /** 备注 */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonum() {
        return monum;
    }

    public void setMonum(String monum) {
        this.monum = monum;
    }

    public String getConum() {
        return conum;
    }

    public void setConum(String conum) {
        this.conum = conum;
    }

    public BigDecimal getVelocity() {
        return velocity;
    }

    public void setVelocity(BigDecimal velocity) {
        this.velocity = velocity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getMoh() {
        return moh;
    }

    public void setMoh(BigDecimal moh) {
        this.moh = moh;
    }

    public BigDecimal getCoh() {
        return coh;
    }

    public void setCoh(BigDecimal coh) {
        this.coh = coh;
    }

    public BigDecimal getFlow() {
        return flow;
    }

    public void setFlow(BigDecimal flow) {
        this.flow = flow;
    }

    public BigDecimal getTimeFlow() {
        return timeFlow;
    }

    public void setTimeFlow(BigDecimal timeFlow) {
        this.timeFlow = timeFlow;
    }

    public BigDecimal getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(BigDecimal totalFlow) {
        this.totalFlow = totalFlow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WaterFlow{" +
                "id=" + id +
                ", monum='" + monum + '\'' +
                ", conum='" + conum + '\'' +
                ", velocity=" + velocity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", moh=" + moh +
                ", coh=" + coh +
                ", flow=" + flow +
                ", timeFlow=" + timeFlow +
                ", totalFlow=" + totalFlow +
                ", remark='" + remark + '\'' +
                '}';
    }
}
