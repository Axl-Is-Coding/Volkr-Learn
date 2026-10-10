package com.twitter.sdk.android.core.internal.oauth;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.s;
import com.twitter.sdk.android.core.w;
import io.grpc.internal.GrpcUtil;
import java.util.TreeMap;
import okhttp3.J;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes5.dex */
public class OAuth1aService extends m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OAuthApi f20185e;

    interface OAuthApi {
        @POST("/oauth/access_token")
        Call<J> getAccessToken(@Header("Authorization") String str, @Query("oauth_verifier") String str2);

        @POST("/oauth/request_token")
        Call<J> getTempToken(@Header("Authorization") String str);
    }

    public OAuth1aService(w wVar, com.twitter.sdk.android.core.internal.m mVar) {
        super(wVar, mVar);
        this.f20185e = (OAuthApi) b().create(OAuthApi.class);
    }

    public String a(q qVar) {
        return Uri.parse("twittersdk://callback").buildUpon().appendQueryParameter("version", c().i()).appendQueryParameter("app", qVar.a()).build().toString();
    }

    public void b(com.twitter.sdk.android.core.c<l> cVar) {
        q qVarC = c().c();
        this.f20185e.getTempToken(new d().a(qVarC, null, a(qVarC), GrpcUtil.HTTP_METHOD, f(), null)).enqueue(a(cVar));
    }

    String e() {
        return a().a() + "/oauth/access_token";
    }

    String f() {
        return a().a() + "/oauth/request_token";
    }

    public void a(com.twitter.sdk.android.core.c<l> cVar, s sVar, String str) {
        this.f20185e.getAccessToken(new d().a(c().c(), sVar, null, GrpcUtil.HTTP_METHOD, e(), null), str).enqueue(a(cVar));
    }

    public String a(s sVar) {
        return a().a("oauth", "authorize").appendQueryParameter("oauth_token", sVar.f20267b).build().toString();
    }

    public static l a(String str) {
        TreeMap<String, String> treeMapA = com.twitter.sdk.android.core.internal.a.f.a(str, false);
        String str2 = treeMapA.get("oauth_token");
        String str3 = treeMapA.get("oauth_token_secret");
        String str4 = treeMapA.get(FirebaseAnalytics.Param.SCREEN_NAME);
        long j = treeMapA.containsKey("user_id") ? Long.parseLong(treeMapA.get("user_id")) : 0L;
        if (str2 == null || str3 == null) {
            return null;
        }
        return new l(new s(str2, str3), str4, j);
    }

    com.twitter.sdk.android.core.c<J> a(com.twitter.sdk.android.core.c<l> cVar) {
        return new f(this, cVar);
    }
}
