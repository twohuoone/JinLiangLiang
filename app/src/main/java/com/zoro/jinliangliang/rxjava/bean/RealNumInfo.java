package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2021/2/24
 * description:
 */
public class RealNumInfo implements Serializable {
    private String jionPeopleNum;
    private String lastTime;
    private String pointLatitude;
    private String pointLongitude;
    private List<String> list = new ArrayList<>();

    public String getJionPeopleNum() {
        return jionPeopleNum == null ? "" : jionPeopleNum;
    }

    public void setJionPeopleNum(String jionPeopleNum) {
        this.jionPeopleNum = jionPeopleNum;
    }

    public String getLastTime() {
        return lastTime == null ? "" : lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getPointLatitude() {
        return pointLatitude == null ? "" : pointLatitude;
    }

    public void setPointLatitude(String pointLatitude) {
        this.pointLatitude = pointLatitude;
    }

    public String getPointLongitude() {
        return pointLongitude == null ? "" : pointLongitude;
    }

    public void setPointLongitude(String pointLongitude) {
        this.pointLongitude = pointLongitude;
    }

    public List<String> getList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
