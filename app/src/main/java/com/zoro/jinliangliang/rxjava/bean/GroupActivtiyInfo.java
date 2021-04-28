package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2021/2/23
 * description:
 */
public class GroupActivtiyInfo implements Serializable {
    private String teamName;
    private String teamBadge;
    private String runnerName;
    private String teamSlogan;
    private String jionPeopleNum;
    private List<String> jionPeopleIcons = new ArrayList<>();
    private String appQrCode;

    public String getTeamName() {
        return teamName == null ? "" : teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamBadge() {
        return teamBadge == null ? "" : teamBadge;
    }

    public void setTeamBadge(String teamBadge) {
        this.teamBadge = teamBadge;
    }

    public String getRunnerName() {
        return runnerName == null ? "" : runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public String getTeamSlogan() {
        return teamSlogan == null ? "" : teamSlogan;
    }

    public void setTeamSlogan(String teamSlogan) {
        this.teamSlogan = teamSlogan;
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

    public String getAppQrCode() {
        return appQrCode == null ? "" : appQrCode;
    }

    public void setAppQrCode(String appQrCode) {
        this.appQrCode = appQrCode;
    }
}
