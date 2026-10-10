package com.twitter.sdk.android.core.internal.a;

import java.io.IOException;
import okhttp3.H;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: GuestAuthNetworkInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements Interceptor {
    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        H hProceed = chain.proceed(chain.request());
        if (hProceed.g() != 403) {
            return hProceed;
        }
        H.a aVarT = hProceed.t();
        aVarT.a(401);
        aVarT.a("Unauthorized");
        return aVarT.a();
    }
}
