package com.zoro.jinliangliang.rxjava;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends ResourceObserver<T> {
    private static final String TAG = "BaseObserver";
    private String mErrorMsg;
    private boolean isShowError = true;
    private Context mContext;

    public BaseObserver(Context context) {
        this.mContext = context;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(T t) {
        onDoNext(t);
    }

    protected abstract void onDoNext(T t);

    @Override
    public void onError(Throwable e) {
    }

}
