package com.zoro.jinliangliang.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lzw
 * Date: 2018/3/8
 * Description: This is BaseListAdapter
 */

public abstract class BaseListAdapter<T, VH extends BaseListAdapter.ViewHolder> extends BaseAdapter {

    protected List<T> mData;

    protected LayoutInflater mLayoutInflater;

    protected Context mContext;

    public BaseListAdapter(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VH holder = null;
        if (view == null) {
            view = mLayoutInflater.inflate(getItemLayout(), viewGroup, false);
            holder = onCreateHolder(view);
            view.setTag(holder);
        } else {
            holder = (VH) view.getTag();
        }
        T t = getItem(i);
        onBindData(holder, t, i);
        return view;
    }


    //================对外的方法===================


    private void addData(List<T> dataList, boolean isRefresh) {
        if (this.mData == null) {
            this.mData = new ArrayList<>();
        }
        if (isRefresh) {
            this.mData.clear();
        }
        this.mData.addAll(dataList);
        notifyDataSetChanged();
    }

    public void addRefreshData(List<T> dataList) {
        addData(dataList, true);
    }

    public void addLoadData(List<T> dataList) {
        addData(dataList, false);
    }

    protected abstract int getItemLayout();

    protected abstract VH onCreateHolder(View view);

    protected abstract void onBindData(VH holder, T mData);

    protected void onBindData(VH holder, T mData, int pos) {
        onBindData(holder, mData);
    }

    public static class ViewHolder {

    }
}
