package com.zoro.jinliangliang;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import java.util.ArrayList;
import java.util.List;

import androidx.multidex.MultiDex;
import io.dcloud.common.util.RuningAcitvityUtil;
import io.dcloud.feature.sdk.DCSDKInitConfig;
import io.dcloud.feature.sdk.DCUniMPSDK;
import io.dcloud.feature.sdk.MenuActionSheetItem;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        try {
//            WXSDKEngine.registerModule("TestModule", TestModule.class);
//            WXSDKEngine.registerComponent("myText", TestText.class);
//        } catch (WXException e) {
//            e.printStackTrace();
//        }
        //初始化 uni小程序SDK ----start----------
//        MenuActionSheetItem item = new MenuActionSheetItem("关于", "gy");
//        MenuActionSheetItem item1 = new MenuActionSheetItem("获取当前页面url", "hqdqym");
//        MenuActionSheetItem item2 = new MenuActionSheetItem("跳转到宿主原生测试页面", "gotoTestPage");
//        List<MenuActionSheetItem> sheetItems = new ArrayList<>();
//        sheetItems.add(item);
//        sheetItems.add(item1);
//        sheetItems.add(item2);
        // 非小程序进程
        if(!RuningAcitvityUtil.getAppName(getBaseContext()).contains("io.dcloud.unimp")) {
            //请在此处初始化其他三方SDK
        }
        DCSDKInitConfig config = new DCSDKInitConfig.Builder()
                .setCapsule(false)
                .setMenuDefFontSize("16px")
                .setMenuDefFontColor("#ff00ff")
                .setMenuDefFontWeight("normal")
                .setEnableBackground(false)//开启后台运行
                .build();
        DCUniMPSDK.getInstance().initialize(this, config, new DCUniMPSDK.IDCUNIMPPreInitCallback() {
            @Override
            public void onInitFinished(boolean b) {
                Log.i("unimp","onInitFinished----"+b);
            }
        });
        //初始化 uni小程序SDK ----end----------
    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }
}
