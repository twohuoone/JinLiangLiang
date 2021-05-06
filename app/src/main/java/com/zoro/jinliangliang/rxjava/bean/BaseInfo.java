package com.zoro.jinliangliang.rxjava.bean;

import android.content.Context;

import com.zoro.jinliangliang.Uitls.AppManagerUtils;
import com.zoro.jinliangliang.Uitls.ToastUtils;

import java.io.Serializable;


/**
 * @Author : Zoro.
 * @Date : 2019/6/9.
 * @Describe :
 */
public class BaseInfo<T> implements Serializable {

    public static final int SUCCESS = 1;

    private int code;
    private T data;
    private String message;
    private SuccessImpl mSuccessCallBack;

    public BaseInfo(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void validateCode(final Context context, final SuccessImpl successCallBack) {
        mSuccessCallBack = successCallBack;
        if ("0".equals(code)) {
            mSuccessCallBack.success();
        } else if ("10004".equals(code) || "10007".equals(code)) {
            //清空sp数据，跳转到登录页面
            finishActivities();
        } else {
            //处理同账号不同项目，配网串的问题
//            ToastUtils.showShort(message);
            successCallBack.error();
        }
    }

    public interface SuccessImpl {
        //网络请求成功，返回正确的数据
        void success();

        //网络请求成功，接口返回异常
        void error();
    }

    private void finishActivities() {
//        ToastUtils.showLong("登录失效，请重新登录！");
//        SharedPreferencesUtils.getInstance().clearAll();
//        AppManagerUtils.getAppManager().finishAllActivity();
//        ARouter.getInstance().build(CommonSdk.getRefreshTokenErrorActivityPath()).navigation();
    }
}

