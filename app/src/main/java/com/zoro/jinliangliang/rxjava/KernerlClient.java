package com.zoro.jinliangliang.rxjava;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author : Zoro.
 * @Date : 2019/6/9
 * @Describe :
 */
public class KernerlClient {

    private KernerlService mService;

    //https://gateway.hdlcontrol.com/community-wisdom/   线上环境
    //http://47.114.117.27:7777/community-wisdom/  开发环境
    public KernerlClient() {
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("https://gateway.hdlcontrol.com/community-wisdom/")
                .client(OkHttpManager.getInstance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit1.create(KernerlService.class);
    }

    public KernerlService getService() {
        return mService;
    }
}
