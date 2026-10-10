package com.twitter.sdk.android.core.internal.oauth;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.twitter.sdk.android.core.w;
import java.io.IOException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.z;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: OAuthService.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f20207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.twitter.sdk.android.core.internal.m f20208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Retrofit f20210d;

    m(w wVar, com.twitter.sdk.android.core.internal.m mVar) {
        this.f20207a = wVar;
        this.f20208b = mVar;
        this.f20209c = com.twitter.sdk.android.core.internal.m.a("TwitterAndroidSDK", wVar.i());
        z.a aVar = new z.a();
        aVar.a(new Interceptor() { // from class: com.twitter.sdk.android.core.internal.oauth.a
            @Override // okhttp3.Interceptor
            public final H intercept(Interceptor.Chain chain) {
                return this.f20187a.a(chain);
            }
        });
        aVar.a(com.twitter.sdk.android.core.internal.a.e.a());
        this.f20210d = new Retrofit.Builder().baseUrl(a().a()).client(aVar.a()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public /* synthetic */ H a(Interceptor.Chain chain) throws IOException {
        C.a aVarF = chain.request().f();
        aVarF.b(AbstractSpiCall.HEADER_USER_AGENT, d());
        return chain.proceed(aVarF.a());
    }

    protected Retrofit b() {
        return this.f20210d;
    }

    protected w c() {
        return this.f20207a;
    }

    protected String d() {
        return this.f20209c;
    }

    protected com.twitter.sdk.android.core.internal.m a() {
        return this.f20208b;
    }
}
