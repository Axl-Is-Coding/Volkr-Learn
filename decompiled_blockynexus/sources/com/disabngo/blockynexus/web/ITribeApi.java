package com.disabngo.blockynexus.web;

import com.disabngo.blockynexus.entity.ClanResponse;
import com.disabngo.blockynexus.entity.RequestJoinTribe;
import com.disabngo.blockynexus.entity.TribeClanRequest;
import com.disabngo.blockynexus.entity.TribeDonationHistory;
import com.disabngo.blockynexus.entity.TribeDonationInfo;
import com.disabngo.blockynexus.entity.TribeDonationResponse;
import com.disabngo.blockynexus.entity.TribeMessage;
import com.disabngo.blockynexus.entity.TribeNoticeGet;
import com.disabngo.blockynexus.entity.TribeNoticePost;
import com.disabngo.blockynexus.entity.TribeRank;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.disabngo.blockynexus.entity.TribeShopDetail;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.disabngo.blockynexus.entity.TribeTask;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.entity.RankInfo;
import com.sandboxol.center.entity.TribeDetail;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.TribeMember;
import com.umeng.analytics.pro.au;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface ITribeApi {
    @PUT("/clan/api/v1/clan/tasks/accept")
    Observable<HttpResponse> acceptTask(@Query("id") long j, @Query("type") int i, @Header(au.M) String str);

    @PUT("/clan/api/v1/clan/tribe/member/agreement")
    Observable<HttpResponse> agreeJoin(@Query("otherId") long j, @Header(au.M) String str);

    @PUT("/clan/api/v1/clan/tribe/member/agreement/invitation")
    Observable<HttpResponse> agreeJoinTribe(@Query("id") long j, @Header(au.M) String str);

    @PUT("/clan/api/v1/clan/decorations/purchase")
    Observable<HttpResponse> buyDecoration(@Header(au.M) String str, @Query("decorationId") String[] strArr);

    @POST("/clan/api/v2/clan/tribe")
    Observable<HttpResponse<TribeClanRequest>> clanRequest(@Header(au.M) String str, @Body TribeClanRequest tribeClanRequest);

    @PUT("/clan/api/v1/clan/tribe")
    Observable<HttpResponse<TribeClanRequest>> clanUpdate(@Body TribeClanRequest tribeClanRequest, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/decorations/details/{decorationId}")
    Observable<HttpResponse<TribeShopDetail>> decorationDetail(@Header(au.M) String str, @Path("decorationId") long j);

    @DELETE("clan/api/v1/clan/tribe")
    Observable<HttpResponse> dissolveTribe(@Query("clanId") long j, @Header(au.M) String str);

    @GET("/clan/api/v2/clan/tribe/donation/history")
    Observable<HttpResponse<PageData<TribeDonationHistory>>> donationHistory(@Query("pageNo") int i, @Query("pageSize") int i2, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/tribe/donation")
    Observable<HttpResponse<TribeDonationInfo>> donationInfo(@Header(au.M) String str);

    @POST("/clan/api/v3/clan/tribe/donation")
    Observable<HttpResponse<TribeDonationResponse>> donationResponse(@Query("currency") int i, @Query(FirebaseAnalytics.Param.QUANTITY) int i2, @Header(au.M) String str);

    @DELETE("/clan/api/v1/clan/tribe/member")
    Observable<HttpResponse> exitTribe(@Query("clanId") long j, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/rank")
    Observable<HttpResponse<RankInfo<TribeRank>>> getAllTribeRank(@Query("type") String str, @Query("pageNo") int i, @Query("pageSize") int i2, @Header(au.M) String str2);

    @GET("/clan/api/v1/clan/tribe/currency")
    Observable<HttpResponse<Long>> getMyTribeGold(@Header(au.M) String str);

    @GET("/clan/api/v1/clan/user/rank")
    Observable<HttpResponse<TribeRank>> getMyTribeRank(@Query("type") String str, @Header(au.M) String str2);

    @GET("/clan/api/v2/clan/personal/tasks")
    Observable<HttpResponse<TribeTask>> getPersonTask(@Query("type") int i, @Header(au.M) String str);

    @PUT("/clan/api/v1/clan/tasks")
    Observable<HttpResponse> getTaskReward(@Query("id") long j, @Query("type") int i, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/tribe/id")
    Observable<HttpResponse<String>> getTribeId(@Header(au.M) String str);

    @GET("/clan/api/v1/clan/tribe/bulletin")
    Observable<HttpResponse<TribeNoticeGet>> getTribeNotice(@Header(au.M) String str);

    @GET("/clan/api/v2/clan/tasks")
    Observable<HttpResponse<TribeTask>> getTribeTask(@Query("type") int i, @Header(au.M) String str);

    @POST("/clan/api/v1/clan/tribe/member/invite")
    Observable<HttpResponse> inviteFriend(@Query("friendIds") String[] strArr, @Query("msg") String str, @Header(au.M) String str2);

    @POST("/clan/api/v1/clan/tribe/bulletin")
    Observable<HttpResponse> postTribeNotice(@Body TribeNoticePost tribeNoticePost, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/tribe/recommendation")
    Observable<HttpResponse<List<TribeRecommendation>>> recommendList(@Header(au.M) String str);

    @PUT("/clan/api/v1/clan/tribe/member/rejection")
    Observable<HttpResponse> rejectJoin(@Query("otherId") long j, @Header(au.M) String str);

    @PUT("/clan/api/v1/clan/tribe/member/rejection/invitation")
    Observable<HttpResponse> rejectJoinTribe(@Query("id") long j, @Header(au.M) String str);

    @DELETE("/clan/api/v1/clan/tribe/member/remove")
    Observable<HttpResponse> removeMember(@Query("otherId") long j, @Header(au.M) String str);

    @POST("/clan/api/v1/clan/tribe/member")
    Observable<HttpResponse> requestJoinTribe(@Body RequestJoinTribe requestJoinTribe, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/tribe/blurry/info")
    Observable<HttpResponse<PageData<TribeRecommendation>>> searchTribe(@Query("clanName") String str, @Query("pageNo") int i, @Query("pageSize") int i2, @Header(au.M) String str2);

    @PUT("/clan/api/v1/clan/tribe/member")
    Observable<HttpResponse> setIdentity(@Query("otherId") long j, @Query("type") int i, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/tribe/base")
    Observable<HttpResponse<TribeDetail>> tribeBaseInfo(@Header(au.M) String str);

    @GET("/clan/api/v2/clan/tribe")
    Observable<HttpResponse<TribeDetail>> tribeDetail(@Query("clanId") long j, @Header(au.M) String str);

    @GET("/clan/api/v1/clan/tribe/member")
    Observable<HttpResponse<List<TribeMember>>> tribeMember(@Header(au.M) String str);

    @GET("/clan/api/v2/clan/tribe/member/message")
    Observable<HttpResponse<List<TribeMessage>>> tribeMessage(@Header(au.M) String str);

    @GET("/clan/api/v1/clan/decorations/{typeId}")
    Observable<HttpResponse<PageData<TribeShopPageList>>> tribeShopGoodsList(@Header(au.M) String str, @Path("typeId") long j, @Query("pageNo") int i, @Query("pageSize") int i2);

    @PUT("/clan/api/v1/clan/free/verification")
    Observable<HttpResponse<ClanResponse>> verification(@Query("freeVerify") int i, @Header(au.M) String str);
}
