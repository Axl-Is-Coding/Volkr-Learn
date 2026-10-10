package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
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

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f4988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.sdk.a.b.a.b.g f4990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f4991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f4992e;

    public j(v vVar, boolean z) {
        this.f4988a = vVar;
        this.f4989b = z;
    }

    public boolean a() {
        return this.f4992e;
    }

    public void a(Object obj) {
        this.f4991d = obj;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        aa aaVarA;
        y yVarA;
        y yVarA2 = aVar.a();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.e eVarH = gVar.h();
        p pVarI = gVar.i();
        this.f4990c = new com.bytedance.sdk.a.b.a.b.g(this.f4988a.o(), a(yVarA2.a()), eVarH, pVarI, this.f4991d);
        aa aaVar = null;
        int i = 0;
        while (!this.f4992e) {
            try {
                try {
                    try {
                        aaVarA = gVar.a(yVarA2, this.f4990c, null, null);
                        if (aaVar != null) {
                            aaVarA = aaVarA.h().c(aaVar.h().a((ab) null).a()).a();
                        }
                        yVarA = a(aaVarA);
                    } catch (IOException e2) {
                        if (!a(e2, !(e2 instanceof com.bytedance.sdk.a.b.a.e.a), yVarA2)) {
                            throw e2;
                        }
                    }
                } catch (com.bytedance.sdk.a.b.a.b.e e3) {
                    if (!a(e3.a(), false, yVarA2)) {
                        throw e3.a();
                    }
                }
                if (yVarA == null) {
                    if (!this.f4989b) {
                        this.f4990c.c();
                    }
                    return aaVarA;
                }
                com.bytedance.sdk.a.b.a.c.a(aaVarA.g());
                int i2 = i + 1;
                if (i2 <= 20) {
                    if (!(yVarA.d() instanceof l)) {
                        if (!a(aaVarA, yVarA.a())) {
                            this.f4990c.c();
                            this.f4990c = new com.bytedance.sdk.a.b.a.b.g(this.f4988a.o(), a(yVarA.a()), eVarH, pVarI, this.f4991d);
                        } else if (this.f4990c.a() != null) {
                            throw new IllegalStateException("Closing the body of " + aaVarA + " didn't close its backing stream. Bad interceptor?");
                        }
                        aaVar = aaVarA;
                        yVarA2 = yVarA;
                        i = i2;
                    } else {
                        this.f4990c.c();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", aaVarA.c());
                    }
                } else {
                    this.f4990c.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
            } catch (Throwable th) {
                this.f4990c.a((IOException) null);
                this.f4990c.c();
                throw th;
            }
        }
        this.f4990c.c();
        throw new IOException("Canceled");
    }

    private com.bytedance.sdk.a.b.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierK;
        com.bytedance.sdk.a.b.g gVarL;
        if (sVar.c()) {
            SSLSocketFactory sSLSocketFactoryJ = this.f4988a.j();
            hostnameVerifierK = this.f4988a.k();
            sSLSocketFactory = sSLSocketFactoryJ;
            gVarL = this.f4988a.l();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierK = null;
            gVarL = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.f4988a.h(), this.f4988a.i(), sSLSocketFactory, hostnameVerifierK, gVarL, this.f4988a.n(), this.f4988a.d(), this.f4988a.t(), this.f4988a.u(), this.f4988a.e());
    }

    private boolean a(IOException iOException, boolean z, y yVar) {
        this.f4990c.a(iOException);
        if (this.f4988a.r()) {
            return !(z && (yVar.d() instanceof l)) && a(iOException, z) && this.f4990c.e();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private y a(aa aaVar) throws IOException {
        String strA;
        s sVarC;
        Proxy proxyD;
        if (aaVar != null) {
            com.bytedance.sdk.a.b.a.b.c cVarB = this.f4990c.b();
            ac acVarA = cVarB != null ? cVarB.a() : null;
            int iC = aaVar.c();
            String strB = aaVar.a().b();
            if (iC == 307 || iC == 308) {
                if (!strB.equals("GET") && !strB.equals("HEAD")) {
                    return null;
                }
            } else {
                if (iC == 401) {
                    return this.f4988a.m().a(acVarA, aaVar);
                }
                if (iC == 407) {
                    if (acVarA != null) {
                        proxyD = acVarA.b();
                    } else {
                        proxyD = this.f4988a.d();
                    }
                    if (proxyD.type() == Proxy.Type.HTTP) {
                        return this.f4988a.n().a(acVarA, aaVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (iC == 408) {
                    if (!this.f4988a.r() || (aaVar.a().d() instanceof l)) {
                        return null;
                    }
                    if (aaVar.i() == null || aaVar.i().c() != 408) {
                        return aaVar.a();
                    }
                    return null;
                }
                switch (iC) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f4988a.q() || (strA = aaVar.a(AgentWebPermissions.ACTION_LOCATION)) == null || (sVarC = aaVar.a().a().c(strA)) == null) {
                return null;
            }
            if (!sVarC.b().equals(aaVar.a().a().b()) && !this.f4988a.p()) {
                return null;
            }
            y.a aVarE = aaVar.a().e();
            if (f.c(strB)) {
                boolean zD = f.d(strB);
                if (f.e(strB)) {
                    aVarE.a("GET", (z) null);
                } else {
                    aVarE.a(strB, zD ? aaVar.a().d() : null);
                }
                if (!zD) {
                    aVarE.b("Transfer-Encoding");
                    aVarE.b("Content-Length");
                    aVarE.b("Content-Type");
                }
            }
            if (!a(aaVar, sVarC)) {
                aVarE.b("Authorization");
            }
            return aVarE.a(sVarC).d();
        }
        throw new IllegalStateException();
    }

    private boolean a(aa aaVar, s sVar) {
        s sVarA = aaVar.a().a();
        return sVarA.f().equals(sVar.f()) && sVarA.g() == sVar.g() && sVarA.b().equals(sVar.b());
    }
}
