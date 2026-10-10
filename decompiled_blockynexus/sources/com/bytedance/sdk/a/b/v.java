package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: OkHttpClient.java */
/* JADX INFO: loaded from: classes.dex */
public class v implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final List<w> f5313a = com.bytedance.sdk.a.b.a.c.a(w.HTTP_2, w.HTTP_1_1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final List<k> f5314b = com.bytedance.sdk.a.b.a.c.a(k.f5257a, k.f5259c);
    final int A;
    final int B;
    final int C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final n f5315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Proxy f5316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<w> f5317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<k> f5318f;
    final List<t> g;
    final List<t> h;
    final p.a i;
    final ProxySelector j;
    final m k;
    final c l;
    final com.bytedance.sdk.a.b.a.a.e m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final com.bytedance.sdk.a.b.a.i.c p;
    final HostnameVerifier q;
    final g r;
    final b s;
    final b t;
    final j u;
    final o v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    /* JADX INFO: compiled from: OkHttpClient.java */
    public static final class a {
        int A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        n f5319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Proxy f5320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<w> f5321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<k> f5322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<t> f5323e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<t> f5324f;
        p.a g;
        ProxySelector h;
        m i;
        c j;
        com.bytedance.sdk.a.b.a.a.e k;
        SocketFactory l;
        SSLSocketFactory m;
        com.bytedance.sdk.a.b.a.i.c n;
        HostnameVerifier o;
        g p;
        b q;
        b r;
        j s;
        o t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.f5323e = new ArrayList();
            this.f5324f = new ArrayList();
            this.f5319a = new n();
            this.f5321c = v.f5313a;
            this.f5322d = v.f5314b;
            this.g = p.a(p.f5281a);
            this.h = ProxySelector.getDefault();
            this.i = m.f5273a;
            this.l = SocketFactory.getDefault();
            this.o = com.bytedance.sdk.a.b.a.i.e.f5196a;
            this.p = g.f5236a;
            b bVar = b.f5221a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.f5280a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.x = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.y = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.z = com.bytedance.sdk.a.b.a.c.a("timeout", j, timeUnit);
            return this;
        }

        public a a(boolean z) {
            this.u = z;
            return this;
        }

        public a b(boolean z) {
            this.v = z;
            return this;
        }

        public v a() {
            return new v(this);
        }

        a(v vVar) {
            this.f5323e = new ArrayList();
            this.f5324f = new ArrayList();
            this.f5319a = vVar.f5315c;
            this.f5320b = vVar.f5316d;
            this.f5321c = vVar.f5317e;
            this.f5322d = vVar.f5318f;
            this.f5323e.addAll(vVar.g);
            this.f5324f.addAll(vVar.h);
            this.g = vVar.i;
            this.h = vVar.j;
            this.i = vVar.k;
            this.k = vVar.m;
            this.j = vVar.l;
            this.l = vVar.n;
            this.m = vVar.o;
            this.n = vVar.p;
            this.o = vVar.q;
            this.p = vVar.r;
            this.q = vVar.s;
            this.r = vVar.t;
            this.s = vVar.u;
            this.t = vVar.v;
            this.u = vVar.w;
            this.v = vVar.x;
            this.w = vVar.y;
            this.x = vVar.z;
            this.y = vVar.A;
            this.z = vVar.B;
            this.A = vVar.C;
        }
    }

    static {
        com.bytedance.sdk.a.b.a.a.f4904a = new com.bytedance.sdk.a.b.a.a() { // from class: com.bytedance.sdk.a.b.v.1
            @Override // com.bytedance.sdk.a.b.a.a
            public void a(r.a aVar, String str) {
                aVar.a(str);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void b(j jVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                jVar.a(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(r.a aVar, String str, String str2) {
                aVar.b(str, str2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean a(j jVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                return jVar.b(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public com.bytedance.sdk.a.b.a.b.c a(j jVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, ac acVar) {
                return jVar.a(aVar, gVar, acVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public Socket a(j jVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a.b.g gVar) {
                return jVar.a(aVar, gVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public com.bytedance.sdk.a.b.a.b.d a(j jVar) {
                return jVar.f5252a;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public int a(aa.a aVar) {
                return aVar.f5205c;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.a(sSLSocket, z);
            }
        };
    }

    public v() {
        this(new a());
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("No System TLS", (Exception) e2);
        }
    }

    private X509TrustManager z() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("No System TLS", (Exception) e2);
        }
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public Proxy d() {
        return this.f5316d;
    }

    public ProxySelector e() {
        return this.j;
    }

    public m f() {
        return this.k;
    }

    com.bytedance.sdk.a.b.a.a.e g() {
        c cVar = this.l;
        return cVar != null ? cVar.f5222a : this.m;
    }

    public o h() {
        return this.v;
    }

    public SocketFactory i() {
        return this.n;
    }

    public SSLSocketFactory j() {
        return this.o;
    }

    public HostnameVerifier k() {
        return this.q;
    }

    public g l() {
        return this.r;
    }

    public b m() {
        return this.t;
    }

    public b n() {
        return this.s;
    }

    public j o() {
        return this.u;
    }

    public boolean p() {
        return this.w;
    }

    public boolean q() {
        return this.x;
    }

    public boolean r() {
        return this.y;
    }

    public n s() {
        return this.f5315c;
    }

    public List<w> t() {
        return this.f5317e;
    }

    public List<k> u() {
        return this.f5318f;
    }

    public List<t> v() {
        return this.g;
    }

    public List<t> w() {
        return this.h;
    }

    public p.a x() {
        return this.i;
    }

    public a y() {
        return new a(this);
    }

    v(a aVar) {
        boolean z;
        this.f5315c = aVar.f5319a;
        this.f5316d = aVar.f5320b;
        this.f5317e = aVar.f5321c;
        this.f5318f = aVar.f5322d;
        this.g = com.bytedance.sdk.a.b.a.c.a(aVar.f5323e);
        this.h = com.bytedance.sdk.a.b.a.c.a(aVar.f5324f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<k> it = this.f5318f.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().a();
            }
        }
        if (aVar.m == null && z) {
            X509TrustManager x509TrustManagerZ = z();
            this.o = a(x509TrustManagerZ);
            this.p = com.bytedance.sdk.a.b.a.i.c.a(x509TrustManagerZ);
        } else {
            this.o = aVar.m;
            this.p = aVar.n;
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        }
        if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    public int a() {
        return this.z;
    }

    public e a(y yVar) {
        return x.a(this, yVar, false);
    }
}
