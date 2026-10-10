package com.disabngo.blockynexus.web;

import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.disabngo.blockynexus.entity.ActivityTaskTitleList;
import com.disabngo.blockynexus.entity.CampaignBetRequest;
import com.disabngo.blockynexus.entity.CampaignGame;
import com.disabngo.blockynexus.entity.CampaignHistory;
import com.disabngo.blockynexus.entity.CampaignLogo;
import com.disabngo.blockynexus.entity.CampaignRankRewardWithTime;
import com.disabngo.blockynexus.entity.CampaignRedPoint;
import com.disabngo.blockynexus.entity.CampaignReward;
import com.disabngo.blockynexus.entity.CampaignTask;
import com.disabngo.blockynexus.entity.TurntableStatus;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.umeng.analytics.pro.au;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface ICampaignApi {
    @GET("/activity/api/v1/activity/worldCup")
    @Deprecated
    Observable<HttpResponse<List<CampaignGame>>> campaignGameList(@Header(au.M) String str);

    @GET("/config/files/blockymods-activity-logo")
    Observable<HttpResponse<CampaignLogo>> campaignLogo();

    @GET("/config/files/campaign-precious-reward")
    Observable<HttpResponse<List<Integer>>> campaignPreciousReward();

    @GET("/activity/api/v1/activity/action")
    Observable<HttpResponse<List<ActivityTaskAction>>> getActivityTaskActionList(@Header(au.M) String str, @Query("titleType") String str2);

    @POST("/activity/api/v1/receive/reward")
    Observable<HttpResponse<ActivityTaskAction>> getActivityTaskReward(@Header(au.M) String str, @Query("titleType") String str2, @Query("actionId") long j);

    @GET("/activity/api/v2/activity/title")
    Observable<HttpResponse<ActivityTaskTitleList>> getActivityTaskTitleList(@Header(au.M) String str);

    @GET("/activity/api/v1/activity/worldCup/history")
    @Deprecated
    Observable<HttpResponse<List<CampaignHistory>>> getBetHistory(@Header(au.M) String str);

    @GET("/activity/api/v1/activity/worldCup/notice")
    @Deprecated
    Observable<HttpResponse<CampaignRedPoint>> getCampaignRedPoint(@Header(au.M) String str);

    @GET("/activity/api/v1/slot/machine/user/gold/draw/status")
    Observable<HttpResponse<TurntableStatus>> getGoldDrawStatus(@Header(au.M) String str, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str2);

    @PUT("/activity/api/v1/activity/user/integral/reward")
    @Deprecated
    Observable<HttpResponse> getIntegralReward(@Query("type") String str, @Query("decorationId") long j, @Header(au.M) String str2);

    @GET("/activity/api/v1/activity/user/rank/reward")
    @Deprecated
    Observable<HttpResponse<CampaignRankRewardWithTime>> getRankReward(@Header(au.M) String str);

    @GET("/activity/api/v1/activity/task")
    @Deprecated
    Observable<HttpResponse<List<CampaignTask>>> getTaskList(@Header(au.M) String str);

    @PUT("/activity/api/v1/activity/task/reward")
    @Deprecated
    Observable<HttpResponse<Integer>> getTaskReward(@Query("id") long j, @Header(au.M) String str);

    @GET("/activity/api/v1/lucky/turntable/gold/status")
    Observable<HttpResponse<TurntableStatus>> getTurntableRedPoint(@Header(au.M) String str, @Query(AdUnitActivity.EXTRA_ACTIVITY_ID) String str2);

    @GET("/activity/api/v1/activity/worldCup/integral")
    @Deprecated
    Observable<HttpResponse<Integer>> myIntegral(@Header(au.M) String str);

    @GET("/activity/api/v1/activity/user/integral/rank")
    @Deprecated
    Observable<HttpResponse<CampaignRank>> myRank(@Header(au.M) String str);

    @POST("/activity/api/v1/activity/worldCup")
    @Deprecated
    Observable<HttpResponse> postBetRequest(@Body CampaignBetRequest campaignBetRequest, @Header(au.M) String str);

    @GET("/activity/api/v1/activity/user/integral/reward")
    @Deprecated
    Observable<HttpResponse<CampaignReward>> rewardList(@Query("type") String str, @Header(au.M) String str2);

    @POST("/activity/api/v1/signIn")
    Observable<HttpResponse<Map<String, Integer>>> signIn(@Header(au.M) String str);

    @GET("/activity/api/v1/signIn")
    Observable<HttpResponse<UserSignInResponse>> signInList(@Header(au.M) String str);

    @GET("/activity/api/v1/activity/integral/rank")
    @Deprecated
    Observable<HttpResponse<PageData<CampaignRank>>> totalRank(@Query("pageNo") int i, @Query("pageSize") int i2, @Header(au.M) String str);
}
