package com.twitter.sdk.android.core.internal.a;

import com.twitter.sdk.android.core.l;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.s;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.C;
import okhttp3.G;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.v;

/* JADX INFO: compiled from: OAuth1aInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final l<? extends s> f20153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final q f20154b;

    public d(l<? extends s> lVar, q qVar) {
        this.f20153a = lVar;
        this.f20154b = qVar;
    }

    v a(v vVar) {
        v.a aVarI = vVar.i();
        aVarI.d(null);
        int iM = vVar.m();
        for (int i = 0; i < iM; i++) {
            aVarI.a(f.a(vVar.a(i)), f.a(vVar.b(i)));
        }
        return aVarI.a();
    }

    Map<String, String> b(C c2) throws IOException {
        HashMap map = new HashMap();
        if (GrpcUtil.HTTP_METHOD.equals(c2.e().toUpperCase(Locale.US))) {
            G gA = c2.a();
            if (gA instanceof okhttp3.s) {
                okhttp3.s sVar = (okhttp3.s) gA;
                for (int i = 0; i < sVar.a(); i++) {
                    map.put(sVar.a(i), sVar.c(i));
                }
            }
        }
        return map;
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        C cRequest = chain.request();
        C.a aVarF = cRequest.f();
        aVarF.a(a(cRequest.g()));
        C cA = aVarF.a();
        C.a aVarF2 = cA.f();
        aVarF2.b("Authorization", a(cA));
        return chain.proceed(aVarF2.a());
    }

    String a(C c2) throws IOException {
        return new com.twitter.sdk.android.core.internal.oauth.d().a(this.f20154b, (s) this.f20153a.a(), null, c2.e(), c2.g().toString(), b(c2));
    }
}
