package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;

/**
 * Created by Zoro
 * Created on 2021/3/5
 * description:
 */
public class ActivateInfo implements Serializable {
    private String communityCode;
    private boolean isActivate;

    public String getCommunityCode() {
        return communityCode == null ? "" : communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }
}
