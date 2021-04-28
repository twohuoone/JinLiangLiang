package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;

/**
 * Created by Zoro
 * Created on 2020/12/16
 * description:
 */
public class ThemeInfo implements Serializable {
    private String screenName;
    private String screenTemplate;
    private String materialTemplateId;
    private String screenQrCode;
    private String screenVideo;
    private String materialVideoId;

    public String getScreenName() {
        return screenName == null ? "" : screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenTemplate() {
        return screenTemplate == null ? "" : screenTemplate;
    }

    public void setScreenTemplate(String screenTemplate) {
        this.screenTemplate = screenTemplate;
    }

    public String getMaterialTemplateId() {
        return materialTemplateId == null ? "" : materialTemplateId;
    }

    public void setMaterialTemplateId(String materialTemplateId) {
        this.materialTemplateId = materialTemplateId;
    }

    public String getScreenQrCode() {
        return screenQrCode == null ? "" : screenQrCode;
    }

    public void setScreenQrCode(String screenQrCode) {
        this.screenQrCode = screenQrCode;
    }

    public String getScreenVideo() {
        return screenVideo == null ? "" : screenVideo;
    }

    public void setScreenVideo(String screenVideo) {
        this.screenVideo = screenVideo;
    }

    public String getMaterialVideoId() {
        return materialVideoId == null ? "" : materialVideoId;
    }

    public void setMaterialVideoId(String materialVideoId) {
        this.materialVideoId = materialVideoId;
    }
}
