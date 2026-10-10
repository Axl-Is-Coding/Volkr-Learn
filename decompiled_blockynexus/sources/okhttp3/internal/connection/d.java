package okhttp3.internal.connection;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.C;
import okhttp3.C2936a;
import okhttp3.C2943h;
import okhttp3.C2947l;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.G;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.K;
import okhttp3.Protocol;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.j;
import okhttp3.internal.http2.o;
import okhttp3.internal.ws.c;
import okhttp3.m;
import okhttp3.t;
import okhttp3.v;
import okhttp3.z;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: RealConnection.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends j.b implements Connection {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2947l f23212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final K f23213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Socket f23214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Socket f23215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private t f23216f;
    private Protocol g;
    private j h;
    private BufferedSource i;
    private BufferedSink j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<g>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public d(C2947l c2947l, K k) {
        this.f23212b = c2947l;
        this.f23213c = k;
    }

    private C c() throws IOException {
        C.a aVar = new C.a();
        aVar.a(this.f23213c.a().k());
        aVar.a("CONNECT", (G) null);
        aVar.b("Host", okhttp3.a.e.a(this.f23213c.a().k(), true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b(AbstractSpiCall.HEADER_USER_AGENT, okhttp3.a.f.a());
        C cA = aVar.a();
        H.a aVar2 = new H.a();
        aVar2.a(cA);
        aVar2.a(Protocol.HTTP_1_1);
        aVar2.a(407);
        aVar2.a("Preemptive Authenticate");
        aVar2.a(okhttp3.a.e.f23115c);
        aVar2.b(-1L);
        aVar2.a(-1L);
        aVar2.b("Proxy-Authenticate", "OkHttp-Preemptive");
        C cAuthenticate = this.f23213c.a().g().authenticate(this.f23213c, aVar2.a());
        return cAuthenticate != null ? cAuthenticate : cA;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.d.a(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public boolean b() {
        return this.h != null;
    }

    @Override // okhttp3.Connection
    public t handshake() {
        return this.f23216f;
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.g;
    }

    @Override // okhttp3.Connection
    public K route() {
        return this.f23213c;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.f23215e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f23213c.a().k().g());
        sb.append(":");
        sb.append(this.f23213c.a().k().k());
        sb.append(", proxy=");
        sb.append(this.f23213c.b());
        sb.append(" hostAddress=");
        sb.append(this.f23213c.d());
        sb.append(" cipherSuite=");
        t tVar = this.f23216f;
        sb.append(tVar != null ? tVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        C c2 = c();
        v vVarG = c2.g();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, call, eventListener);
            c2 = a(i2, i3, c2, vVarG);
            if (c2 == null) {
                return;
            }
            okhttp3.a.e.a(this.f23214d);
            this.f23214d = null;
            this.j = null;
            this.i = null;
            eventListener.a(call, this.f23213c.d(), this.f23213c.b(), null);
        }
    }

    private void a(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.f23213c.b();
        C2936a c2936aA = this.f23213c.a();
        if (proxyB.type() != Proxy.Type.DIRECT && proxyB.type() != Proxy.Type.HTTP) {
            socketCreateSocket = new Socket(proxyB);
        } else {
            socketCreateSocket = c2936aA.i().createSocket();
        }
        this.f23214d = socketCreateSocket;
        eventListener.a(call, this.f23213c.d(), proxyB);
        this.f23214d.setSoTimeout(i2);
        try {
            okhttp3.a.b.f.a().a(this.f23214d, this.f23213c.d(), i);
            try {
                this.i = Okio.buffer(Okio.source(this.f23214d));
                this.j = Okio.buffer(Okio.sink(this.f23214d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f23213c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar, int i, Call call, EventListener eventListener) throws Throwable {
        if (this.f23213c.a().j() == null) {
            if (this.f23213c.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                this.f23215e = this.f23214d;
                this.g = Protocol.H2_PRIOR_KNOWLEDGE;
                a(i);
                return;
            } else {
                this.f23215e = this.f23214d;
                this.g = Protocol.HTTP_1_1;
                return;
            }
        }
        eventListener.g(call);
        a(bVar);
        eventListener.a(call, this.f23216f);
        if (this.g == Protocol.HTTP_2) {
            a(i);
        }
    }

    private void a(int i) throws IOException {
        this.f23215e.setSoTimeout(0);
        j.a aVar = new j.a(true);
        aVar.a(this.f23215e, this.f23213c.a().k().g(), this.i, this.j);
        aVar.a(this);
        aVar.a(i);
        this.h = aVar.a();
        this.h.n();
    }

    private void a(b bVar) throws Throwable {
        SSLSocket sSLSocket;
        Protocol protocol;
        C2936a c2936aA = this.f23213c.a();
        try {
            try {
                sSLSocket = (SSLSocket) c2936aA.j().createSocket(this.f23214d, c2936aA.k().g(), c2936aA.k().k(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
            sSLSocket = null;
        }
        try {
            m mVarA = bVar.a(sSLSocket);
            if (mVarA.c()) {
                okhttp3.a.b.f.a().a(sSLSocket, c2936aA.k().g(), c2936aA.e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            t tVarA = t.a(session);
            if (c2936aA.d().verify(c2936aA.k().g(), session)) {
                c2936aA.a().a(c2936aA.k().g(), tVarA.c());
                String strB = mVarA.c() ? okhttp3.a.b.f.a().b(sSLSocket) : null;
                this.f23215e = sSLSocket;
                this.i = Okio.buffer(Okio.source(this.f23215e));
                this.j = Okio.buffer(Okio.sink(this.f23215e));
                this.f23216f = tVarA;
                if (strB != null) {
                    protocol = Protocol.get(strB);
                } else {
                    protocol = Protocol.HTTP_1_1;
                }
                this.g = protocol;
                if (sSLSocket != null) {
                    okhttp3.a.b.f.a().a(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) tVarA.c().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + c2936aA.k().g() + " not verified:\n    certificate: " + C2943h.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.internal.tls.d.a(x509Certificate));
        } catch (AssertionError e3) {
            e = e3;
            if (!okhttp3.a.e.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                okhttp3.a.b.f.a().a(sSLSocket);
            }
            okhttp3.a.e.a((Socket) sSLSocket);
            throw th;
        }
    }

    private C a(int i, int i2, C c2, v vVar) throws IOException {
        String str = "CONNECT " + okhttp3.a.e.a(vVar, true) + " HTTP/1.1";
        while (true) {
            okhttp3.a.a.b bVar = new okhttp3.a.a.b(null, null, this.i, this.j);
            this.i.timeout().timeout(i, TimeUnit.MILLISECONDS);
            this.j.timeout().timeout(i2, TimeUnit.MILLISECONDS);
            bVar.a(c2.c(), str);
            bVar.finishRequest();
            H.a responseHeaders = bVar.readResponseHeaders(false);
            responseHeaders.a(c2);
            H hA = responseHeaders.a();
            long jA = okhttp3.internal.http.e.a(hA);
            if (jA == -1) {
                jA = 0;
            }
            Source sourceB = bVar.b(jA);
            okhttp3.a.e.b(sourceB, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            sourceB.close();
            int iG = hA.g();
            if (iG == 200) {
                if (this.i.buffer().exhausted() && this.j.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iG == 407) {
                C cAuthenticate = this.f23213c.a().g().authenticate(this.f23213c, hA);
                if (cAuthenticate != null) {
                    if ("close".equalsIgnoreCase(hA.a("Connection"))) {
                        return cAuthenticate;
                    }
                    c2 = cAuthenticate;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + hA.g());
            }
        }
    }

    public boolean a(C2936a c2936a, K k) {
        if (this.n.size() >= this.m || this.k || !okhttp3.a.a.f23061a.a(this.f23213c.a(), c2936a)) {
            return false;
        }
        if (c2936a.k().g().equals(route().a().k().g())) {
            return true;
        }
        if (this.h == null || k == null || k.b().type() != Proxy.Type.DIRECT || this.f23213c.b().type() != Proxy.Type.DIRECT || !this.f23213c.d().equals(k.d()) || k.a().d() != okhttp3.internal.tls.d.f23387a || !a(c2936a.k())) {
            return false;
        }
        try {
            c2936a.a().a(c2936a.k().g(), handshake().c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(v vVar) {
        if (vVar.k() != this.f23213c.a().k().k()) {
            return false;
        }
        if (vVar.g().equals(this.f23213c.a().k().g())) {
            return true;
        }
        return this.f23216f != null && okhttp3.internal.tls.d.f23387a.verify(vVar.g(), (X509Certificate) this.f23216f.c().get(0));
    }

    public HttpCodec a(z zVar, Interceptor.Chain chain, g gVar) throws SocketException {
        j jVar = this.h;
        if (jVar != null) {
            return new okhttp3.internal.http2.c(zVar, chain, gVar, jVar);
        }
        this.f23215e.setSoTimeout(chain.readTimeoutMillis());
        this.i.timeout().timeout(chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.j.timeout().timeout(chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new okhttp3.a.a.b(zVar, gVar, this.i, this.j);
    }

    public c.e a(g gVar) {
        return new c(this, true, this.i, this.j, gVar);
    }

    public void a() {
        okhttp3.a.e.a(this.f23214d);
    }

    public boolean a(boolean z) {
        if (this.f23215e.isClosed() || this.f23215e.isInputShutdown() || this.f23215e.isOutputShutdown()) {
            return false;
        }
        if (this.h != null) {
            return !r0.d();
        }
        if (z) {
            try {
                int soTimeout = this.f23215e.getSoTimeout();
                try {
                    this.f23215e.setSoTimeout(1);
                    return !this.i.exhausted();
                } finally {
                    this.f23215e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.j.b
    public void a(o oVar) throws IOException {
        oVar.a(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.j.b
    public void a(j jVar) {
        synchronized (this.f23212b) {
            this.m = jVar.g();
        }
    }
}
