package com.zoro.jinliangliang;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.feature.sdk.DCUniMPJSCallback;
import io.dcloud.feature.sdk.DCUniMPSDK;
import io.reactivex.annotations.NonNull;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zoro.jinliangliang.Uitls.LogUtils;
import com.zoro.jinliangliang.cardlayout.CardActivity;

import org.json.JSONObject;

import java.io.File;

public class MainActivity extends Activity {
    Context mContext;
    Handler mHandler;
    private Handler handler = new Handler(){
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            JSONObject data = new JSONObject();
            try {
                data.put("sj", "点击了关于");
                DCUniMPSDK.getInstance().sendUniMPEvent("gy", data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mHandler = new Handler();
        setContentView(R.layout.activity_main);

//        String wgtPath = getExternalCacheDir().getPath()+"/__UNI__04E3A11.wgt";
//
//       File zje_Dir = new File(Environment.getExternalStorageDirectory(), "Android/data/com.zje.iot");
//        if (!zje_Dir.exists()) {
//            boolean mkdirs = zje_Dir.mkdirs();
//        }

//        File[] files;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            files = getExternalFilesDirs(Environment.MEDIA_MOUNTED);
//            for(File file:files){
//                Log.e("wgtPath=====", String.valueOf(file));
//            }
//        }
//        LogUtils.d("wgtPath====="+getExternalFilesDir("").getAbsolutePath());
//        LogUtils.d("wgtPath====="+Environment.getExternalStorageDirectory().getAbsolutePath());
//        LogUtils.d("wgtPath====="+Environment.getDataDirectory());
//        LogUtils.d("wgtPath====="+getFilesDir().getAbsolutePath());
//        LogUtils.d("wgtPath====="+getCacheDir().getAbsolutePath());
//        LogUtils.d("wgtPath====="+getDir("myFile", MODE_PRIVATE).getAbsolutePath());
//        LogUtils.d("wgtPath====="+getExternalCacheDir().getPath());

        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
//                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__3397809");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                String wgtPath = getExternalFilesDir("").getAbsolutePath()+"/__UNI__3397809.wgt";
//                DCUniMPSDK.getInstance().releaseWgtToRunPathFromePath("__UNI__3397809", wgtPath, new ICallBack() {
//                    @Override
//                    public Object onCallBack(int code, Object pArgs) {
//                        LogUtils.d("wgtPath=====发送到发送到发送");
//                        if(code ==1) {//释放wgt完成
//                            try {
//                                DCUniMPSDK.getInstance().startApp(mContext, "__UNI__3397809");
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        } else{//释放wgt失败
//                            Toast.makeText(mContext, "资源释放失败", Toast.LENGTH_SHORT).show();
//                        }
//                        return null;
//                    }
//                });
                try {
                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__3397809");
//                    handler.sendEmptyMessageDelayed(1,5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__B6229F3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //"pages/tabBar/extUI/extUI" "pages/component/scroll-view/scroll-view"
                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__3397809", "pages/testManage/index");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button button4 = findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__04E3A11", "pages/component/view/view");
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("unimp", "延迟5秒结束 开始关闭当前小程序");
                            DCUniMPSDK.getInstance().closeCurrentApp();
                        }
                    }, 5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button button5 = findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject info = DCUniMPSDK.getInstance().getAppVersionInfo("__UNI__04E3A11");
                if (info != null) {
                    Log.e("unimp", "info===" + info.toString());
                }
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__2108B0A");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__2108B0A", "pages/sample/send-event");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__2108B0A", "pages/sample/ext-module");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        DCUniMPSDK.getInstance().setDefMenuButtonClickCallBack(new DCUniMPSDK.IMenuButtonClickCallBack() {
            @Override
            public void onClick(String appid, String id) {
                switch (id) {
                    case "gy": {
                        Log.e("unimp", "点击了关于" + appid);
                        //宿主主动触发事件
                        JSONObject data = new JSONObject();
                        try {
                            data.put("sj", "点击了关于");
                            DCUniMPSDK.getInstance().sendUniMPEvent("gy", data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "hqdqym": {
                        Log.e("unimp", "当前页面url=" + DCUniMPSDK.getInstance().getCurrentPageUrl());
                        break;
                    }
                    case "gotoTestPage":
                        DCUniMPSDK.getInstance().closeCurrentApp();
                        break;


                }
            }
        });

        DCUniMPSDK.getInstance().setUniMPOnCloseCallBack(new DCUniMPSDK.IUniMPOnCloseCallBack() {
            @Override
            public void onClose(String appid) {
//                Log.e("unimp", appid + "被关闭了");
//                Toast.makeText(mContext, appid + "被关闭了", Toast.LENGTH_SHORT).show();
            }
        });

        DCUniMPSDK.getInstance().setOnUniMPEventCallBack(new DCUniMPSDK.IOnUniMPEventCallBack() {
            @Override
            public void onUniMPEventReceive(String event, Object data, DCUniMPJSCallback callback) {
                Log.i("cs", "onUniMPEventReceive    event=" + event+"  ----"+data.toString());
                Intent intent = new Intent(MainActivity.this,CardActivity.class);
                startActivity(intent);
                //回传数据给小程序
//                callback.invoke("收到消息");
//                try {
//                    DCUniMPSDK.getInstance().startApp(mContext, "__UNI__B6229F3");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        });

        checkPermission();
    }

    /**
     * 检查并申请权限
     */
    public void checkPermission() {
        int targetSdkVersion = 0;
        String[] PermissionString = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        try {
            final PackageInfo info = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            targetSdkVersion = info.applicationInfo.targetSdkVersion;//获取应用的Target版本
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //Build.VERSION.SDK_INT是获取当前手机版本 Build.VERSION_CODES.M为6.0系统
            //如果系统>=6.0
            if (targetSdkVersion >= Build.VERSION_CODES.M) {
                //第 1 步: 检查是否有相应的权限
                boolean isAllGranted = checkPermissionAllGranted(PermissionString);
                if (isAllGranted) {
                    Log.e("err", "所有权限已经授权！");
                    return;
                }
                // 一次请求多个权限, 如果其他有权限是已经授予的将会自动忽略掉
                ActivityCompat.requestPermissions(this, PermissionString, 1);
            }
        }
    }

    /**
     * 检查是否拥有指定的所有权限
     */
    private boolean checkPermissionAllGranted(String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                // 只要有一个权限没有被授予, 则直接返回 false
                //Log.e("err","权限"+permission+"没有授权");
                return false;
            }
        }
        return true;
    }
}
