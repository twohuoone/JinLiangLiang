package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2021/2/23
 * description:
 */
public class GroupActivtiyListInfo implements Serializable {
    private List<GroupActivtiyInfo> list = new ArrayList<>();

    public List<GroupActivtiyInfo> getList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    public void setList(List<GroupActivtiyInfo> list) {
        this.list = list;
    }
}
