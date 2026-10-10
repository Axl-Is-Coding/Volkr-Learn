package com.bytedance.sdk.a.b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: ConnectionSpec.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f5260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f5261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String[] f5262f;
    final String[] g;
    private static final h[] h = {h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, h.ag, h.ah, h.E, h.I, h.i};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f5257a = new a(true).a(h).a(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0).a(true).a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f5258b = new a(f5257a).a(ad.TLS_1_0).a(true).a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f5259c = new a(false).a();

    k(a aVar) {
        this.f5260d = aVar.f5263a;
        this.f5262f = aVar.f5264b;
        this.g = aVar.f5265c;
        this.f5261e = aVar.f5266d;
    }

    public boolean a() {
        return this.f5260d;
    }

    public List<h> b() {
        String[] strArr = this.f5262f;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public List<ad> c() {
        String[] strArr = this.g;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean d() {
        return this.f5261e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z = this.f5260d;
        if (z != kVar.f5260d) {
            return false;
        }
        return !z || (Arrays.equals(this.f5262f, kVar.f5262f) && Arrays.equals(this.g, kVar.g) && this.f5261e == kVar.f5261e);
    }

    public int hashCode() {
        if (this.f5260d) {
            return ((((527 + Arrays.hashCode(this.f5262f)) * 31) + Arrays.hashCode(this.g)) * 31) + (!this.f5261e ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5260d) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f5262f != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.g != null ? c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f5261e + ")";
    }

    /* JADX INFO: compiled from: ConnectionSpec.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String[] f5264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String[] f5265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f5266d;

        a(boolean z) {
            this.f5263a = z;
        }

        public a a(h... hVarArr) {
            if (!this.f5263a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                strArr[i] = hVarArr[i].bj;
            }
            return a(strArr);
        }

        public a b(String... strArr) {
            if (!this.f5263a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f5265c = (String[]) strArr.clone();
            return this;
        }

        public a(k kVar) {
            this.f5263a = kVar.f5260d;
            this.f5264b = kVar.f5262f;
            this.f5265c = kVar.g;
            this.f5266d = kVar.f5261e;
        }

        public a a(String... strArr) {
            if (this.f5263a) {
                if (strArr.length != 0) {
                    this.f5264b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(ad... adVarArr) {
            if (this.f5263a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f5220f;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f5263a) {
                this.f5266d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k a() {
            return new k(this);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] strArrA = this.f5262f != null ? com.bytedance.sdk.a.b.a.c.a(h.f5244a, sSLSocket.getEnabledCipherSuites(), this.f5262f) : sSLSocket.getEnabledCipherSuites();
        String[] strArrA2 = this.g != null ? com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.h, sSLSocket.getEnabledProtocols(), this.g) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iA = com.bytedance.sdk.a.b.a.c.a(h.f5244a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iA != -1) {
            strArrA = com.bytedance.sdk.a.b.a.c.a(strArrA, supportedCipherSuites[iA]);
        }
        return new a(this).a(strArrA).b(strArrA2).a();
    }

    void a(SSLSocket sSLSocket, boolean z) {
        k kVarB = b(sSLSocket, z);
        String[] strArr = kVarB.g;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = kVarB.f5262f;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f5260d) {
            return false;
        }
        String[] strArr = this.g;
        if (strArr != null && !com.bytedance.sdk.a.b.a.c.b(com.bytedance.sdk.a.b.a.c.h, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f5262f;
        return strArr2 == null || com.bytedance.sdk.a.b.a.c.b(h.f5244a, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
