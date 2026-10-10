package com.disabngo.blockynexus.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.VideoDetailInfo;
import com.sandboxol.greendao.entity.VideoInfo;
import com.umeng.analytics.pro.au;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IVideoApi {
    @GET("/video/api/v1/app/video/more/list")
    Observable<HttpResponse<PageData<VideoInfo>>> getMoreVideoByAuthor(@Header(au.M) String str, @Query("pageNo") int i, @Query("pageSize") int i2, @Query("authorId") long j, @Query("videoId") long j2);

    @GET("/video/api/v1/app/video/more/list")
    Observable<HttpResponse<PageData<VideoInfo>>> getMoreVideoByAuthor(@Header(au.M) String str, @Query("pageNo") int i, @Query("pageSize") int i2, @Query("tag") List<String> list, @Query("authorId") long j, @Query("videoId") long j2);

    @GET("/video/api/v1/app/video/list/{type}")
    Observable<HttpResponse<PageData<VideoInfo>>> getVideoByTag(@Header(au.M) String str, @Path("type") String str2, @Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/video/api/v1/app/video/list/{type}")
    Observable<HttpResponse<PageData<VideoInfo>>> getVideoByTag(@Header(au.M) String str, @Path("type") String str2, @Query("pageNo") int i, @Query("pageSize") int i2, @Query("tag") List<String> list);

    @GET("/video/api/v1/app/video/detail/info")
    Observable<HttpResponse<VideoDetailInfo>> getVideoDetailInfo(@Header(au.M) String str, @Query("videoId") long j);

    @GET("/video/api/v1/app/video/tag/list")
    Observable<HttpResponse<Map<String, String>>> getVideoTagList(@Header(au.M) String str);

    @POST("/video/api/v1/app/video/dislike/{videoId}")
    Observable<HttpResponse<Integer>> postDisLike(@Header(au.M) String str, @Path("videoId") long j);

    @POST("/video/api/v1/app/video/report/play/amount")
    Observable<HttpResponse<Integer>> postPlayAmount(@Header(au.M) String str, @Query("videoId") long j);

    @POST("/video/api/v1/app/video/praise/{videoId}")
    Observable<HttpResponse<Integer>> postPraise(@Header(au.M) String str, @Path("videoId") long j);
}
