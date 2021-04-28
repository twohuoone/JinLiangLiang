package com.zoro.jinliangliang.rxjava;

/**
 * @Author : Zoro.
 * @Date : 2019/6/9
 * @Describe :
 */
public class KernerlFactory {
    private static KernerlService mKernerlService = null;
    private static final Object WATCH = new Object();

    public static KernerlService getKernerlApi(){
        synchronized (WATCH) {
            if (mKernerlService == null) {
                mKernerlService = new KernerlClient().getService();
            }
        }
        return mKernerlService;
    }
}
