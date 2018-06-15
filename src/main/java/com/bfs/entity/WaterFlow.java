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
    /** 上一次获取的时间 */
    private Date lastDate;
    /** 最新获取的时间 */
    private Date newDate;
    /** 上游水位高度 */
    private BigDecimal topHight;
    /** 下游水位高度 */
    private BigDecimal bottomHight;
    /** 瞬时流量 */
    private BigDecimal flow;
    /** 总流量 */
    private BigDecimal totalFlow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public BigDecimal getTopHight() {
        return topHight;
    }

    public void setTopHight(BigDecimal topHight) {
        this.topHight = topHight;
    }

    public BigDecimal getBottomHight() {
        return bottomHight;
    }

    public void setBottomHight(BigDecimal bottomHight) {
        this.bottomHight = bottomHight;
    }

    public BigDecimal getFlow() {
        return flow;
    }

    public void setFlow(BigDecimal flow) {
        this.flow = flow;
    }

    public BigDecimal getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(BigDecimal totalFlow) {
        this.totalFlow = totalFlow;
    }


    @Override
    public String toString() {
        return "WaterFlow{" +
                "id=" + id +
                ", lastDate=" + lastDate +
                ", newDate=" + newDate +
                ", topHight=" + topHight +
                ", bottowHight=" + bottomHight +
                ", flow=" + flow +
                ", totalFlow=" + totalFlow +
                '}';
    }
}
