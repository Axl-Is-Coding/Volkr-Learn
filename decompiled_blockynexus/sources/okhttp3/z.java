package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.cache.InternalCache;

/* JADX INFO: compiled from: OkHttpClient.java */
/* JADX INFO: loaded from: classes5.dex */
public class z implements Cloneable, Call.Factory, WebSocket.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final List<Protocol> f23495a = okhttp3.a.e.a(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final List<m> f23496b = okhttp3.a.e.a(m.f23440d, m.f23442f);
    final int A;
    final int B;
    final int C;
    final int D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Dispatcher f23497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Proxy f23498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<Protocol> f23499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<m> f23500f;
    final List<Interceptor> g;
    final List<Interceptor> h;
    final EventListener.Factory i;
    final ProxySelector j;
    final CookieJar k;
    final C2940e l;
    final InternalCache m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final okhttp3.internal.tls.c p;
    final HostnameVerifier q;
    final C2943h r;
    final Authenticator s;
    final Authenticator t;
    final C2947l u;
    final Dns v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    /* JADX INFO: compiled from: OkHttpClient.java */
    public static final class a {
        int A;
        int B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Dispatcher f23501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Proxy f23502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<Protocol> f23503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<m> f23504d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final List<Interceptor> f23505e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<Interceptor> f23506f;
        EventListener.Factory g;
        ProxySelector h;
        CookieJar i;
        C2940e j;
        InternalCache k;
        SocketFactory l;
        SSLSocketFactory m;
        okhttp3.internal.tls.c n;
        HostnameVerifier o;
        C2943h p;
        Authenticator q;
        Authenticator r;
        C2947l s;
        Dns t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.f23505e = new ArrayList();
            this.f23506f = new ArrayList();
            this.f23501a = new Dispatcher();
            this.f23503c = z.f23495a;
            this.f23504d = z.f23496b;
            this.g = EventListener.a(EventListener.f23030a);
            this.h = ProxySelector.getDefault();
            if (this.h == null) {
                this.h = new okhttp3.a.c.a();
            }
            this.i = CookieJar.NO_COOKIES;
            this.l = SocketFactory.getDefault();
            this.o = okhttp3.internal.tls.d.f23387a;
            this.p = C2943h.f23158a;
            Authenticator authenticator = Authenticator.NONE;
            this.q = authenticator;
            this.r = authenticator;
            this.s = new C2947l();
            this.t = Dns.SYSTEM;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.x = okhttp3.a.e.a("timeout", j, timeUnit);
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.y = okhttp3.a.e.a("timeout", j, timeUnit);
            return this;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.z = okhttp3.a.e.a("timeout", j, timeUnit);
            return this;
        }

        public a d(long j, TimeUnit timeUnit) {
            this.A = okhttp3.a.e.a("timeout", j, timeUnit);
            return this;
        }

        public a a(C2940e c2940e) {
            this.j = c2940e;
            this.k = null;
            return this;
        }

        public a b(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f23506f.add(interceptor);
            return this;
        }

        public a a(C2943h c2943h) {
            if (c2943h != null) {
                this.p = c2943h;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public a a(Authenticator authenticator) {
            if (authenticator != null) {
                this.r = authenticator;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public a a(boolean z) {
            this.w = z;
            return this;
        }

        public a a(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (!arrayList.contains(Protocol.HTTP_1_0)) {
                if (!arrayList.contains(null)) {
                    arrayList.remove(Protocol.SPDY_3);
                    this.f23503c = Collections.unmodifiableList(arrayList);
                    return this;
                }
                throw new IllegalArgumentException("protocols must not contain null");
            }
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
        }

        public a a(Interceptor interceptor) {
            if (interceptor != null) {
                this.f23505e.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public a a(EventListener eventListener) {
            if (eventListener != null) {
                this.g = EventListener.a(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public z a() {
            return new z(this);
        }

        a(z zVar) {
            this.f23505e = new ArrayList();
            this.f23506f = new ArrayList();
            this.f23501a = zVar.f23497c;
            this.f23502b = zVar.f23498d;
            this.f23503c = zVar.f23499e;
            this.f23504d = zVar.f23500f;
            this.f23505e.addAll(zVar.g);
            this.f23506f.addAll(zVar.h);
            this.g = zVar.i;
            this.h = zVar.j;
            this.i = zVar.k;
            this.k = zVar.m;
            this.j = zVar.l;
            this.l = zVar.n;
            this.m = zVar.o;
            this.n = zVar.p;
            this.o = zVar.q;
            this.p = zVar.r;
            this.q = zVar.s;
            this.r = zVar.t;
            this.s = zVar.u;
            this.t = zVar.v;
            this.u = zVar.w;
            this.v = zVar.x;
            this.w = zVar.y;
            this.x = zVar.z;
            this.y = zVar.A;
            this.z = zVar.B;
            this.A = zVar.C;
            this.B = zVar.D;
        }
    }

    static {
        okhttp3.a.a.f23061a = new y();
    }

    public z() {
        this(new a());
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextC = okhttp3.a.b.f.a().c();
            sSLContextC.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextC.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw okhttp3.a.e.a("No System TLS", (Exception) e2);
        }
    }

    public SSLSocketFactory A() {
        return this.o;
    }

    public int B() {
        return this.C;
    }

    public Authenticator b() {
        return this.t;
    }

    public int c() {
        return this.z;
    }

    public C2943h d() {
        return this.r;
    }

    public int e() {
        return this.A;
    }

    public C2947l f() {
        return this.u;
    }

    public List<m> g() {
        return this.f23500f;
    }

    public CookieJar h() {
        return this.k;
    }

    public Dispatcher i() {
        return this.f23497c;
    }

    public Dns j() {
        return this.v;
    }

    public EventListener.Factory k() {
        return this.i;
    }

    public boolean l() {
        return this.x;
    }

    public boolean m() {
        return this.w;
    }

    public HostnameVerifier n() {
        return this.q;
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(C c2) {
        return B.a(this, c2, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(C c2, L l) {
        okhttp3.internal.ws.c cVar = new okhttp3.internal.ws.c(c2, l, new Random(), this.D);
        cVar.a(this);
        return cVar;
    }

    public List<Interceptor> o() {
        return this.g;
    }

    InternalCache p() {
        C2940e c2940e = this.l;
        return c2940e != null ? c2940e.f23123a : this.m;
    }

    public List<Interceptor> q() {
        return this.h;
    }

    public a r() {
        return new a(this);
    }

    public int s() {
        return this.D;
    }

    public List<Protocol> t() {
        return this.f23499e;
    }

    public Proxy u() {
        return this.f23498d;
    }

    public Authenticator v() {
        return this.s;
    }

    public ProxySelector w() {
        return this.j;
    }

    public int x() {
        return this.B;
    }

    public boolean y() {
        return this.y;
    }

    public SocketFactory z() {
        return this.n;
    }

    z(a aVar) {
        boolean z;
        this.f23497c = aVar.f23501a;
        this.f23498d = aVar.f23502b;
        this.f23499e = aVar.f23503c;
        this.f23500f = aVar.f23504d;
        this.g = okhttp3.a.e.a(aVar.f23505e);
        this.h = okhttp3.a.e.a(aVar.f23506f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<m> it = this.f23500f.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().b();
            }
        }
        if (aVar.m == null && z) {
            X509TrustManager x509TrustManagerA = okhttp3.a.e.a();
            this.o = a(x509TrustManagerA);
            this.p = okhttp3.internal.tls.c.a(x509TrustManagerA);
        } else {
            this.o = aVar.m;
            this.p = aVar.n;
        }
        if (this.o != null) {
            okhttp3.a.b.f.a().a(this.o);
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
        this.D = aVar.B;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        }
        if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }
}
