package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.J;
import okhttp3.Protocol;
import okhttp3.internal.cache.c;
import okhttp3.u;
import okio.Okio;
import okio.Sink;

/* JADX INFO: compiled from: CacheInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InternalCache f23171a;

    public b(InternalCache internalCache) {
        this.f23171a = internalCache;
    }

    private static H a(H h) {
        if (h == null || h.b() == null) {
            return h;
        }
        H.a aVarT = h.t();
        aVarT.a((J) null);
        return aVarT.a();
    }

    static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f23171a;
        H h = internalCache != null ? internalCache.get(chain.request()) : null;
        c cVarA = new c.a(System.currentTimeMillis(), chain.request(), h).a();
        C c2 = cVarA.f23172a;
        H h2 = cVarA.f23173b;
        InternalCache internalCache2 = this.f23171a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cVarA);
        }
        if (h != null && h2 == null) {
            okhttp3.a.e.a(h.b());
        }
        if (c2 == null && h2 == null) {
            H.a aVar = new H.a();
            aVar.a(chain.request());
            aVar.a(Protocol.HTTP_1_1);
            aVar.a(504);
            aVar.a("Unsatisfiable Request (only-if-cached)");
            aVar.a(okhttp3.a.e.f23115c);
            aVar.b(-1L);
            aVar.a(System.currentTimeMillis());
            return aVar.a();
        }
        if (c2 == null) {
            H.a aVarT = h2.t();
            aVarT.a(a(h2));
            return aVarT.a();
        }
        try {
            H hProceed = chain.proceed(c2);
            if (hProceed == null && h != null) {
            }
            if (h2 != null) {
                if (hProceed.g() == 304) {
                    H.a aVarT2 = h2.t();
                    aVarT2.a(a(h2.o(), hProceed.o()));
                    aVarT2.b(hProceed.z());
                    aVarT2.a(hProceed.x());
                    aVarT2.a(a(h2));
                    aVarT2.b(a(hProceed));
                    H hA = aVarT2.a();
                    hProceed.b().close();
                    this.f23171a.trackConditionalCacheHit();
                    this.f23171a.update(h2, hA);
                    return hA;
                }
                okhttp3.a.e.a(h2.b());
            }
            H.a aVarT3 = hProceed.t();
            aVarT3.a(a(h2));
            aVarT3.b(a(hProceed));
            H hA2 = aVarT3.a();
            if (this.f23171a != null) {
                if (okhttp3.internal.http.e.b(hA2) && c.a(hA2, c2)) {
                    return a(this.f23171a.put(hA2), hA2);
                }
                if (okhttp3.internal.http.f.a(c2.e())) {
                    try {
                        this.f23171a.remove(c2);
                    } catch (IOException unused) {
                    }
                }
            }
            return hA2;
        } finally {
            if (h != null) {
                okhttp3.a.e.a(h.b());
            }
        }
    }

    private H a(CacheRequest cacheRequest, H h) throws IOException {
        Sink sinkBody;
        if (cacheRequest == null || (sinkBody = cacheRequest.body()) == null) {
            return h;
        }
        a aVar = new a(this, h.b().source(), cacheRequest, Okio.buffer(sinkBody));
        String strA = h.a("Content-Type");
        long jContentLength = h.b().contentLength();
        H.a aVarT = h.t();
        aVarT.a(new okhttp3.internal.http.h(strA, jContentLength, Okio.buffer(aVar)));
        return aVarT.a();
    }

    private static u a(u uVar, u uVar2) {
        u.a aVar = new u.a();
        int iB = uVar.b();
        for (int i = 0; i < iB; i++) {
            String strA = uVar.a(i);
            String strB = uVar.b(i);
            if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (a(strA) || !b(strA) || uVar2.b(strA) == null)) {
                okhttp3.a.a.f23061a.a(aVar, strA, strB);
            }
        }
        int iB2 = uVar2.b();
        for (int i2 = 0; i2 < iB2; i2++) {
            String strA2 = uVar2.a(i2);
            if (!a(strA2) && b(strA2)) {
                okhttp3.a.a.f23061a.a(aVar, strA2, uVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
