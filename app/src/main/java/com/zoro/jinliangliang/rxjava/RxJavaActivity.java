package com.zoro.jinliangliang.rxjava;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.zoro.jinliangliang.R;
import com.zoro.jinliangliang.Uitls.LogUtils;
import com.zoro.jinliangliang.Uitls.RxUtils;
import com.zoro.jinliangliang.rxjava.bean.ActivateInfo;
import com.zoro.jinliangliang.rxjava.bean.BaseInfo;
import com.zoro.jinliangliang.rxjava.http.HttpUtils;

public class RxJavaActivity extends AppCompatActivity {
    private static final String TAG = "RxJavaActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        mContext = this;
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        getData();
    }

    private void test() {
        Observable.create(new ObservableOnSubscribe<BaseInfo<Integer>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<BaseInfo<Integer>> e) throws Exception {
                e.onNext(new BaseInfo<>(1,1));
            }
        }).compose(RxUtils.handleResult()).subscribe(new HDLSubscriber<Integer>(mContext) {
            @Override
            public void successCallBack(Integer integer) {

            }

            @Override
            public void errorCallBack(int code, String error) {

            }
        });
    }

    private void test1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                e.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                e.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                Log.e(TAG, "Observable emit 4" + "\n");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe : " + d.isDisposed() + "\n");
//                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG, "onNext : value : " + integer + "\n");
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
//                    mDisposable.dispose();
//                    Log.e(TAG, "onNext : isDisposable : " + mDisposable.isDisposed() + "\n");
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete" + "\n");
            }
        });
    }

    private void test2() {
        Observable.zip(getIntegerObservable(), getStringObservable(), new BiFunction<Integer, String, String>() {
            @Override
            public String apply(@NonNull Integer integer, @NonNull String s) throws Exception {
                return s + integer;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(new HDLSubscriber<String>(mContext) {
            @Override
            public void successCallBack(String s) {

            }

            @Override
            public void errorCallBack(int code, String error) {

            }

        });
    }


    private Observable<String> getStringObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("A");
                    Log.e(TAG, "String emit : A \n");
                    e.onNext("B");
                    Log.e(TAG, "String emit : B \n");
                    e.onNext("C");
                    Log.e(TAG, "String emit : C \n");
                }
            }
        });
    }

    private Observable<Integer> getIntegerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(1);
                    Log.e(TAG, "Integer emit : 1 \n");
                    e.onNext(2);
                    Log.e(TAG, "Integer emit : 2 \n");
                    e.onNext(3);
                    Log.e(TAG, "Integer emit : 3 \n");
                    e.onNext(4);
                    Log.e(TAG, "Integer emit : 4 \n");
                    e.onNext(5);
                    Log.e(TAG, "Integer emit : 5 \n");
                }
            }
        });
    }

    @SuppressLint("CheckResult")
    private void getData() {
        JSONObject params = new JSONObject();
        params.put("deviceCode", "GetMacAddress.getMacAddress()");
        HttpUtils.mService.isActivate(HttpUtils.getRequestBody(params))
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new HDLSubscriber<ActivateInfo>(mContext) {

                    @Override
                    public void successCallBack(ActivateInfo activateInfo) {

                    }

                    @Override
                    public void errorCallBack(int code, String error) {

                    }
                });
    }


}