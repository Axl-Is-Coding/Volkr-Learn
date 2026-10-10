package com.sandboxol.decorate.web;

import com.sandboxol.center.entity.DecorationResourcesResponse;
import com.sandboxol.center.entity.ResCheckEntity;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.decorate.entity.DressExpireInfo;
import com.sandboxol.decorate.entity.DressGuideInfo;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.umeng.analytics.pro.au;
import java.util.List;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IDecorationApi {
    @GET("/decoration/api/v1/new/decorations/check/resource")
    Observable<HttpResponse<DecorationResourcesResponse>> checkDressResource(@Query("resVersion") long j, @Query("engineVersion") long j2, @Header(au.M) String str);

    @GET("/decoration/api/{version}/decorations/{typeId}")
    Observable<HttpResponse<List<SingleDressInfo>>> dressList(@Path("version") String str, @Path("typeId") long j, @Header(au.M) String str2);

    @GET("/decoration/api/v1/decorations/{otherId}/using")
    Observable<HttpResponse<List<SingleDressInfo>>> friendUsingList(@Header(au.M) String str, @Path("otherId") long j);

    @GET("/decoration/api/v1/new/decorations/users/{userId}/expire")
    Observable<HttpResponse<List<DressExpireInfo>>> getDressInfoExpireList(@Path("userId") long j, @Header(au.M) String str);

    @GET("/decoration/api/v1/new/decorations/users/{userId}/type/{typeId}")
    Observable<HttpResponse<List<SingleDressInfo>>> getDressListByType(@Header(au.M) String str, @Path("userId") long j, @Path("typeId") long j2, @Query(au.w) String str2, @Query("engineVersion") int i);

    @GET("/decoration/api/v1/new/decorations/users/{userId}/suit")
    Observable<HttpResponse<List<SuitDressInfo>>> getDressSuitList(@Path("userId") long j, @Query(au.w) String str, @Query("engineVersion") int i, @Header(au.M) String str2);

    @GET("/decoration/api/v1/new/decorations/recommend/users/{userId}/type/{typeId}")
    Observable<HttpResponse<List<ShopRecommendDecorationInfo>>> getRecommendList(@Header(au.M) String str, @Path("userId") long j, @Path("typeId") long j2, @Header(au.w) String str2, @Header("userId") long j3, @Query("isSuit") boolean z, @Header("Access-Token") String str3);

    @GET("/decoration/api/v1/decorations/using")
    Observable<HttpResponse<List<SingleDressInfo>>> isUsingList(@Header(au.M) String str, @Query("otherId") long j);

    @GET("/config/files/dress-guide-config")
    Observable<HttpResponse<DressGuideInfo>> loadDressGuideConfig();

    @PUT("/decoration/api/v1/decorations/using/new")
    Observable<HttpResponse<List<SingleDressInfo>>> multiClothe(@Header(au.M) String str, @Query("ids") List<Long> list, @Header(au.w) String str2);

    @DELETE("/decoration/api/v1/decorations/using/new")
    Observable<HttpResponse<Object>> multiUnclothe(@Query("ids") List<Long> list);

    @DELETE("/decoration/api/v1/decorations/using/{decorationId}")
    Observable<HttpResponse<SingleDressInfo>> removeDecoration(@Path("decorationId") long j);

    @DELETE("/decoration/api/v1/decorations/using")
    Observable<HttpResponse<List<SingleDressInfo>>> removeSuitDecoration(@Header(au.M) String str, @Query("ids") List<Long> list);

    @GET("/decoration/api/v1/decoration/versions")
    Observable<HttpResponse<ResCheckEntity>> resCheck(@Query("version") int i);

    @PUT("/decoration/api/v1/decorations/using/{decorationId}")
    Observable<HttpResponse<SingleDressInfo>> useDecoration(@Path("decorationId") long j, @Header(au.M) String str);

    @PUT("/decoration/api/v1/decorations/using")
    Observable<HttpResponse<List<SingleDressInfo>>> useSuitDecoration(@Header(au.M) String str, @Query("ids") List<Long> list);

    @GET("/decoration/api/v1/vip/decorations/users/{typeId}")
    @Deprecated
    Observable<HttpResponse<List<SingleDressInfo>>> vipDress(@Path("typeId") long j, @Header(au.M) String str);
}
