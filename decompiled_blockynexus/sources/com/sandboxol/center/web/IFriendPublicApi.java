package com.sandboxol.center.web;

import com.sandboxol.common.base.web.HttpResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IFriendPublicApi {
    @GET("/friend/api/v1/friend/status/{friendId}")
    Observable<HttpResponse<Integer>> getFriendStatus(@Path("friendId") long j);
}
