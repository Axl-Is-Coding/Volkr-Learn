package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.greendao.entity.BuyDressResponse;
import com.sandboxol.recharge.entity.BuyRequest;
import com.umeng.analytics.pro.au;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IShopApi {
    @PUT("/shop/api/v1/shop/decorations/buy/{decorationId}")
    Observable<HttpResponse> buy(@Path("decorationId") long j, @Header(au.M) String str);

    @POST("/shop/api/v1/new/shop/decorations/buy")
    Observable<HttpResponse<BuyDressResponse>> buyByV2(@Header(au.M) String str, @Body BuyRequest buyRequest);
}
