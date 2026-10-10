package com.sandboxol.imchat.web;

import com.sandboxol.common.base.web.HttpResponse;
import com.umeng.analytics.pro.au;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes4.dex */
public interface IPartyApi {
    @GET("/api/v1/parties/exists")
    Observable<HttpResponse<String>> isPartyExist(@Header(au.M) String str, @Query("partyId") String str2);
}
