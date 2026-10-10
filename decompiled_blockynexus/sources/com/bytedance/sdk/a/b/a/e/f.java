package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Http2Codec.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements com.bytedance.sdk.a.b.a.c.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f5049b = com.bytedance.sdk.a.a.f.a("connection");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f5050c = com.bytedance.sdk.a.a.f.a("host");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f5051d = com.bytedance.sdk.a.a.f.a("keep-alive");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f5052e = com.bytedance.sdk.a.a.f.a("proxy-connection");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f5053f = com.bytedance.sdk.a.a.f.a("transfer-encoding");
    private static final com.bytedance.sdk.a.a.f g = com.bytedance.sdk.a.a.f.a("te");
    private static final com.bytedance.sdk.a.a.f h = com.bytedance.sdk.a.a.f.a("encoding");
    private static final com.bytedance.sdk.a.a.f i = com.bytedance.sdk.a.a.f.a("upgrade");
    private static final List<com.bytedance.sdk.a.a.f> j = com.bytedance.sdk.a.b.a.c.a(f5049b, f5050c, f5051d, f5052e, g, f5053f, h, i, c.f5027c, c.f5028d, c.f5029e, c.f5030f);
    private static final List<com.bytedance.sdk.a.a.f> k = com.bytedance.sdk.a.b.a.c.a(f5049b, f5050c, f5051d, f5052e, g, f5053f, h, i);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.bytedance.sdk.a.b.a.b.g f5054a;
    private final v l;
    private final t.a m;
    private final g n;
    private i o;

    public f(v vVar, t.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, g gVar2) {
        this.l = vVar;
        this.m = aVar;
        this.f5054a = gVar;
        this.n = gVar2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(y yVar, long j2) {
        return this.o.h();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.o.h().close();
    }

    public static List<c> b(y yVar) {
        com.bytedance.sdk.a.b.r rVarC = yVar.c();
        ArrayList arrayList = new ArrayList(rVarC.a() + 4);
        arrayList.add(new c(c.f5027c, yVar.b()));
        arrayList.add(new c(c.f5028d, com.bytedance.sdk.a.b.a.c.i.a(yVar.a())));
        String strA = yVar.a("Host");
        if (strA != null) {
            arrayList.add(new c(c.f5030f, strA));
        }
        arrayList.add(new c(c.f5029e, yVar.a().b()));
        int iA = rVarC.a();
        for (int i2 = 0; i2 < iA; i2++) {
            com.bytedance.sdk.a.a.f fVarA = com.bytedance.sdk.a.a.f.a(rVarC.a(i2).toLowerCase(Locale.US));
            if (!j.contains(fVarA)) {
                arrayList.add(new c(fVarA, rVarC.b(i2)));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a(y yVar) throws IOException {
        if (this.o != null) {
            return;
        }
        this.o = this.n.a(b(yVar), yVar.d() != null);
        this.o.e().a(this.m.c(), TimeUnit.MILLISECONDS);
        this.o.f().a(this.m.d(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: compiled from: Http2Codec.java */
    class a extends com.bytedance.sdk.a.a.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5056b;

        a(s sVar) {
            super(sVar);
            this.f5055a = false;
            this.f5056b = 0L;
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long jA = b().a(cVar, j);
                if (jA > 0) {
                    this.f5056b += jA;
                }
                return jA;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        private void a(IOException iOException) {
            if (this.f5055a) {
                return;
            }
            this.f5055a = true;
            f fVar = f.this;
            fVar.f5054a.a(false, (com.bytedance.sdk.a.b.a.c.c) fVar, this.f5056b, iOException);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.n.b();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public aa.a a(boolean z) throws IOException {
        aa.a aVarA = a(this.o.d());
        if (z && com.bytedance.sdk.a.b.a.a.f4904a.a(aVarA) == 100) {
            return null;
        }
        return aVarA;
    }

    public static aa.a a(List<c> list) throws IOException {
        r.a aVar = new r.a();
        int size = list.size();
        r.a aVar2 = aVar;
        com.bytedance.sdk.a.b.a.c.k kVarA = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = list.get(i2);
            if (cVar == null) {
                if (kVarA != null && kVarA.f4994b == 100) {
                    aVar2 = new r.a();
                    kVarA = null;
                }
            } else {
                com.bytedance.sdk.a.a.f fVar = cVar.g;
                String strA = cVar.h.a();
                if (fVar.equals(c.f5026b)) {
                    kVarA = com.bytedance.sdk.a.b.a.c.k.a("HTTP/1.1 " + strA);
                } else if (!k.contains(fVar)) {
                    com.bytedance.sdk.a.b.a.a.f4904a.a(aVar2, fVar.a(), strA);
                }
            }
        }
        if (kVarA != null) {
            return new aa.a().a(w.HTTP_2).a(kVarA.f4994b).a(kVarA.f4995c).a(aVar2.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public ab a(aa aaVar) throws IOException {
        com.bytedance.sdk.a.b.a.b.g gVar = this.f5054a;
        gVar.f4960c.f(gVar.f4959b);
        return new com.bytedance.sdk.a.b.a.c.h(aaVar.a("Content-Type"), com.bytedance.sdk.a.b.a.c.e.a(aaVar), com.bytedance.sdk.a.a.l.a(new a(this.o.g())));
    }
}
