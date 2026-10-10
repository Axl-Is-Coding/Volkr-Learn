package com.sandboxol.decorate.web;

import com.sandboxol.center.entity.BuyRequest;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.greendao.entity.BuyDressResponse;
import com.umeng.analytics.pro.au;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IShopApi {
    @PUT("/shop/api/v1/shop/decorations/buy/{decorationId}")
    Observable<HttpResponse> buy(@Path("decorationId") long j, @Header(au.M) String str);

    @PUT("/shop/api/v1/shop/decorations/buy")
    Observable<HttpResponse<BuyDressResponse>> buy(@Query("decorationId") List<Long> list, @Header(au.M) String str);

    @POST("/shop/api/v1/new/shop/decorations/buy")
    Observable<HttpResponse<BuyDressResponse>> buyByV2(@Header(au.M) String str, @Body BuyRequest buyRequest);

    @GET("/shop/api/v1/shop/decorations/details/{decorationId}")
    Observable<HttpResponse<SingleDressInfo>> changeDecoration(@Path("decorationId") long j, @Header(au.M) String str);

    @GET("/shop/api/v1/new/shop/suit/info/{suitId}")
    Observable<HttpResponse<SuitDressInfo>> getDressSuit(@Path("suitId") long j, @Header(au.M) String str);

    @GET("/shop/api/v1/new/shop/suit/list/info")
    Observable<HttpResponse<List<SuitDressInfo>>> getSuitById(@Header(au.M) String str, @Query("suitIds") List<Long> list);

    @POST("/shop/api/v1/new/shop/gift/suit/receive")
    Observable<HttpResponse<List<SingleDressInfo>>> getSuitGift(@Header(au.M) String str, @Query("suitId") long j);

    @GET("/shop/api/v1/new/shop/gift/suit/receive")
    Observable<HttpResponse<SuitDressInfo>> getSuitGiftId(@Header(au.M) String str);

    @GET("/shop/api/v1/new/shop/user/gift/suit/receive")
    Observable<HttpResponse<Boolean>> isCanReceiveGiftSuit(@Header(au.M) String str);

    @GET("/shop/api/v1/shop/decorations/recommends/{decorationId}")
    Observable<HttpResponse<List<SingleDressInfo>>> recommendList(@Path("decorationId") long j, @Header(au.M) String str);

    @GET("/shop/api/{version}/shop/decorations/{typeId}")
    @Deprecated
    Observable<HttpResponse<List<SingleDressInfo>>> shopList(@Path("version") String str, @Path("typeId") long j, @Query("currency") int i, @Header(au.M) String str2);

    @GET("/shop/api/v1/new/shop/decorations/{typeId}")
    Observable<HttpResponse<List<SingleDressInfo>>> shopListByV2(@Header(au.M) String str, @Path("typeId") long j, @Query(au.w) String str2, @Query("engineVersion") int i);

    @GET("/shop/api/v1/new/shop/recommend/decorations")
    Observable<HttpResponse<List<ShopRecommendDecorationInfo>>> shopRecommendByV2(@Header(au.M) String str, @Query(au.w) String str2, @Query("engineVersion") int i);

    @GET("/shop/api/v1/new/shop/suit/decorations")
    Observable<HttpResponse<List<SuitDressInfo>>> shopSuitByV2(@Header(au.M) String str, @Query(au.w) String str2, @Query("engineVersion") int i);
}
