package com.bfs.entity;

public class Water {
    private String water_level;
    private String flow  ;

    public String getWater_level() {
        return water_level;
    }

    public void setWater_level(String water_level) {
        this.water_level = water_level;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    @Override
    public String toString() {
        return "Water{" +
                "water_level='" + water_level + '\'' +
                ", flow='" + flow + '\'' +
                '}';
    }
}
