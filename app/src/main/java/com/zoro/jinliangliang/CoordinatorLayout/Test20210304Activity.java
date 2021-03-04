package com.zoro.jinliangliang.CoordinatorLayout;

import android.app.Activity;
import android.os.Bundle;

import com.zoro.jinliangliang.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoro
 * Created on 2021/3/4
 * description:
 */
public class Test20210304Activity extends Activity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    TestActivityAdapter activityAdapter;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        ButterKnife.bind(this);
        for (int i=0;i<20;i++){
            list.add("");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityAdapter= new TestActivityAdapter(this);
        recyclerView.setAdapter(activityAdapter);
        activityAdapter.addRefreshData(list);
    }
}
