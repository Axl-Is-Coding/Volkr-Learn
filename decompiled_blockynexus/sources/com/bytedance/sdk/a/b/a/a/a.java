package com.bytedance.sdk.a.b.a.a;

import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.a.a.c;
import com.bytedance.sdk.a.b.a.c.f;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CacheInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f4905a;

    public a(e eVar) {
        this.f4905a = eVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        e eVar = this.f4905a;
        aa aaVarA = eVar != null ? eVar.a(aVar.a()) : null;
        c cVarA = new c.a(System.currentTimeMillis(), aVar.a(), aaVarA).a();
        y yVar = cVarA.f4911a;
        aa aaVar = cVarA.f4912b;
        e eVar2 = this.f4905a;
        if (eVar2 != null) {
            eVar2.a(cVarA);
        }
        if (aaVarA != null && aaVar == null) {
            com.bytedance.sdk.a.b.a.c.a(aaVarA.g());
        }
        if (yVar == null && aaVar == null) {
            return new aa.a().a(aVar.a()).a(w.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.f4966c).a(-1L).b(System.currentTimeMillis()).a();
        }
        if (yVar == null) {
            return aaVar.h().b(a(aaVar)).a();
        }
        try {
            aa aaVarA2 = aVar.a(yVar);
            if (aaVarA2 == null && aaVarA != null) {
            }
            if (aaVar != null) {
                if (aaVarA2.c() == 304) {
                    aa aaVarA3 = aaVar.h().a(a(aaVar.f(), aaVarA2.f())).a(aaVarA2.k()).b(aaVarA2.l()).b(a(aaVar)).a(a(aaVarA2)).a();
                    aaVarA2.g().close();
                    this.f4905a.a();
                    this.f4905a.a(aaVar, aaVarA3);
                    return aaVarA3;
                }
                com.bytedance.sdk.a.b.a.c.a(aaVar.g());
            }
            aa aaVarA4 = aaVarA2.h().b(a(aaVar)).a(a(aaVarA2)).a();
            if (this.f4905a != null) {
                if (com.bytedance.sdk.a.b.a.c.e.b(aaVarA4) && c.a(aaVarA4, yVar)) {
                    return a(this.f4905a.a(aaVarA4), aaVarA4);
                }
                if (f.a(yVar.b())) {
                    try {
                        this.f4905a.b(yVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return aaVarA4;
        } finally {
            if (aaVarA != null) {
                com.bytedance.sdk.a.b.a.c.a(aaVarA.g());
            }
        }
    }

    private static aa a(aa aaVar) {
        return (aaVar == null || aaVar.g() == null) ? aaVar : aaVar.h().a((ab) null).a();
    }

    private aa a(final b bVar, aa aaVar) throws IOException {
        r rVarA;
        if (bVar == null || (rVarA = bVar.a()) == null) {
            return aaVar;
        }
        final com.bytedance.sdk.a.a.e eVarC = aaVar.g().c();
        final com.bytedance.sdk.a.a.d dVarA = l.a(rVarA);
        return aaVar.h().a(new h(aaVar.a("Content-Type"), aaVar.g().a(), l.a(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f4906a;

            @Override // com.bytedance.sdk.a.a.s
            public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
                try {
                    long jA = eVarC.a(cVar, j);
                    if (jA != -1) {
                        cVar.a(dVarA.c(), cVar.b() - jA, jA);
                        dVarA.u();
                        return jA;
                    }
                    if (!this.f4906a) {
                        this.f4906a = true;
                        dVarA.close();
                    }
                    return -1L;
                } catch (IOException e2) {
                    if (!this.f4906a) {
                        this.f4906a = true;
                        bVar.b();
                    }
                    throw e2;
                }
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.f4906a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f4906a = true;
                    bVar.b();
                }
                eVarC.close();
            }

            @Override // com.bytedance.sdk.a.a.s
            public com.bytedance.sdk.a.a.t a() {
                return eVarC.a();
            }
        }))).a();
    }

    private static com.bytedance.sdk.a.b.r a(com.bytedance.sdk.a.b.r rVar, com.bytedance.sdk.a.b.r rVar2) {
        r.a aVar = new r.a();
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = rVar.a(i);
            String strB = rVar.b(i);
            if ((!"Warning".equalsIgnoreCase(strA) || !strB.startsWith("1")) && (!a(strA) || rVar2.a(strA) == null)) {
                com.bytedance.sdk.a.b.a.a.f4904a.a(aVar, strA, strB);
            }
        }
        int iA2 = rVar2.a();
        for (int i2 = 0; i2 < iA2; i2++) {
            String strA2 = rVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(strA2) && a(strA2)) {
                com.bytedance.sdk.a.b.a.a.f4904a.a(aVar, strA2, rVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
