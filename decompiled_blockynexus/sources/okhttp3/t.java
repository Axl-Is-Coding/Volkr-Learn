package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: Handshake.java */
/* JADX INFO: loaded from: classes5.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TlsVersion f23460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2945j f23461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Certificate> f23462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Certificate> f23463d;

    private t(TlsVersion tlsVersion, C2945j c2945j, List<Certificate> list, List<Certificate> list2) {
        this.f23460a = tlsVersion;
        this.f23461b = c2945j;
        this.f23462c = list;
        this.f23463d = list2;
    }

    public static t a(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        C2945j c2945jA = C2945j.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion tlsVersionForJavaName = TlsVersion.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listA = peerCertificates != null ? okhttp3.a.e.a(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new t(tlsVersionForJavaName, c2945jA, listA, localCertificates != null ? okhttp3.a.e.a(localCertificates) : Collections.emptyList());
    }

    public List<Certificate> b() {
        return this.f23463d;
    }

    public List<Certificate> c() {
        return this.f23462c;
    }

    public TlsVersion d() {
        return this.f23460a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f23460a.equals(tVar.f23460a) && this.f23461b.equals(tVar.f23461b) && this.f23462c.equals(tVar.f23462c) && this.f23463d.equals(tVar.f23463d);
    }

    public int hashCode() {
        return ((((((527 + this.f23460a.hashCode()) * 31) + this.f23461b.hashCode()) * 31) + this.f23462c.hashCode()) * 31) + this.f23463d.hashCode();
    }

    public static t a(TlsVersion tlsVersion, C2945j c2945j, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (c2945j != null) {
            return new t(tlsVersion, c2945j, okhttp3.a.e.a(list), okhttp3.a.e.a(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    public C2945j a() {
        return this.f23461b;
    }
}
