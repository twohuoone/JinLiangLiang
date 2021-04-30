package com.zoro.jinliangliang.rxjava;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

import static com.alibaba.fastjson.util.IOUtils.UTF8;

/**
 * @Author : Zoro.
 * @Date : 2019/6/9
 * @Describe :
 */
public class OkHttpManager {

    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getInstance() {
        if (mOkHttpClient == null) {
            synchronized (OkHttpManager.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new HttpCacheInterceptor())
                            .readTimeout(15, TimeUnit.SECONDS)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

    /**
     * Request获取请求参数
     *
     * @param request
     * @return
     */
    private static String getOriginalSign(Request request) {
        String url = request.url() + "";
        String sign_request_body = "";
        String method = request.method();
        if ("POST".equals(method))
            sign_request_body = bodyToString(request);
        else {
            String[] body = url.split("\\?");
            if (body.length > 1)
                sign_request_body = body[1];
        }
        return sign_request_body;
    }

    /**
     * Request获取请求参数
     *
     * @param request
     * @return
     */
    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    static class HttpCacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            /**
             * 获取token
             * 1.判断sp里面是否有token（如果没有通过模拟Response返回没有token的编码）
             * 2.判断token是否过期
             * 2.1.没有过期的话直接执行chain.proceed(request)
             * 3.过期的话需要通过refreshToken进行token刷新
             * 4.如果刷新失败直接退出到登录页面（如果失败通过模拟Response返回到登录页面的编码）
             * 5.如果刷新成功直接进行chain.proceed(request)
             */
            Request request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build();
//            if (1 == 1) {
//            //返回token刷新失败的数据
//                String json = "{\"code\": 200, \"message\": \"success\"}";
//                Response response = new Response.Builder()
//                        .code(200)
//                        .addHeader("Content-Type", "application/json")
//                        .body(ResponseBody.create(MediaType.parse("application/json"), json))
//                        .message(json)
//                        .request(chain.request())
//                        .protocol(Protocol.HTTP_2)
//                        .build();
//                return response;
//            }
            //记录请求耗时
            long startNs = System.nanoTime();
            RequestBody requestBody = request.body();
            Response response;
            try {
                //发送请求，获得相应，
                response = chain.proceed(request);
            } catch (Exception e) {
                throw e;
            }
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            //获得返回的body，注意此处不要使用responseBody.string()获取返回数据，原因在于这个方法会消耗返回结果的数据(buffer)
            ResponseBody responseBody = response.body();
            //为了不消耗buffer，我们这里使用source先获得buffer对象，然后clone()后使用
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            //获得返回的数据
            Buffer buffer = source.buffer();
            //使用前clone()下，避免直接消耗
            String s = buffer.clone().readString(Charset.forName("UTF-8"));
            Log.d("RetrofitLog:", "headers==================================================");
            Headers headers = response.headers();
            Log.d("RetrofitLog:", headers.toString());
            Buffer buffer1 = new Buffer();
            requestBody.writeTo(buffer1);
            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            Log.d("RetrofitLog:", "params:" + buffer1.readString(charset));
            Log.d("RetrofitLog:", "url:" + request.url());
            Log.d("RetrofitLog:", "headers:" + request.headers().toString());
            Log.d("RetrofitLog:", "method:" + request.method());
            Log.d("RetrofitLog:", "耗时:" + tookMs + "ms");
            Log.d("RetrofitLog:", "response:" + buffer.clone().readString(Charset.forName("UTF-8")));
            Log.d("RetrofitLog:", "endding==================================================");

            return response;
        }
    }
}
