package com.twitter.sdk.android.core.internal.a;

import com.twitter.sdk.android.core.g;
import com.twitter.sdk.android.core.l;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.s;
import okhttp3.C2943h;
import okhttp3.z;

/* JADX INFO: compiled from: OkHttpClientHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {
    public static z a(g gVar) {
        z.a aVar = new z.a();
        a(aVar, gVar);
        return aVar.a();
    }

    public static z a(l<? extends s> lVar, q qVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("Session must not be null.");
        }
        z.a aVar = new z.a();
        a(aVar, lVar, qVar);
        return aVar.a();
    }

    static z.a a(z.a aVar, g gVar) {
        aVar.a(a());
        aVar.a(new c(gVar));
        aVar.a(new a(gVar));
        aVar.b(new b());
        return aVar;
    }

    static z.a a(z.a aVar, l<? extends s> lVar, q qVar) {
        aVar.a(a());
        aVar.a(new d(lVar, qVar));
        return aVar;
    }

    public static C2943h a() {
        C2943h.a aVar = new C2943h.a();
        aVar.a("*.twitter.com", "sha1/I0PRSKJViZuUfUYaeX7ATP7RcLc=");
        aVar.a("*.twitter.com", "sha1/VRmyeKyygdftp6vBg5nDu2kEJLU=");
        aVar.a("*.twitter.com", "sha1/Eje6RRfurSkm/cHN/r7t8t7ZFFw=");
        aVar.a("*.twitter.com", "sha1/Wr7Fddyu87COJxlD/H8lDD32YeM=");
        aVar.a("*.twitter.com", "sha1/GiG0lStik84Ys2XsnA6TTLOB5tQ=");
        aVar.a("*.twitter.com", "sha1/IvGeLsbqzPxdI0b0wuj2xVTdXgc=");
        aVar.a("*.twitter.com", "sha1/7WYxNdMb1OymFMQp4xkGn5TBJlA=");
        aVar.a("*.twitter.com", "sha1/sYEIGhmkwJQf+uiVKMEkyZs0rMc=");
        aVar.a("*.twitter.com", "sha1/PANDaGiVHPNpKri0Jtq6j+ki5b0=");
        aVar.a("*.twitter.com", "sha1/u8I+KQuzKHcdrT6iTb30I70GsD0=");
        aVar.a("*.twitter.com", "sha1/wHqYaI2J+6sFZAwRfap9ZbjKzE4=");
        aVar.a("*.twitter.com", "sha1/cTg28gIxU0crbrplRqkQFVggBQk=");
        aVar.a("*.twitter.com", "sha1/sBmJ5+/7Sq/LFI9YRjl2IkFQ4bo=");
        aVar.a("*.twitter.com", "sha1/vb6nG6txV/nkddlU0rcngBqCJoI=");
        aVar.a("*.twitter.com", "sha1/nKmNAK90Dd2BgNITRaWLjy6UONY=");
        aVar.a("*.twitter.com", "sha1/h+hbY1PGI6MSjLD/u/VR/lmADiI=");
        aVar.a("*.twitter.com", "sha1/Xk9ThoXdT57KX9wNRW99UbHcm3s=");
        aVar.a("*.twitter.com", "sha1/1S4TwavjSdrotJWU73w4Q2BkZr0=");
        aVar.a("*.twitter.com", "sha1/gzF+YoVCU9bXeDGQ7JGQVumRueM=");
        aVar.a("*.twitter.com", "sha1/aDMOYTWFIVkpg6PI0tLhQG56s8E=");
        aVar.a("*.twitter.com", "sha1/Vv7zwhR9TtOIN/29MFI4cgHld40=");
        return aVar.a();
    }
}
