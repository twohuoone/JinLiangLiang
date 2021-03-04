package com.zoro.jinliangliang.CoordinatorLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * Created by Zoro
 * Created on 2021/3/4
 * description:
 */
@CoordinatorLayout.DefaultBehavior(MyBehavior.class)
public class Immmmmage extends androidx.appcompat.widget.AppCompatImageView {
    public Immmmmage(Context context) {
        super(context);
    }

    public Immmmmage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Immmmmage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
