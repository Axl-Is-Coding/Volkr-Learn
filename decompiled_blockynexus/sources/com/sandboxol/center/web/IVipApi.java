package com.sandboxol.center.web;

import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.common.base.web.HttpResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IVipApi {
    @GET("/pay/api/v1/sub/info/get")
    Observable<HttpResponse<VipSubInfo>> getSubscribeInfo(@Query("appType") String str);
}
