package com.sandboxol.videosubmit.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.videosubmit.entity.BGTubeInfoResponse;
import com.sandboxol.videosubmit.entity.BGTubeMultiLanguageConfig;
import com.sandboxol.videosubmit.entity.BGTubeSignInfoResponse;
import com.sandboxol.videosubmit.entity.LinkInfo;
import com.sandboxol.videosubmit.entity.SignStatusResponse;
import com.umeng.analytics.pro.au;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes4.dex */
public interface IVideoSubmitApi {
    @GET("/config/files/bg-tube-activity-config")
    Observable<HttpResponse<BGTubeInfoResponse>> getBGTubeConfigInfo();

    @GET("/activity/api/v1/bgtube/multilingualism/info")
    Observable<HttpResponse<BGTubeMultiLanguageConfig>> getBGTubeMultiLanguageConfig(@Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str, @Query(au.M) String str2);

    @GET("/activity/api/v1/bgtube/sign")
    Observable<HttpResponse<BGTubeSignInfoResponse>> getBGTubeSignInfoResponse(@Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str);

    @GET("/activity/api/v1/bgtube/sign/check")
    Observable<HttpResponse<SignStatusResponse>> getSignUpStatus(@Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str);

    @POST("/activity/api/v1/bgtube/sign")
    Observable<HttpResponse> postSignUp(@Query("youTubeName") String str, @Query(au.M) String str2, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str3);

    @POST("/activity/api/v1/bgtube/video/link")
    Observable<HttpResponse> postVideoLink(@Body LinkInfo linkInfo, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str);
}
