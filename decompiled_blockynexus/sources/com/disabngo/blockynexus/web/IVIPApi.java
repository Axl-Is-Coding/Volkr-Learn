package com.disabngo.blockynexus.web;

import com.sandboxol.center.entity.BuyVipResponse;
import com.sandboxol.center.entity.VipInfo;
import com.sandboxol.common.base.web.HttpResponse;
import com.umeng.analytics.pro.au;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IVIPApi {
    @PUT("/shop/api/v1/shop/user/buy/vip")
    Observable<HttpResponse<BuyVipResponse>> buyVip(@Query("productId") String str, @Header(au.M) String str2, @Header("userId") long j, @Header("Access-Token") String str3);

    @GET("/shop/api/v1/shop/users/vip")
    Observable<HttpResponse<Map<String, List<VipInfo>>>> vipPriceList(@Header("userId") long j, @Header("Access-Token") String str);
}
