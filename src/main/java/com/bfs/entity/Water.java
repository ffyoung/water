package com.bfs.entity;

public class Water {
    private Integer id;
    private String water_depth;
    private String flow;
    private String area;
    private String velocity;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWater_depth() {
        return water_depth;
    }

    public void setWater_depth(String water_depth) {
        this.water_depth = water_depth;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Water{" +
                "id=" + id +
                ", water_depth='" + water_depth + '\'' +
                ", flow='" + flow + '\'' +
                ", area='" + area + '\'' +
                ", velocity='" + velocity + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
