package com.zoro.jinliangliang.rxjava;



import com.zoro.jinliangliang.rxjava.bean.ActivateInfo;
import com.zoro.jinliangliang.rxjava.bean.BaseInfo;
import com.zoro.jinliangliang.rxjava.bean.GroupActivtiyListInfo;
import com.zoro.jinliangliang.rxjava.bean.MatchActivityListInfo;
import com.zoro.jinliangliang.rxjava.bean.RankListInfo;
import com.zoro.jinliangliang.rxjava.bean.RealNumInfo;
import com.zoro.jinliangliang.rxjava.bean.RealPointInfo;
import com.zoro.jinliangliang.rxjava.bean.ThemeInfo;
import com.zoro.jinliangliang.rxjava.bean.WeatherInfo;
import com.zoro.jinliangliang.rxjava.bean.WeekTrendInfo;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author : Zoro.
 * @Date : 2019/6/9
 * @Describe :
 */
public interface KernerlService {
//    扫描认证二维码
//    @POST("/smartHome/userItem/scanCodeShare")
//    Observable<BaseInfo> scanCodeShareSh(@Body RequestBody requestBody);
//    图片上传接口
//    @Multipart
//    @POST("/smartHome/community/uploadImg")
//    Observable<BaseInfo<ImageSubmitInfoSh>> uploadImgSh(@Part List<MultipartBody.Part> requestBody);

    //今日/本周/本月 排行榜
    @POST("/community-wisdom/mgmt/runway/screen/ranking")
    Observable<BaseInfo<RankListInfo>> ranking(@Body RequestBody requestBody);

    //大屏二维码/健身视频/模板 主题信息
    @POST("/community-wisdom/mgmt/runway/screen/theme")
    Observable<BaseInfo<ThemeInfo>> theme(@Body RequestBody requestBody);

    //本周全民运动趋势
    @POST("/community-wisdom/mgmt/runway/screen/weekTrend")
    Observable<BaseInfo<WeekTrendInfo>> weekTrend(@Body RequestBody requestBody);

    //天气/时间
    @POST("/community-wisdom/mgmt/runway/screen/weather")
    Observable<BaseInfo<WeatherInfo>> weather(@Body RequestBody requestBody);

    @POST("/community-wisdom/monitor/device/getVideoUrlByBoard")
    Observable<BaseInfo<Object>> getVideoUrlByBoard(@Body RequestBody requestBody);

    @POST("/community-wisdom/app/runway/team/banner")
    Observable<BaseInfo<GroupActivtiyListInfo>> groupActivity(@Body RequestBody requestBody);

    @POST("/community-wisdom/app/runway/activity/banner")
    Observable<BaseInfo<MatchActivityListInfo>> matchActivity(@Body RequestBody requestBody);

    @POST("/community-wisdom/mgmt/runway/screen/realNum")
    Observable<BaseInfo<RealNumInfo>> realNum(@Body RequestBody requestBody);

    @POST("/community-wisdom/mgmt/runway/screen/realPoint")
    Observable<BaseInfo<RealPointInfo>> realPoint(@Body RequestBody requestBody);

    @POST("/community-wisdom/app/activate/device/isActivate")
    Observable<BaseInfo<ActivateInfo>> isActivate(@Body RequestBody requestBody);

    @POST("/community-wisdom/app/activate/device/activate")
    Observable<BaseInfo<ActivateInfo>> activate(@Body RequestBody requestBody);



}

