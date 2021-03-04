package com.zoro.jinliangliang.Uitls;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Zoro
 * Created on 2021/2/23
 * description:
 */
public class DensityUtil {
    public static int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    public static float px2dp(float pxValue) {
        return (pxValue / Resources.getSystem().getDisplayMetrics().density);
    }

    public static float getScreenHeight() {
        return (Resources.getSystem().getDisplayMetrics().density);
    }

    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }
}
