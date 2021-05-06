package com.zoro.jinliangliang.base;

import android.app.Activity;

import com.alibaba.fastjson.JSONObject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Author: lzw
 * Date: 2018/3/9
 * Description: This is BasePresenter
 */

public class BasePresenter<V extends BaseView> {
    private V mView;

    protected Activity mActivity;

    protected CompositeSubscription mCompositeSubscription;

    protected JSONObject params;


    protected String sign;

    public BasePresenter(Activity mActivity, V mView) {
        this.mActivity = mActivity;
        this.mView = mView;
        params = new JSONObject();
    }

    /**
     * 绑定View
     *
     * @param mView
     */
    public void attachView(V mView) {
        this.mView = mView;
    }

    /**
     * 在Activity销毁的时候解除绑定View
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * 判断Activity是否与View绑定
     *
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 返回View对象
     *
     * @return
     */
    public V getView() {
        if (isViewAttached()) {
            return mView;
        } else {
            return null;
        }
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }
}
