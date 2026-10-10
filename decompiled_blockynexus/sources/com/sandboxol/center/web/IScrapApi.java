package com.sandboxol.center.web;

import com.sandboxol.center.entity.ScrapHistoryInfo;
import com.sandboxol.center.entity.ScrapInfoInBackpack;
import com.sandboxol.center.entity.ScrapRequestTargetInfo;
import com.sandboxol.center.entity.ScrapRewardComposeInfo;
import com.sandboxol.center.entity.ScrapRewardDetails;
import com.sandboxol.center.entity.ScrapRewardInfo;
import com.sandboxol.center.entity.ScrapTreasureBoxConfig;
import com.sandboxol.center.entity.ScrapVipInfo;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.umeng.analytics.pro.au;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IScrapApi {
    @GET("/activity/api/{version}/collect/exchange/scrap/ask")
    Observable<HttpResponse<Object>> askScrap(@Path("version") String str, @Header(au.M) String str2, @Query("friendId") long j, @Query("scrapId") String str3);

    @GET("/activity/api/{version}/collect/exchange/user/scrap")
    Observable<HttpResponse<PageData<ScrapInfoInBackpack>>> getBackpackInfo(@Path("version") String str, @Header(au.M) String str2, @Query("type") int i, @Query("pageNo") int i2, @Query("pageSize") int i3);

    @GET("/activity/api/{version}/collect/exchange/card/combine")
    Observable<HttpResponse<Integer>> getCombineNum(@Path("version") String str);

    @GET("/activity/api/v1/collect/exchange/card/details/scrap")
    Observable<HttpResponse<PageData<ScrapRequestTargetInfo>>> getRequestTargetList(@Header(au.M) String str, @Query("scrapId") String str2, @Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/activity/api/v1/collect/exchange/reward/value")
    Observable<HttpResponse<Integer>> getRewardValue();

    @GET("/activity/api/v1/collect/exchange/user/scrap/value")
    Observable<HttpResponse<Integer>> getScrapBagValue();

    @GET("/activity/api/v1/collect/exchange/user/combine/record")
    Observable<HttpResponse<PageData<ScrapHistoryInfo>>> getScrapCombineHistory(@Header(au.M) String str, @Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/activity/api/v1/collect/exchange/user/scrap/{scrapId}")
    Observable<HttpResponse<Integer>> getScrapNum(@Header(au.M) String str, @Path("scrapId") String str2);

    @GET("/activity/api/{version}/collect/exchange/card/details")
    Observable<HttpResponse<ScrapRewardDetails>> getScrapRewardDetails(@Path("version") String str, @Header(au.M) String str2, @Query("cardId") String str3);

    @GET("/activity/api/{version}/collect/exchange/card/list")
    Observable<HttpResponse<PageData<ScrapRewardInfo>>> getScrapRewardList(@Path("version") String str, @Header(au.M) String str2, @Query("type") int i, @Query("pageNo") int i2, @Query("pageSize") int i3);

    @GET("/activity/api/v1/collect/exchange/description")
    Observable<HttpResponse<List<String>>> getScrapRule(@Header(au.M) String str);

    @GET("/activity/api/{version}/collect/exchange/treasurebox/timeline")
    Observable<HttpResponse<ScrapTreasureBoxConfig>> getScrapTreasureBoxList(@Path("version") String str, @Header(au.M) String str2);

    @GET("/activity/api/v1/collect/exchange/user/vip/convert")
    Observable<HttpResponse<ScrapVipInfo>> getScrapVipConvert(@Header(au.M) String str, @Query("cardId") String str2, @Query("combineAmount") int i);

    @POST("/activity/api/{version}/collect/exchange/user/combine/card")
    Observable<HttpResponse<ScrapRewardComposeInfo>> postCombineCardReward(@Path("version") String str, @Header(au.M) String str2, @Query("cardId") String str3, @Query("amount") int i);

    @GET("/activity/api/{version}/collect/exchange/scrap/receive")
    Observable<HttpResponse<Object>> receiveScrap(@Path("version") String str, @Header(au.M) String str2, @Query("friendId") long j, @Query("scrapId") String str3, @Query("uuid") String str4);

    @POST("/activity/api/{version}/collect/exchange/scrap/send")
    Observable<HttpResponse<String>> sendScrap(@Path("version") String str, @Header(au.M) String str2, @Query("friendId") long j, @Query("scrapId") String str3, @Query("sendType") int i);
}
