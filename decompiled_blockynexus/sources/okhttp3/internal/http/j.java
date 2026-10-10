package okhttp3.internal.http;

import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C;
import okhttp3.C2936a;
import okhttp3.C2943h;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.G;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.J;
import okhttp3.K;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.v;
import okhttp3.z;

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f23250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile okhttp3.internal.connection.g f23252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f23253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f23254e;

    public j(z zVar, boolean z) {
        this.f23250a = zVar;
        this.f23251b = z;
    }

    public void a() {
        this.f23254e = true;
        okhttp3.internal.connection.g gVar = this.f23252c;
        if (gVar != null) {
            gVar.a();
        }
    }

    public boolean b() {
        return this.f23254e;
    }

    public okhttp3.internal.connection.g c() {
        return this.f23252c;
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        H hA;
        C cA;
        C cRequest = chain.request();
        g gVar = (g) chain;
        Call call = gVar.call();
        EventListener eventListenerA = gVar.a();
        okhttp3.internal.connection.g gVar2 = new okhttp3.internal.connection.g(this.f23250a.f(), a(cRequest.g()), call, eventListenerA, this.f23253d);
        this.f23252c = gVar2;
        H h = null;
        int i = 0;
        while (!this.f23254e) {
            try {
                try {
                    hA = gVar.a(cRequest, gVar2, null, null);
                    if (h != null) {
                        H.a aVarT = hA.t();
                        H.a aVarT2 = h.t();
                        aVarT2.a((J) null);
                        aVarT.c(aVarT2.a());
                        hA = aVarT.a();
                    }
                    try {
                        cA = a(hA, gVar2.g());
                    } catch (IOException e2) {
                        gVar2.f();
                        throw e2;
                    }
                } catch (IOException e3) {
                    if (!a(e3, gVar2, !(e3 instanceof ConnectionShutdownException), cRequest)) {
                        throw e3;
                    }
                } catch (RouteException e4) {
                    if (!a(e4.getLastConnectException(), gVar2, false, cRequest)) {
                        throw e4.getFirstConnectException();
                    }
                }
                if (cA == null) {
                    gVar2.f();
                    return hA;
                }
                okhttp3.a.e.a(hA.b());
                int i2 = i + 1;
                if (i2 > 20) {
                    gVar2.f();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (cA.a() instanceof UnrepeatableRequestBody) {
                    gVar2.f();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", hA.g());
                }
                if (!a(hA, cA.g())) {
                    gVar2.f();
                    gVar2 = new okhttp3.internal.connection.g(this.f23250a.f(), a(cA.g()), call, eventListenerA, this.f23253d);
                    this.f23252c = gVar2;
                } else if (gVar2.b() != null) {
                    throw new IllegalStateException("Closing the body of " + hA + " didn't close its backing stream. Bad interceptor?");
                }
                h = hA;
                cRequest = cA;
                i = i2;
            } catch (Throwable th) {
                gVar2.a((IOException) null);
                gVar2.f();
                throw th;
            }
        }
        gVar2.f();
        throw new IOException("Canceled");
    }

    public void a(Object obj) {
        this.f23253d = obj;
    }

    private C2936a a(v vVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierN;
        C2943h c2943hD;
        if (vVar.h()) {
            SSLSocketFactory sSLSocketFactoryA = this.f23250a.A();
            hostnameVerifierN = this.f23250a.n();
            sSLSocketFactory = sSLSocketFactoryA;
            c2943hD = this.f23250a.d();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierN = null;
            c2943hD = null;
        }
        return new C2936a(vVar.g(), vVar.k(), this.f23250a.j(), this.f23250a.z(), sSLSocketFactory, hostnameVerifierN, c2943hD, this.f23250a.v(), this.f23250a.u(), this.f23250a.t(), this.f23250a.g(), this.f23250a.w());
    }

    private boolean a(IOException iOException, okhttp3.internal.connection.g gVar, boolean z, C c2) {
        gVar.a(iOException);
        if (this.f23250a.y()) {
            return !(z && (c2.a() instanceof UnrepeatableRequestBody)) && a(iOException, z) && gVar.d();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private C a(H h, K k) throws IOException {
        String strA;
        v vVarF;
        Proxy proxyU;
        if (h != null) {
            int iG = h.g();
            String strE = h.y().e();
            if (iG == 307 || iG == 308) {
                if (!strE.equals("GET") && !strE.equals("HEAD")) {
                    return null;
                }
            } else {
                if (iG == 401) {
                    return this.f23250a.b().authenticate(k, h);
                }
                if (iG == 503) {
                    if ((h.v() == null || h.v().g() != 503) && a(h, Integer.MAX_VALUE) == 0) {
                        return h.y();
                    }
                    return null;
                }
                if (iG == 407) {
                    if (k != null) {
                        proxyU = k.b();
                    } else {
                        proxyU = this.f23250a.u();
                    }
                    if (proxyU.type() == Proxy.Type.HTTP) {
                        return this.f23250a.v().authenticate(k, h);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (iG == 408) {
                    if (!this.f23250a.y() || (h.y().a() instanceof UnrepeatableRequestBody)) {
                        return null;
                    }
                    if ((h.v() == null || h.v().g() != 408) && a(h, 0) <= 0) {
                        return h.y();
                    }
                    return null;
                }
                switch (iG) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f23250a.l() || (strA = h.a(AgentWebPermissions.ACTION_LOCATION)) == null || (vVarF = h.y().g().f(strA)) == null) {
                return null;
            }
            if (!vVarF.o().equals(h.y().g().o()) && !this.f23250a.m()) {
                return null;
            }
            C.a aVarF = h.y().f();
            if (f.b(strE)) {
                boolean zD = f.d(strE);
                if (f.c(strE)) {
                    aVarF.a("GET", (G) null);
                } else {
                    aVarF.a(strE, zD ? h.y().a() : null);
                }
                if (!zD) {
                    aVarF.a("Transfer-Encoding");
                    aVarF.a("Content-Length");
                    aVarF.a("Content-Type");
                }
            }
            if (!a(h, vVarF)) {
                aVarF.a("Authorization");
            }
            aVarF.a(vVarF);
            return aVarF.a();
        }
        throw new IllegalStateException();
    }

    private int a(H h, int i) {
        String strA = h.a("Retry-After");
        if (strA == null) {
            return i;
        }
        if (strA.matches("\\d+")) {
            return Integer.valueOf(strA).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean a(H h, v vVar) {
        v vVarG = h.y().g();
        return vVarG.g().equals(vVar.g()) && vVarG.k() == vVar.k() && vVarG.o().equals(vVar.o());
    }
}
