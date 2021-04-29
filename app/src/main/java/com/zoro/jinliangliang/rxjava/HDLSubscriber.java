package com.zoro.jinliangliang.rxjava;

import android.content.Context;
import com.zoro.jinliangliang.Uitls.LogUtils;
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

public abstract class HDLSubscriber<T> implements Observer<T>  {

    private Context mContext;

    public HDLSubscriber(Context context) {
        this.mContext = context;
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        dealError(e, mContext);
        if (e instanceof HttpException) {
            //获取对应statusCode和Message
            HttpException exception = (HttpException) e;
            String message = exception.response().message();
            int code = exception.response().code();
            error(code, e.getMessage());
        } else if (e instanceof SSLHandshakeException) {
            //接下来就是各种异常类型判断...
            error(18888, e.getMessage());
        } else {
            error(404, e.getMessage());
        }
    }

    /**
     * 异常打印
     *
     * @param e
     * @param context
     */
    public static void dealError(Throwable e, Context context) {
        if (e instanceof SocketTimeoutException) {
//            ToastUtils.showLong("连接超时");
        } else {
//            ToastUtils.showLong("网络异常");
            if (e != null) {
                if (e.getMessage() != null) {
                    LogUtils.i("Error=" + e.getMessage().toString());
                }
            }
        }
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(final T t) {
        if(t instanceof BaseInfo){
            ((BaseInfo) t).validateCode(mContext, new BaseInfo.SuccessCallBack() {
                @Override
                public void successCallBack() {
                    successful(t);
                }

                @Override
                public void errorCallBack() {

                }
            });
        }else{
            successful(t);
        }
    }

    //网络请求成功
    public abstract void successful(T t);

    //网络请求失败，同时处理请求失败的外部ui更改
    public abstract void error(int code, String error);

}
