package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: CallServerInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4973a;

    /* JADX INFO: compiled from: CallServerInterceptor.java */
    static final class a extends com.bytedance.sdk.a.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f4974a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            super.a_(cVar, j);
            this.f4974a += j;
        }
    }

    public b(boolean z) {
        this.f4973a = z;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        g gVar = (g) aVar;
        c cVarG = gVar.g();
        com.bytedance.sdk.a.b.a.b.g gVarF = gVar.f();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.e();
        y yVarA = gVar.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gVar.i().c(gVar.h());
        cVarG.a(yVarA);
        gVar.i().a(gVar.h(), yVarA);
        aa.a aVarA = null;
        if (f.c(yVarA.b()) && yVarA.d() != null) {
            if ("100-continue".equalsIgnoreCase(yVarA.a("Expect"))) {
                cVarG.a();
                gVar.i().e(gVar.h());
                aVarA = cVarG.a(true);
            }
            if (aVarA == null) {
                gVar.i().d(gVar.h());
                a aVar2 = new a(cVarG.a(yVarA, yVarA.d().b()));
                com.bytedance.sdk.a.a.d dVarA = com.bytedance.sdk.a.a.l.a(aVar2);
                yVarA.d().a(dVarA);
                dVarA.close();
                gVar.i().a(gVar.h(), aVar2.f4974a);
            } else if (!cVar.d()) {
                gVarF.d();
            }
        }
        cVarG.b();
        if (aVarA == null) {
            gVar.i().e(gVar.h());
            aVarA = cVarG.a(false);
        }
        aa aaVarA = aVarA.a(yVarA).a(gVarF.b().c()).a(jCurrentTimeMillis).b(System.currentTimeMillis()).a();
        gVar.i().a(gVar.h(), aaVarA);
        int iC = aaVarA.c();
        aa aaVarA2 = (this.f4973a && iC == 101) ? aaVarA.h().a(com.bytedance.sdk.a.b.a.c.f4966c).a() : aaVarA.h().a(cVarG.a(aaVarA)).a();
        if ("close".equalsIgnoreCase(aaVarA2.a().a("Connection")) || "close".equalsIgnoreCase(aaVarA2.a("Connection"))) {
            gVarF.d();
        }
        if ((iC != 204 && iC != 205) || aaVarA2.g().a() <= 0) {
            return aaVarA2;
        }
        throw new ProtocolException("HTTP " + iC + " had non-zero Content-Length: " + aaVarA2.g().a());
    }
}
