package com.zoro.jinliangliang.CoordinatorLayout;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/**
 * Created by Zoro
 * Created on 2021/3/4
 * description:
 */
public class MyBehavior extends CoordinatorLayout.Behavior <View>{

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        if ( velocityY > 0 ) {
            child.animate().scaleX(2.0f).scaleY(2.0f).setDuration(2000).start();
        } else {
            child.animate().scaleX(1.0f).scaleY(1.0f).setDuration(2000).start();
        }

        return false;
//        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        ViewCompat.offsetTopAndBottom(child,dy);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return false;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int dependBottom = dependency.getBottom();

        child.setY(dependBottom + 50);
        child.setX(dependency.getLeft());

        return true;
    }

}
