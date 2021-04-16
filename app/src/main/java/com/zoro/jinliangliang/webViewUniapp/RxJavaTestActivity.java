package com.zoro.jinliangliang.webViewUniapp;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zoro.jinliangliang.R;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxJavaTestActivity extends AppCompatActivity {


    @BindView(R.id.tv_Text)
    TextView tvText;
    @BindView(R.id.webview)
    WebView webView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            setContent("asd");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_test);
        ButterKnife.bind(this);
        webView.loadUrl("file:///android_asset/web/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new AndroidtoJs(), "HDL");//AndroidtoJS类对象映射到js的test对象
    }

    private void aaaaa() {
        setContent("asd");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setContent(String aaa) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("str", aaa);
        webView.evaluateJavascript("javascript:setContent(" + JSON.toJSONString(jsonObject) + ")", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
            }
        });
    }

    // 继承自Object类
    public class AndroidtoJs extends Object {
        @JavascriptInterface
        public void changeContent(String aa) {
            tvText.setText(aa);
//            setContent("df");
            handler.sendEmptyMessage(2);
        }
    }
}