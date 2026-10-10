package com.bytedance.sdk.a.b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: CertificatePinner.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f5236a = new a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<b> f5237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.sdk.a.b.a.i.c f5238c;

    /* JADX INFO: compiled from: CertificatePinner.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f5239a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f5239a), null);
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f5240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f5241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f5242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.bytedance.sdk.a.a.f f5243d;

        boolean a(String str) {
            if (!this.f5240a.startsWith("*.")) {
                return str.equals(this.f5241b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f5241b.length()) {
                String str2 = this.f5241b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f5240a.equals(bVar.f5240a) && this.f5242c.equals(bVar.f5242c) && this.f5243d.equals(bVar.f5243d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f5240a.hashCode()) * 31) + this.f5242c.hashCode()) * 31) + this.f5243d.hashCode();
        }

        public String toString() {
            return this.f5242c + this.f5243d.b();
        }
    }

    g(Set<b> set, com.bytedance.sdk.a.b.a.i.c cVar) {
        this.f5237b = set;
        this.f5238c = cVar;
    }

    static com.bytedance.sdk.a.a.f b(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listA = a(str);
        if (listA.isEmpty()) {
            return;
        }
        com.bytedance.sdk.a.b.a.i.c cVar = this.f5238c;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listA.size();
            com.bytedance.sdk.a.a.f fVarB = null;
            com.bytedance.sdk.a.a.f fVarA = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = listA.get(i2);
                if (bVar.f5242c.equals("sha256/")) {
                    if (fVarB == null) {
                        fVarB = b(x509Certificate);
                    }
                    if (bVar.f5243d.equals(fVarB)) {
                        return;
                    }
                } else {
                    if (!bVar.f5242c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f5242c);
                    }
                    if (fVarA == null) {
                        fVarA = a(x509Certificate);
                    }
                    if (bVar.f5243d.equals(fVarA)) {
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
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (com.bytedance.sdk.a.b.a.c.a(this.f5238c, gVar.f5238c) && this.f5237b.equals(gVar.f5237b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        com.bytedance.sdk.a.b.a.i.c cVar = this.f5238c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f5237b.hashCode();
    }

    List<b> a(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f5237b) {
            if (bVar.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    g a(com.bytedance.sdk.a.b.a.i.c cVar) {
        return com.bytedance.sdk.a.b.a.c.a(this.f5238c, cVar) ? this : new g(this.f5237b, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static com.bytedance.sdk.a.a.f a(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }
}
