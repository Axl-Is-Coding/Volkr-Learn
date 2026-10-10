package com.twitter.sdk.android.core.internal.a;

import com.twitter.sdk.android.core.g;
import java.io.IOException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: GuestAuthInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g f20151a;

    public a(g gVar) {
        this.f20151a = gVar;
    }

    static void a(C.a aVar, com.twitter.sdk.android.core.internal.oauth.b bVar) {
        aVar.b("Authorization", bVar.b() + " " + bVar.a());
        aVar.b("x-guest-token", bVar.c());
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        C cRequest = chain.request();
        com.twitter.sdk.android.core.e eVarA = this.f20151a.a();
        com.twitter.sdk.android.core.internal.oauth.b bVarA = eVarA == null ? null : eVarA.a();
        if (bVarA == null) {
            return chain.proceed(cRequest);
        }
        C.a aVarF = cRequest.f();
        a(aVarF, bVarA);
        return chain.proceed(aVarF.a());
    }
}
