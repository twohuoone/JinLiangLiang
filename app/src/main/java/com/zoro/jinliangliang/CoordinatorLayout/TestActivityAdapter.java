package com.zoro.jinliangliang.CoordinatorLayout;

import android.content.Context;
import android.view.View;
import android.widget.TextView;


import com.zoro.jinliangliang.R;
import com.zoro.jinliangliang.Uitls.BaseRecyclerAdapter;
import com.zoro.jinliangliang.View.RoundAngleImageView;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: Zoro
 * Date: 2020/12/14
 * Description: This is HomeItemAdapter
 */

public class TestActivityAdapter extends BaseRecyclerAdapter<String, TestActivityAdapter.ViewHolder> {


    public TestActivityAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.test_activity_item_layout;
    }

    @Override
    protected ViewHolder onCreateViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, String mData, int pos) {
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View view) {
            super(view);
        }
    }
}
