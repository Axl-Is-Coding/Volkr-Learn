package com.sandboxol.gamedetail.web;

import com.sandboxol.center.entity.BuyGameResponse;
import com.sandboxol.common.base.web.HttpResponse;
import com.umeng.analytics.pro.au;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IGameDetailsApi {
    @PUT("/shop/api/v2/pay/game/{gameId}")
    Observable<HttpResponse<BuyGameResponse>> bugGame(@Path("gameId") String str, @Header(au.M) String str2);

    @PUT("/shop/api/v3/shop/game/props/new")
    Observable<HttpResponse> buyGameDetailShopGoods(@Header(au.M) String str, @Query("gameId") String str2, @Query("propsId") long j);
}
