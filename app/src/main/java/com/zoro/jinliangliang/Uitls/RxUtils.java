package com.zoro.jinliangliang.Uitls;


import android.util.Log;

import com.zoro.jinliangliang.rxjava.bean.BaseInfo;
import com.zoro.jinliangliang.rxjava.http.exceptions.DataNullException;
import com.zoro.jinliangliang.rxjava.http.exceptions.OtherException;
import com.zoro.jinliangliang.rxjava.http.exceptions.WeChatLoginException;

import javax.security.auth.login.LoginException;

import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {
    /**
     * 统一线程处理
     * @param <T> 指定的泛型类型
     * @return FlowableTransformer
     */
    public static <T> FlowableTransformer<T, T> rxFlSchedulerHelper() {
        return flowable -> flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一线程处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<BaseInfo<T>, T> handleResult() {
        return httpResponseObservable ->
                 httpResponseObservable.flatMap((Function<BaseInfo<T>, Observable<T>>) baseResponse -> {
                    if(baseResponse.getCode() == 1) {
                        if(baseResponse.getData() != null){
                            return createData(baseResponse.getData());
                        } else {
                            return Observable.error(new DataNullException(baseResponse.getMessage()));
                        }
                    } else if (2 == baseResponse.getCode() || 3 == baseResponse.getCode()){
                        return Observable.error(new LoginException(baseResponse.getMessage()));
                    } else if (4 == baseResponse.getCode()){
                        return Observable.error(new WeChatLoginException());
                    } else {
                        return Observable.error(new OtherException(baseResponse.getMessage()));
                    }
                });
    }

    /**
     * 得到 Observable
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    private static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }
}
