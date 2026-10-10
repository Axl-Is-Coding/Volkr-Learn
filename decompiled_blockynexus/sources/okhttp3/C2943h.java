package okhttp3;

import com.just.agentweb.DefaultWebClient;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* JADX INFO: renamed from: okhttp3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CertificatePinner.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2943h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2943h f23158a = new a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<b> f23159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okhttp3.internal.tls.c f23160c;

    /* JADX INFO: renamed from: okhttp3.h$b */
    /* JADX INFO: compiled from: CertificatePinner.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f23162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f23163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f23164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ByteString f23165d;

        b(String str, String str2) {
            String strG;
            this.f23162a = str;
            if (str.startsWith("*.")) {
                strG = v.b(DefaultWebClient.HTTP_SCHEME + str.substring(2)).g();
            } else {
                strG = v.b(DefaultWebClient.HTTP_SCHEME + str).g();
            }
            this.f23163b = strG;
            if (str2.startsWith("sha1/")) {
                this.f23164c = "sha1/";
                this.f23165d = ByteString.decodeBase64(str2.substring(5));
            } else {
                if (!str2.startsWith("sha256/")) {
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                }
                this.f23164c = "sha256/";
                this.f23165d = ByteString.decodeBase64(str2.substring(7));
            }
            if (this.f23165d != null) {
                return;
            }
            throw new IllegalArgumentException("pins must be base64: " + str2);
        }

        boolean a(String str) {
            if (!this.f23162a.startsWith("*.")) {
                return str.equals(this.f23163b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f23163b.length()) {
                String str2 = this.f23163b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f23162a.equals(bVar.f23162a) && this.f23164c.equals(bVar.f23164c) && this.f23165d.equals(bVar.f23165d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f23162a.hashCode()) * 31) + this.f23164c.hashCode()) * 31) + this.f23165d.hashCode();
        }

        public String toString() {
            return this.f23164c + this.f23165d.base64();
        }
    }

    C2943h(Set<b> set, okhttp3.internal.tls.c cVar) {
        this.f23159b = set;
        this.f23160c = cVar;
    }

    static ByteString b(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listA = a(str);
        if (listA.isEmpty()) {
            return;
        }
        okhttp3.internal.tls.c cVar = this.f23160c;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listA.size();
            ByteString byteStringB = null;
            ByteString byteStringA = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = listA.get(i2);
                if (bVar.f23164c.equals("sha256/")) {
                    if (byteStringB == null) {
                        byteStringB = b(x509Certificate);
                    }
                    if (bVar.f23165d.equals(byteStringB)) {
                        return;
                    }
                } else {
                    if (!bVar.f23164c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f23164c);
                    }
                    if (byteStringA == null) {
                        byteStringA = a(x509Certificate);
                    }
                    if (bVar.f23165d.equals(byteStringA)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listA.size();
        for (int i4 = 0; i4 < size4; i4++) {
            b bVar2 = listA.get(i4);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2943h) {
            C2943h c2943h = (C2943h) obj;
            if (okhttp3.a.e.a(this.f23160c, c2943h.f23160c) && this.f23159b.equals(c2943h.f23159b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        okhttp3.internal.tls.c cVar = this.f23160c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f23159b.hashCode();
    }

    /* JADX INFO: renamed from: okhttp3.h$a */
    /* JADX INFO: compiled from: CertificatePinner.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f23161a = new ArrayList();

        public a a(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String str2 : strArr) {
                this.f23161a.add(new b(str, str2));
            }
            return this;
        }

        public C2943h a() {
            return new C2943h(new LinkedHashSet(this.f23161a), null);
        }
    }

    List<b> a(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f23159b) {
            if (bVar.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    C2943h a(okhttp3.internal.tls.c cVar) {
        return okhttp3.a.e.a(this.f23160c, cVar) ? this : new C2943h(this.f23159b, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString a(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }
}
