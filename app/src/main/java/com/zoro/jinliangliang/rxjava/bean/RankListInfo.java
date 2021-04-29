package com.zoro.jinliangliang.rxjava.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoro
 * Created on 2020/12/16
 * description:
 */
public class RankListInfo {
    private List<RankInfo> list = new ArrayList<>();
    private int pageNo;
    private int pageSize;
    private int totalCount;

    public List<RankInfo> getList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    public void setList(List<RankInfo> list) {
        this.list = list;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
