package com.sandboxol.googlepay.billing;

import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.FirstTopUp;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.center.router.moduleInfo.pay.PaySignatureInfo;
import com.sandboxol.center.router.moduleInfo.pay.ThirdPayResponse;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.umeng.analytics.pro.au;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IPayApi {
    @POST("/pay/api/v4/pay/users/recharge")
    Observable<HttpResponse<BuyVipEntity>> buySubs(@Body BuyParam buyParam, @Query("type") String str, @Header("videoStarUserId") long j, @Header("videoStarCode") String str2);

    @POST("/pay/api/v3/pay/users/recharge")
    Observable<HttpResponse<BuyVipEntity>> buyVip(@Body BuyParam buyParam, @Query("type") String str, @Header("videoStarUserId") long j, @Header("videoStarCode") String str2);

    @POST("/pay/api/v4/pay/users/recharge")
    Observable<HttpResponse<BuyVipEntity>> buyVipExtend(@Body BuyParam buyParam, @Query("type") String str, @Header("videoStarUserId") long j, @Header("videoStarCode") String str2);

    @GET("/pay/api/v1/first/punch/reward")
    Observable<HttpResponse<FirstTopUp>> firstTopReward(@Header(au.M) String str);

    @GET("/pay/api/v1/pay/payssion/signature")
    Observable<HttpResponse<PaySignatureInfo>> getPaySignature(@Header(au.M) String str, @Header("CloudFront-Viewer-Country") String str2);

    @GET("/pay/api/v1/pay/payssion/flag")
    Observable<HttpResponse<Boolean>> isShowThirdPart(@Header(au.M) String str, @Header("CloudFront-Viewer-Country") String str2);

    @GET("/pay/api/v1/pay/third/part")
    Observable<HttpResponse<Boolean>> isShowThirdPartPay();

    @GET("/pay/api/v1/pay/products")
    Observable<HttpResponse<List<ProductEntity>>> productsList(@Query("type") String str, @Header("appType") String str2);

    @POST("/pay/api/v2/pay/users/recharge")
    Observable<HttpResponse<RechargeEntity>> recharge(@Body BuyParam buyParam, @Query("type") String str, @Header(au.M) String str2);

    @POST("/pay/api/v2/pay/users/recharge")
    Observable<HttpResponse<RechargeEntity>> recharge(@Body BuyParam buyParam, @Query("type") String str, @Header(au.M) String str2, @Header("videoStarUserId") long j, @Header("videoStarCode") String str3);

    @POST("/pay/api/v1/pay/users/recharge")
    Observable<HttpResponse> rechargeGift(@Body BuyParam buyParam, @Query("type") String str);

    @GET("/pay/api/v1/wealth/record/users/{userId}")
    Observable<HttpResponse<PageData<PayRecordInfo>>> rechargeHistory(@Path("userId") long j, @Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/pay/api/v2/pay/third/part")
    Observable<HttpResponse<ThirdPayResponse>> showThirdPartPayList(@Header("CloudFront-Viewer-Country") String str, @Query("productId") String str2);

    @GET("/pay/api/v1/wealth/user")
    Observable<HttpResponse<RechargeEntity>> updateMoney();

    @GET("/pay/api/v1/pay/products/vip")
    Observable<HttpResponse<VipProductResponse>> vipProductsList();

    @GET("/pay/api/v2/pay/products/vip")
    Observable<HttpResponse<VipProductResponse>> vipSubsProductsList(@Query("platform") String str);
}
