package com.zoro.jinliangliang.CoordinatorLayout;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.zoro.jinliangliang.R;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoro
 * Created on 2021/3/4
 * description:
 */
public class Test2Activity extends Activity {

    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
//        iv.setNestedScrollingEnabled(false);
        ViewCompat.setNestedScrollingEnabled(iv,false);
    }
}
