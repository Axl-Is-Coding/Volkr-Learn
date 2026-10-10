package com.bytedance.sdk.a.b.a.i;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: CertificateChainCleaner.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static c a(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.a.b.a.g.e.b().a(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
