package com.zoro.jinliangliang.rxjava;


import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : Zoro.
 * @Date : 2018/7/25.
 * @Describe :
 */

public class SignTools {

    public static String getTimeStamp() {
        java.util.Date currentdate = new java.util.Date();//当前时间
        return (currentdate.getTime() / 1000) + "";
    }

    public static String getSign(JSONObject params, String appSecret) {
        StringBuffer sb = new StringBuffer();
        if (params != null) {
            List<String> keys = new ArrayList<String>(params.keySet());
            Collections.sort(keys);
            for (int i = 0; i < keys.size(); i++) {
                String key = keys.get(i);
                if (params.get(key) instanceof String || params.get(key) instanceof Boolean
                        || params.get(key) instanceof Integer || params.get(key) instanceof Double
                        || params.get(key) instanceof Float || params.get(key) instanceof Long) {
                    String value = params.get(key).toString();
                    if (!"".equals(value) && !"sign".equals(key))  //参数集合中 sign不参与签名
                        if (sb.length() > 0)
                            sb.append("&" + key + "=" + value);
                        else
                            sb.append(key + "=" + value);
                }
            }
        }
        if (!"".equals(appSecret))
            sb.append(appSecret);
        return stringToMD5(sb.toString());
    }


    public static String stringToMD5(String text) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(text.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }
}
