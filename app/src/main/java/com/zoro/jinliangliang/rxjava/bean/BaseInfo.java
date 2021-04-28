package com.zoro.jinliangliang.rxjava.bean;

import android.content.Context;

import java.io.Serializable;


/**
 * @Author : Zoro.
 * @Date : 2019/6/9.
 * @Describe :
 */

public class BaseInfo<T> implements Serializable {
    private String code;
    private T data;
    private String message;
    private SuccessCallBack mSuccessCallBack;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public void validateCode(final Context context, final SuccessCallBack successCallBack) {
        mSuccessCallBack = successCallBack;
        if ("0".equals(code)) {
            mSuccessCallBack.successCallBack();
        }
//        else if ("10006".equals(code)) {
            //token失效
//            String timestamp = SignTools.getTimeStamp();
//            JSONObject params = new JSONObject();
//            JSONObject jsonObject = new JSONObject();
//            String sign = "";
//            params.put("timestamp", timestamp);
//            params.put("appKey", CommonSdk.getApp_key());
//            params.put("refreshToken", SharedPreferencesUtils.getInstance().getStringParam("refreshToken"));
//            sign = SignTools.getSign(params, CommonSdk.getApp_secret());
//            jsonObject.put("timestamp", timestamp);
//            jsonObject.put("appKey", CommonSdk.getApp_key());
//            jsonObject.put("sign", sign);
//            jsonObject.put("refreshToken", SharedPreferencesUtils.getInstance().getStringParam("refreshToken"));
//            HttpUtils.mService.refreshToken(HttpUtils.getSpecialRequestBody(jsonObject))
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Subscriber<BaseInfo<RefreshTokenInfo>>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            //refreshToken刷新失败，重新登录
//                            finishActivities();
//                        }
//
//                        @Override
//                        public void onNext(final BaseInfo<RefreshTokenInfo> refreshTokenInfoBaseInfo) {
//                            refreshTokenInfoBaseInfo.validateCode(context, new HttpRequestCallBack() {
//                                @Override
//                                public void successCallBack() {
//                                    long time = new Date().getTime() + Long.parseLong(refreshTokenInfoBaseInfo.getData().getExpiresIn())*1000;
//                                    SharedPreferencesUtils.getInstance().putStringParam("expiresIn", time + "");
//                                    SharedPreferencesUtils.getInstance().putStringParam("token", refreshTokenInfoBaseInfo.getData().getAccessToken());
//                                    SharedPreferencesUtils.getInstance().putStringParam("refreshToken", refreshTokenInfoBaseInfo.getData().getRefreshToken());
//                                    mSuccessCallBack.refreshToken();
//                                }
//
//                                @Override
//                                public void refreshToken() {
//
//                                }
//
//                            });
//                        }
//                    });
//        } else if ("10004".endsWith(code) || "10007".endsWith(code)) {
//            //清空sp数据，跳转到登录页面
//            finishActivities();
//        }
        else {
            //处理同账号不同项目，配网串的问题
//            ToastUtils.showShort(message);
            successCallBack.errorCallBack();
        }
    }

    public interface SuccessCallBack {
        //网络请求成功，返回正确的数据
        void successCallBack();

        //网络请求成功，refreshToken过期，需要先刷新然后再对接口进行请求
//        void refreshToken();

        //网络请求成功，接口返回异常
        void errorCallBack();
    }

    private void finishActivities() {
//        ToastUtils.showLong("登录失效，请重新登录！");
//        SharedPreferencesUtils.getInstance().clearAll();
//        AppManagerUtils.getAppManager().finishAllActivity();
//        ARouter.getInstance().build(CommonSdk.getRefreshTokenErrorActivityPath()).navigation();
    }
}

