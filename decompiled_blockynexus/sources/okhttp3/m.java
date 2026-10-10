package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: ConnectionSpec.java */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C2945j[] f23437a = {C2945j.lb, C2945j.mb, C2945j.nb, C2945j.ob, C2945j.pb, C2945j.Ya, C2945j.bb, C2945j.Za, C2945j.cb, C2945j.ib, C2945j.hb};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C2945j[] f23438b = {C2945j.lb, C2945j.mb, C2945j.nb, C2945j.ob, C2945j.pb, C2945j.Ya, C2945j.bb, C2945j.Za, C2945j.cb, C2945j.ib, C2945j.hb, C2945j.Ja, C2945j.Ka, C2945j.ha, C2945j.ia, C2945j.F, C2945j.J, C2945j.j};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f23439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f23440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f23441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f23442f;
    final boolean g;
    final boolean h;
    final String[] i;
    final String[] j;

    static {
        a aVar = new a(true);
        aVar.a(f23437a);
        aVar.a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        aVar.a(true);
        f23439c = aVar.a();
        a aVar2 = new a(true);
        aVar2.a(f23438b);
        aVar2.a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        aVar2.a(true);
        f23440d = aVar2.a();
        a aVar3 = new a(true);
        aVar3.a(f23438b);
        aVar3.a(TlsVersion.TLS_1_0);
        aVar3.a(true);
        f23441e = aVar3.a();
        f23442f = new a(false).a();
    }

    m(a aVar) {
        this.g = aVar.f23443a;
        this.i = aVar.f23444b;
        this.j = aVar.f23445c;
        this.h = aVar.f23446d;
    }

    public List<C2945j> a() {
        String[] strArr = this.i;
        if (strArr != null) {
            return C2945j.a(strArr);
        }
        return null;
    }

    public boolean b() {
        return this.g;
    }

    public boolean c() {
        return this.h;
    }

    public List<TlsVersion> d() {
        String[] strArr = this.j;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        m mVar = (m) obj;
        boolean z = this.g;
        if (z != mVar.g) {
            return false;
        }
        return !z || (Arrays.equals(this.i, mVar.i) && Arrays.equals(this.j, mVar.j) && this.h == mVar.h);
    }

    public int hashCode() {
        if (this.g) {
            return ((((527 + Arrays.hashCode(this.i)) * 31) + Arrays.hashCode(this.j)) * 31) + (!this.h ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.g) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.i != null ? a().toString() : "[all enabled]") + ", tlsVersions=" + (this.j != null ? d().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.h + ")";
    }

    /* JADX INFO: compiled from: ConnectionSpec.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f23443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String[] f23444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String[] f23445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f23446d;

        a(boolean z) {
            this.f23443a = z;
        }

        public a a(C2945j... c2945jArr) {
            if (!this.f23443a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[c2945jArr.length];
            for (int i = 0; i < c2945jArr.length; i++) {
                strArr[i] = c2945jArr[i].qb;
            }
            a(strArr);
            return this;
        }

        public a b(String... strArr) {
            if (!this.f23443a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f23445c = (String[]) strArr.clone();
            return this;
        }

        public a(m mVar) {
            this.f23443a = mVar.g;
            this.f23444b = mVar.i;
            this.f23445c = mVar.j;
            this.f23446d = mVar.h;
        }

        public a a(String... strArr) {
            if (this.f23443a) {
                if (strArr.length != 0) {
                    this.f23444b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(TlsVersion... tlsVersionArr) {
            if (this.f23443a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f23443a) {
                this.f23446d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public m a() {
            return new m(this);
        }
    }

    private m b(SSLSocket sSLSocket, boolean z) {
        String[] strArrA = this.i != null ? okhttp3.a.e.a(C2945j.f23424a, sSLSocket.getEnabledCipherSuites(), this.i) : sSLSocket.getEnabledCipherSuites();
        String[] strArrA2 = this.j != null ? okhttp3.a.e.a(okhttp3.a.e.q, sSLSocket.getEnabledProtocols(), this.j) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iA = okhttp3.a.e.a(C2945j.f23424a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iA != -1) {
            strArrA = okhttp3.a.e.a(strArrA, supportedCipherSuites[iA]);
        }
        a aVar = new a(this);
        aVar.a(strArrA);
        aVar.b(strArrA2);
        return aVar.a();
    }

    void a(SSLSocket sSLSocket, boolean z) {
        m mVarB = b(sSLSocket, z);
        String[] strArr = mVarB.j;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = mVarB.i;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.g) {
            return false;
        }
        String[] strArr = this.j;
        if (strArr != null && !okhttp3.a.e.b(okhttp3.a.e.q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.i;
        return strArr2 == null || okhttp3.a.e.b(C2945j.f23424a, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
