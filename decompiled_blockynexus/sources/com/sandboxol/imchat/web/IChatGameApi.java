package com.sandboxol.imchat.web;

import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.common.base.web.HttpResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes4.dex */
public interface IChatGameApi {
    @GET("/game/api/v2/party/auth")
    Observable<HttpResponse<PartyAuthInfo>> getPartyAuth(@Query("userId") long j, @Query("psid") String str, @Query("isNewEngine") boolean z);
}
