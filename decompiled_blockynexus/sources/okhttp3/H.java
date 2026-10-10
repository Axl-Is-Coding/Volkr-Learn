package okhttp3;

import java.io.Closeable;
import okhttp3.u;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes5.dex */
public final class H implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C f23033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Protocol f23034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f23035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f23036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final t f23037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final u f23038f;
    final J g;
    final H h;
    final H i;
    final H j;
    final long k;
    final long l;
    private volatile C2942g m;

    /* JADX INFO: compiled from: Response.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        C f23039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Protocol f23040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f23042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        t f23043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        u.a f23044f;
        J g;
        H h;
        H i;
        H j;
        long k;
        long l;

        public a() {
            this.f23041c = -1;
            this.f23044f = new u.a();
        }

        private void d(H h) {
            if (h.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(C c2) {
            this.f23039a = c2;
            return this;
        }

        public a b(String str, String str2) {
            this.f23044f.c(str, str2);
            return this;
        }

        public a c(H h) {
            if (h != null) {
                d(h);
            }
            this.j = h;
            return this;
        }

        public a a(Protocol protocol) {
            this.f23040b = protocol;
            return this;
        }

        public a b(String str) {
            this.f23044f.c(str);
            return this;
        }

        public a a(int i) {
            this.f23041c = i;
            return this;
        }

        public a b(H h) {
            if (h != null) {
                a("networkResponse", h);
            }
            this.h = h;
            return this;
        }

        a(H h) {
            this.f23041c = -1;
            this.f23039a = h.f23033a;
            this.f23040b = h.f23034b;
            this.f23041c = h.f23035c;
            this.f23042d = h.f23036d;
            this.f23043e = h.f23037e;
            this.f23044f = h.f23038f.a();
            this.g = h.g;
            this.h = h.h;
            this.i = h.i;
            this.j = h.j;
            this.k = h.k;
            this.l = h.l;
        }

        public a a(String str) {
            this.f23042d = str;
            return this;
        }

        public a a(t tVar) {
            this.f23043e = tVar;
            return this;
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a a(String str, String str2) {
            this.f23044f.a(str, str2);
            return this;
        }

        public a a(u uVar) {
            this.f23044f = uVar.a();
            return this;
        }

        public a a(J j) {
            this.g = j;
            return this;
        }

        public a a(H h) {
            if (h != null) {
                a("cacheResponse", h);
            }
            this.i = h;
            return this;
        }

        private void a(String str, H h) {
            if (h.g == null) {
                if (h.h == null) {
                    if (h.i == null) {
                        if (h.j == null) {
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
            this.l = j;
            return this;
        }

        public H a() {
            if (this.f23039a != null) {
                if (this.f23040b != null) {
                    if (this.f23041c >= 0) {
                        if (this.f23042d != null) {
                            return new H(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f23041c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    H(a aVar) {
        this.f23033a = aVar.f23039a;
        this.f23034b = aVar.f23040b;
        this.f23035c = aVar.f23041c;
        this.f23036d = aVar.f23042d;
        this.f23037e = aVar.f23043e;
        this.f23038f = aVar.f23044f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public String a(String str) {
        return a(str, null);
    }

    public J b() {
        return this.g;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        J j = this.g;
        if (j == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        j.close();
    }

    public C2942g d() {
        C2942g c2942g = this.m;
        if (c2942g != null) {
            return c2942g;
        }
        C2942g c2942gA = C2942g.a(this.f23038f);
        this.m = c2942gA;
        return c2942gA;
    }

    public int g() {
        return this.f23035c;
    }

    public t n() {
        return this.f23037e;
    }

    public u o() {
        return this.f23038f;
    }

    public boolean q() {
        int i = this.f23035c;
        return i >= 200 && i < 300;
    }

    public String r() {
        return this.f23036d;
    }

    public H s() {
        return this.h;
    }

    public a t() {
        return new a(this);
    }

    public String toString() {
        return "Response{protocol=" + this.f23034b + ", code=" + this.f23035c + ", message=" + this.f23036d + ", url=" + this.f23033a.g() + '}';
    }

    public H v() {
        return this.j;
    }

    public Protocol w() {
        return this.f23034b;
    }

    public long x() {
        return this.l;
    }

    public C y() {
        return this.f23033a;
    }

    public long z() {
        return this.k;
    }

    public String a(String str, String str2) {
        String strB = this.f23038f.b(str);
        return strB != null ? strB : str2;
    }
}
