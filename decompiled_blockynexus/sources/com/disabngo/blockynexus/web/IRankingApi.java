package com.disabngo.blockynexus.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankHomePageInfoResponse;
import com.sandboxol.greendao.entity.RankInfoResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IRankingApi {
    @GET("/ranking/api/v1/active/global/overall/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getActiveGlobalOverallRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/active/global/weekly/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getActiveGlobalWeeklyRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/active/region/overall/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getActiveRegionOverallRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/active/region/weekly/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getActiveRegionWeeklyRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/clan/global/overall/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getClanGlobalOverallRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/clan/global/weekly/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getClanGlobalWeeklyRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/clan/region/overall/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getClanRegionOverallRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/clan/region/weekly/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getClanRegionWeeklyRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/gold/diamond/global/overall/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getGDiamondGlobalOverallRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/gold/diamond/global/weekly/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getGDiamondGlobalWeeklyRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/gold/diamond/region/overall/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getGDiamondRegionOverallRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/gold/diamond/region/weekly/rank")
    Observable<HttpResponse<PageData<RankInfoResponse>>> getGDiamondRegionWeeklyRanks(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/ranking/api/v1/ranking/region/home/page/info")
    Observable<HttpResponse<RankHomePageInfoResponse>> getRegionRankHomePageInfoResponse(@Query("rankType") String str);

    @GET("/ranking/api/v1/ranking/user/info")
    Observable<HttpResponse<RankInfoResponse>> getUserRankInfoResponse(@Query("rankType") String str, @Query("type") String str2, @Query("isRegion") boolean z);
}
