package com.zoro.jinliangliang.base;

/**
 * Author: lzw
 * Date: 2018/3/9
 * Description: This is BaseView
 */

public interface BaseView<T> {
    void showLoad();

    void showData(T data);

    void showNoData(String msg);

    void showError(String msg);
}
