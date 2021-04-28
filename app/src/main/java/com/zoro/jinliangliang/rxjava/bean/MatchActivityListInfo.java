package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2021/2/24
 * description:
 */
public class MatchActivityListInfo implements Serializable {
    private List<com.hdl.smarttrack.bean.MatchActivityInfo> list = new ArrayList<>();
    private String totalCount;

    public List<com.hdl.smarttrack.bean.MatchActivityInfo> getList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    public void setList(List<com.hdl.smarttrack.bean.MatchActivityInfo> list) {
        this.list = list;
    }

    public String getTotalCount() {
        return totalCount == null ? "" : totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}