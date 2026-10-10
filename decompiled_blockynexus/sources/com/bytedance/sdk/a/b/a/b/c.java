package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.b.a.e.g;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.i;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.k;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.q;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
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
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: RealConnection.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends g.b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4943c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Reference<g>> f4944d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4945e = Long.MAX_VALUE;
    private final j g;
    private final ac h;
    private Socket i;
    private Socket j;
    private q k;
    private w l;
    private com.bytedance.sdk.a.b.a.e.g m;
    private com.bytedance.sdk.a.a.e n;
    private com.bytedance.sdk.a.a.d o;

    public c(j jVar, ac acVar) {
        this.g = jVar;
        this.h = acVar;
    }

    private y e() {
        return new y.a().a(this.h.a().a()).a("Host", com.bytedance.sdk.a.b.a.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a(AbstractSpiCall.HEADER_USER_AGENT, com.bytedance.sdk.a.b.a.d.a()).d();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r16, int r17, int r18, boolean r19, com.bytedance.sdk.a.b.e r20, com.bytedance.sdk.a.b.p r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.b.c.a(int, int, int, boolean, com.bytedance.sdk.a.b.e, com.bytedance.sdk.a.b.p):void");
    }

    public Socket b() {
        return this.j;
    }

    public q c() {
        return this.k;
    }

    public boolean d() {
        return this.m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.h.a().a().f());
        sb.append(":");
        sb.append(this.h.a().a().g());
        sb.append(", proxy=");
        sb.append(this.h.b());
        sb.append(" hostAddress=");
        sb.append(this.h.c());
        sb.append(" cipherSuite=");
        q qVar = this.k;
        sb.append(qVar != null ? qVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i, int i2, int i3, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        y yVarE = e();
        s sVarA = yVarE.a();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, eVar, pVar);
            yVarE = a(i2, i3, yVarE, sVarA);
            if (yVarE == null) {
                return;
            }
            com.bytedance.sdk.a.b.a.c.a(this.i);
            this.i = null;
            this.o = null;
            this.n = null;
            pVar.a(eVar, this.h.c(), this.h.b(), null);
        }
    }

    private void a(int i, int i2, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        Proxy proxyB = this.h.b();
        this.i = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.h.a().c().createSocket() : new Socket(proxyB);
        pVar.a(eVar, this.h.c(), proxyB);
        this.i.setSoTimeout(i2);
        try {
            com.bytedance.sdk.a.b.a.g.e.b().a(this.i, this.h.c(), i);
            try {
                this.n = l.a(l.b(this.i));
                this.o = l.a(l.a(this.i));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar, com.bytedance.sdk.a.b.e eVar, p pVar) throws Throwable {
        if (this.h.a().i() == null) {
            this.l = w.HTTP_1_1;
            this.j = this.i;
            return;
        }
        pVar.b(eVar);
        a(bVar);
        pVar.a(eVar, this.k);
        if (this.l == w.HTTP_2) {
            this.j.setSoTimeout(0);
            this.m = new g.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a();
            this.m.c();
        }
    }

    private void a(b bVar) throws Throwable {
        SSLSocket sSLSocket;
        com.bytedance.sdk.a.b.a aVarA = this.h.a();
        try {
            try {
                sSLSocket = (SSLSocket) aVarA.i().createSocket(this.i, aVarA.a().f(), aVarA.a().g(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
            sSLSocket = null;
        }
        try {
            k kVarA = bVar.a(sSLSocket);
            if (kVarA.d()) {
                com.bytedance.sdk.a.b.a.g.e.b().a(sSLSocket, aVarA.a().f(), aVarA.e());
            }
            sSLSocket.startHandshake();
            q qVarA = q.a(sSLSocket.getSession());
            if (aVarA.j().verify(aVarA.a().f(), sSLSocket.getSession())) {
                aVarA.k().a(aVarA.a().f(), qVarA.b());
                String strA = kVarA.d() ? com.bytedance.sdk.a.b.a.g.e.b().a(sSLSocket) : null;
                this.j = sSLSocket;
                this.n = l.a(l.b(this.j));
                this.o = l.a(l.a(this.j));
                this.k = qVarA;
                this.l = strA != null ? w.a(strA) : w.HTTP_1_1;
                if (sSLSocket != null) {
                    com.bytedance.sdk.a.b.a.g.e.b().b(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) qVarA.b().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + aVarA.a().f() + " not verified:\n    certificate: " + com.bytedance.sdk.a.b.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
        } catch (AssertionError e3) {
            e = e3;
            if (!com.bytedance.sdk.a.b.a.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                com.bytedance.sdk.a.b.a.g.e.b().b(sSLSocket);
            }
            com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket);
            throw th;
        }
    }

    private y a(int i, int i2, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.n, this.o);
            this.n.a().a(i, TimeUnit.MILLISECONDS);
            this.o.a().a(i2, TimeUnit.MILLISECONDS);
            aVar.a(yVar.c(), str);
            aVar.b();
            aa aaVarA = aVar.a(false).a(yVar).a();
            long jA = com.bytedance.sdk.a.b.a.c.e.a(aaVarA);
            if (jA == -1) {
                jA = 0;
            }
            com.bytedance.sdk.a.a.s sVarB = aVar.b(jA);
            com.bytedance.sdk.a.b.a.c.b(sVarB, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            sVarB.close();
            int iC = aaVarA.c();
            if (iC == 200) {
                if (this.n.c().e() && this.o.c().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iC == 407) {
                y yVarA = this.h.a().d().a(this.h, aaVarA);
                if (yVarA != null) {
                    if ("close".equalsIgnoreCase(aaVarA.a("Connection"))) {
                        return yVarA;
                    }
                    yVar = yVarA;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + aaVarA.c());
            }
        }
    }

    public boolean a(com.bytedance.sdk.a.b.a aVar, ac acVar) {
        if (this.f4944d.size() >= this.f4943c || this.f4941a || !com.bytedance.sdk.a.b.a.a.f4904a.a(this.h.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(a().a().a().f())) {
            return true;
        }
        if (this.m == null || acVar == null || acVar.b().type() != Proxy.Type.DIRECT || this.h.b().type() != Proxy.Type.DIRECT || !this.h.c().equals(acVar.c()) || acVar.a().j() != com.bytedance.sdk.a.b.a.i.e.f5196a || !a(aVar.a())) {
            return false;
        }
        try {
            aVar.k().a(aVar.a().f(), c().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.h.a().a().g()) {
            return false;
        }
        if (sVar.f().equals(this.h.a().a().f())) {
            return true;
        }
        return this.k != null && com.bytedance.sdk.a.b.a.i.e.f5196a.a(sVar.f(), (X509Certificate) this.k.b().get(0));
    }

    public com.bytedance.sdk.a.b.a.c.c a(v vVar, t.a aVar, g gVar) throws SocketException {
        com.bytedance.sdk.a.b.a.e.g gVar2 = this.m;
        if (gVar2 != null) {
            return new com.bytedance.sdk.a.b.a.e.f(vVar, aVar, gVar, gVar2);
        }
        this.j.setSoTimeout(aVar.c());
        this.n.a().a(aVar.c(), TimeUnit.MILLISECONDS);
        this.o.a().a(aVar.d(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.a.b.a.d.a(vVar, gVar, this.n, this.o);
    }

    @Override // com.bytedance.sdk.a.b.i
    public ac a() {
        return this.h;
    }

    public boolean a(boolean z) {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        if (this.m != null) {
            return !r0.d();
        }
        if (z) {
            try {
                int soTimeout = this.j.getSoTimeout();
                try {
                    this.j.setSoTimeout(1);
                    return !this.n.e();
                } finally {
                    this.j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(com.bytedance.sdk.a.b.a.e.i iVar) throws IOException {
        iVar.a(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(com.bytedance.sdk.a.b.a.e.g gVar) {
        synchronized (this.g) {
            this.f4943c = gVar.a();
        }
    }
}
