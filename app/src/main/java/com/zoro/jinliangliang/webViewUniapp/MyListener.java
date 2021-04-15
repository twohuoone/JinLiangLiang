package com.zoro.jinliangliang.webViewUniapp;

import java.util.EventListener;

/**
 * Created by Zoro
 * Created on 2021/4/14
 * description:
 */
public interface MyListener extends EventListener  {
    void onChange(MyEvent myEvent);
}
