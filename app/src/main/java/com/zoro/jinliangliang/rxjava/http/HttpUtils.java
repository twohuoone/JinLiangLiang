package com.zoro.jinliangliang.rxjava.http;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.zoro.jinliangliang.Uitls.LogUtils;
import com.zoro.jinliangliang.rxjava.KernerlFactory;
import com.zoro.jinliangliang.rxjava.KernerlService;
import com.zoro.jinliangliang.rxjava.SignTools;

import java.net.SocketTimeoutException;

import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * @Author : Zoro.
 * @Date : 2018/3/6.
 * @Describe :
 */

public class HttpUtils {
    public static final KernerlService mService = KernerlFactory.getKernerlApi();

    public static RequestBody getSpecialRequestBody(JSONObject jsonObject) {
        String s = jsonObject.toJSONString();
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
    }

    public static RequestBody getRequestBody(JSONObject params) {
        params.put("appKey", "HDL-SMART-COMMUNITY-TEST");
        params.put("timestamp", SignTools.getTimeStamp());
        String sign = SignTools.getSign(params, "6577b734048e88db22d1d697685674f0");
        JSONObject jsonObject = new JSONObject();
        for (String key : params.keySet()) {
            jsonObject.put(key, params.get(key));
        }
        jsonObject.put("sign", sign);
        String s = jsonObject.toString();
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
    }
    /**
     * 文件上传
     * @param file
     * @return
     */
//    public static List<MultipartBody.Part> getFileRequestBody(File file) {
//        JSONObject params = new JSONObject();
//        String timeStamp = SignTools.getTimeStamp();
//        params.put("appKey", CommonSdk.getApp_key());
//        params.put("timestamp", timeStamp);
//        String sign = SignTools.getSign(params, CommonSdk.getApp_secret());
//        JSONObject jsonObject = new JSONObject();
//        for (String key : params.keySet()) {
//            jsonObject.put(key, params.get(key));
//        }
//        jsonObject.put("sign", sign);
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);
//        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);//表单类型
//        builder.addFormDataPart("appKey", CommonSdk.getApp_key());
//        builder.addFormDataPart("timestamp", timeStamp);
//        builder.addFormDataPart("sign", sign);
//        builder.addFormDataPart("img", file.getName(), body);
//        return builder.build().parts();
//    }

}
