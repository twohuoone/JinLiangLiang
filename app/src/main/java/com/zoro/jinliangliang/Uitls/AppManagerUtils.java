package com.zoro.jinliangliang.Uitls;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.Iterator;
import java.util.Stack;

/**
 * Author: Zoro
 * Date: 2019/6/9
 * Description: This is AppManagerUtils
 */

public class AppManagerUtils {

    private static AppManagerUtils appManagerUtils;

    private AppManagerUtils() {
    }

    public static AppManagerUtils getAppManager() {
        if (null == appManagerUtils) {
            synchronized (AppManagerUtils.class) {
                if (null == appManagerUtils) {
                    appManagerUtils = new AppManagerUtils();
                }
            }
        }
        return appManagerUtils;
    }

    /**
     * 获取AppVersion
     *
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {
        String version = "";
        try {
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 默认的Activity堆栈
     */
    private Stack<Activity> activityStack;

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }


    /**
     * 移除Activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?>... args) {
        Iterator<Activity> iterator = activityStack.listIterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            for (Class<?> cls : args) {
                if (activity.getClass().equals(cls)) {
                    activity.finish();
                    iterator.remove();
                }
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                Activity activity = activityStack.get(i);
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
        activityStack.clear();
    }

}
