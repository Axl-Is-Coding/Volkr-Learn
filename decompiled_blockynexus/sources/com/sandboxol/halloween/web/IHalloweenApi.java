package com.sandboxol.halloween.web;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.halloween.entity.ExchangeResponse;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.entity.HalloweenTask;
import com.sandboxol.halloween.entity.HalloweenTaskResponse;
import com.umeng.analytics.pro.au;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes4.dex */
public interface IHalloweenApi {
    @POST("/activity/api/v1/halloween/candy/exchange")
    Observable<HttpResponse<Integer>> exchangeCandy(@Query("candy") int i, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str);

    @POST("/activity/api/v1/halloween/reward/exchange")
    Observable<HttpResponse<ExchangeResponse>> exchangeReward(@Header(au.M) String str, @Query("rewardId") long j, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str2);

    @GET("/activity/api/v1/halloween/info")
    Observable<HttpResponse<HalloweenInfoResponse>> getDetailInfo(@Header(au.M) String str, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str2);

    @GET("/activity/api/v1/halloween/task/info")
    Observable<HttpResponse<List<HalloweenTask>>> getTaskList(@Header(au.M) String str, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str2);

    @GET("/decoration/api/v1/decorations/using")
    Observable<HttpResponse<List<SingleDressInfo>>> isUsingList(@Header(au.M) String str, @Query("otherId") long j);

    @POST("/activity/api/v1/halloween/task/reward/receive")
    Observable<HttpResponse<HalloweenTaskResponse>> receiveTaskReward(@Header(au.M) String str, @Query("taskType") String str2, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str3);
}
