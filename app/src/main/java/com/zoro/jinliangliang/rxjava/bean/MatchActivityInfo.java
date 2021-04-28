package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2021/2/24
 * description:
 */
public class MatchActivityInfo implements Serializable {
    private String activityId;
    private String activityImage;
    private String activityTopic;
    private String activityBegionTime;
    private String activityEndTime;
    private String jionPeopleNum;
    private List<String> jionPeopleIcons = new ArrayList<>();
    //活动状态 1:已开始 2:已结束
    private String status;

    public String getActivityId() {
        return activityId == null ? "" : activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityImage() {
        return activityImage == null ? "" : activityImage;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage;
    }

    public String getActivityTopic() {
        return activityTopic == null ? "" : activityTopic;
    }

    public void setActivityTopic(String activityTopic) {
        this.activityTopic = activityTopic;
    }

    public String getActivityBegionTime() {
        return activityBegionTime == null ? "" : activityBegionTime;
    }

    public void setActivityBegionTime(String activityBegionTime) {
        this.activityBegionTime = activityBegionTime;
    }

    public String getActivityEndTime() {
        return activityEndTime == null ? "" : activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getJionPeopleNum() {
        return jionPeopleNum == null ? "" : jionPeopleNum;
    }

    public void setJionPeopleNum(String jionPeopleNum) {
        this.jionPeopleNum = jionPeopleNum;
    }

    public List<String> getJionPeopleIcons() {
        if (jionPeopleIcons == null) {
            return new ArrayList<>();
        }
        return jionPeopleIcons;
    }

    public void setJionPeopleIcons(List<String> jionPeopleIcons) {
        this.jionPeopleIcons = jionPeopleIcons;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
