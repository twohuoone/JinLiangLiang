package com.zoro.jinliangliang.rxjava.bean;

/**
 * Created by Zoro
 * Created on 2020/12/14
 * description:
 */
public class RankInfo {
    private String headIconUrl;
    private String runnerName;
    private String duration;
    private String distance;
    private String dateFormat;
    private String turnsNumber;

    public String getDuration() {
        return duration == null ? "" : duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHeadIconUrl() {
        return headIconUrl == null ? "" : headIconUrl;
    }

    public void setHeadIconUrl(String headIconUrl) {
        this.headIconUrl = headIconUrl;
    }

    public String getRunnerName() {
        return runnerName == null ? "" : runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public String getDistance() {
        return distance == null ? "" : distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDateFormat() {
        return dateFormat == null ? "" : dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getTurnsNumber() {
        return turnsNumber == null ? "" : turnsNumber;
    }

    public void setTurnsNumber(String turnsNumber) {
        this.turnsNumber = turnsNumber;
    }
}
