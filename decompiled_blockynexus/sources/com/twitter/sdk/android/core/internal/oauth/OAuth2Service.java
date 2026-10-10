package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.w;
import okio.ByteString;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes5.dex */
public class OAuth2Service extends m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OAuth2Api f20186e;

    interface OAuth2Api {
        @FormUrlEncoded
        @Headers({"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @POST("/oauth2/token")
        Call<j> getAppAuthToken(@Header("Authorization") String str, @Field("grant_type") String str2);

        @POST("/1.1/guest/activate.json")
        Call<c> getGuestToken(@Header("Authorization") String str);
    }

    public OAuth2Service(w wVar, com.twitter.sdk.android.core.internal.m mVar) {
        super(wVar, mVar);
        this.f20186e = (OAuth2Api) b().create(OAuth2Api.class);
    }

    private String e() {
        q qVarC = c().c();
        return "Basic " + ByteString.encodeUtf8(com.twitter.sdk.android.core.internal.a.f.a(qVarC.a()) + ":" + com.twitter.sdk.android.core.internal.a.f.a(qVarC.b())).base64();
    }

    void a(com.twitter.sdk.android.core.c<j> cVar) {
        this.f20186e.getAppAuthToken(e(), "client_credentials").enqueue(cVar);
    }

    public void b(com.twitter.sdk.android.core.c<b> cVar) {
        a(new h(this, cVar));
    }

    void a(com.twitter.sdk.android.core.c<c> cVar, j jVar) {
        this.f20186e.getGuestToken(a(jVar)).enqueue(cVar);
    }

    private String a(j jVar) {
        return "Bearer " + jVar.a();
    }
}
