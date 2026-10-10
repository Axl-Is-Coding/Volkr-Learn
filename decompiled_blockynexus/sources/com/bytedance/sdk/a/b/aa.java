package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.r;
import java.io.Closeable;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public final class aa implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final y f5197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final w f5198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f5199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f5200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final q f5201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final r f5202f;
    final ab g;
    final aa h;
    final aa i;
    final aa j;
    final long k;
    final long l;
    private volatile d m;

    /* JADX INFO: compiled from: Response.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        y f5203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        w f5204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f5206d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        q f5207e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        r.a f5208f;
        ab g;
        aa h;
        aa i;
        aa j;
        long k;
        long l;

        public a() {
            this.f5205c = -1;
            this.f5208f = new r.a();
        }

        private void d(aa aaVar) {
            if (aaVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(y yVar) {
            this.f5203a = yVar;
            return this;
        }

        public a b(aa aaVar) {
            if (aaVar != null) {
                a("cacheResponse", aaVar);
            }
            this.i = aaVar;
            return this;
        }

        public a c(aa aaVar) {
            if (aaVar != null) {
                d(aaVar);
            }
            this.j = aaVar;
            return this;
        }

        public a a(w wVar) {
            this.f5204b = wVar;
            return this;
        }

        public a a(int i) {
            this.f5205c = i;
            return this;
        }

        public a b(long j) {
            this.l = j;
            return this;
        }

        a(aa aaVar) {
            this.f5205c = -1;
            this.f5203a = aaVar.f5197a;
            this.f5204b = aaVar.f5198b;
            this.f5205c = aaVar.f5199c;
            this.f5206d = aaVar.f5200d;
            this.f5207e = aaVar.f5201e;
            this.f5208f = aaVar.f5202f.b();
            this.g = aaVar.g;
            this.h = aaVar.h;
            this.i = aaVar.i;
            this.j = aaVar.j;
            this.k = aaVar.k;
            this.l = aaVar.l;
        }

        public a a(String str) {
            this.f5206d = str;
            return this;
        }

        public a a(q qVar) {
            this.f5207e = qVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f5208f.a(str, str2);
            return this;
        }

        public a a(r rVar) {
            this.f5208f = rVar.b();
            return this;
        }

        public a a(ab abVar) {
            this.g = abVar;
            return this;
        }

        public a a(aa aaVar) {
            if (aaVar != null) {
                a("networkResponse", aaVar);
            }
            this.h = aaVar;
            return this;
        }

        private void a(String str, aa aaVar) {
            if (aaVar.g == null) {
                if (aaVar.h == null) {
                    if (aaVar.i == null) {
                        if (aaVar.j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a a(long j) {
            this.k = j;
            return this;
        }

        public aa a() {
            if (this.f5203a != null) {
                if (this.f5204b != null) {
                    if (this.f5205c >= 0) {
                        if (this.f5206d != null) {
                            return new aa(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f5205c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    aa(a aVar) {
        this.f5197a = aVar.f5203a;
        this.f5198b = aVar.f5204b;
        this.f5199c = aVar.f5205c;
        this.f5200d = aVar.f5206d;
        this.f5201e = aVar.f5207e;
        this.f5202f = aVar.f5208f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public y a() {
        return this.f5197a;
    }

    public w b() {
        return this.f5198b;
    }

    public int c() {
        return this.f5199c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ab abVar = this.g;
        if (abVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        abVar.close();
    }

    public String d() {
        return this.f5200d;
    }

    public q e() {
        return this.f5201e;
    }

    public r f() {
        return this.f5202f;
    }

    public ab g() {
        return this.g;
    }

    public a h() {
        return new a(this);
    }

    public aa i() {
        return this.j;
    }

    public d j() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.f5202f);
        this.m = dVarA;
        return dVarA;
    }

    public long k() {
        return this.k;
    }

    public long l() {
        return this.l;
    }

    public String toString() {
        return "Response{protocol=" + this.f5198b + ", code=" + this.f5199c + ", message=" + this.f5200d + ", url=" + this.f5197a.a() + '}';
    }

    public String a(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        String strA = this.f5202f.a(str);
        return strA != null ? strA : str2;
    }
}
