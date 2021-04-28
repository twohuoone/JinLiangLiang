package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2020/12/16
 * description:
 */
public class WeekTrendInfo implements Serializable {

    private List<Float> xtrend = new ArrayList<>();

    public List<Float> getXtrend() {
        if (xtrend == null) {
            return new ArrayList<>();
        }
        return xtrend;
    }

    public void setXtrend(List<Float> xtrend) {
        this.xtrend = xtrend;
    }
}
