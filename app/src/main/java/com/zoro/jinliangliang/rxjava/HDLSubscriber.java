package com.zoro.jinliangliang.rxjava;

import android.content.Context;

import com.zoro.jinliangliang.Uitls.LogUtils;
import com.zoro.jinliangliang.Uitls.ToastUtils;
import com.zoro.jinliangliang.rxjava.bean.BaseInfo;

import java.net.SocketTimeoutException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;
import retrofit2.adapter.rxjava.HttpException;

/**
 * @Author : Zoro.
 * @Date : 2017/11/2.
 * @Describe :
 */

public abstract class HDLSubscriber<T> implements Observer<T> {

    private Context mContext;

    public HDLSubscriber(Context context) {
        this.mContext = context;
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            ToastUtils.showLong("连接超时");
        } else {
            ToastUtils.showLong("网络异常");
            if (e != null) {
                if (e.getMessage() != null) {
                    LogUtils.i("Error=" + e.getMessage().toString());
                }
            }
        }
        retrofit2.HttpException exception = (retrofit2.HttpException) e;
        String message = exception.response().message();
        int code = exception.response().code();
        errorCallBack(code, message);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(final T t) {
        if (t instanceof BaseInfo) {
            ((BaseInfo) t).validateCode(mContext, new BaseInfo.SuccessImpl() {
                @Override
                public void success() {
                    try{
                        successCallBack(t);
                    }catch (Exception e){
                        ToastUtils.showLong("fdsfasdfasfasdf");
                        LogUtils.d("fdsfasdfasfasdf");
                    }
                }

                @Override
                public void error() {
                    errorCallBack(9999,"业务错误");
                }

            });
        } else {
            successCallBack(t);
        }
    }

    //网络请求成功
    public abstract void successCallBack(T t);


    //网络请求失败或者数据使用异常
    public abstract void errorCallBack(int code, String error);

}
