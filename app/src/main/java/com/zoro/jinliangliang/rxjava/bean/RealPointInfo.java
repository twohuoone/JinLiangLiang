package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2021/2/24
 * description:
 */
public class RealPointInfo implements Serializable {
    private String pointLatitude;
    private String pointLongitude;
    private List<String> list = new ArrayList<>();
    private List<String> deviceList = new ArrayList<>();

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

    public List<String> getDeviceList() {
        if (deviceList == null) {
            return new ArrayList<>();
        }
        return deviceList;
    }

    public void setDeviceList(List<String> deviceList) {
        this.deviceList = deviceList;
    }
}
