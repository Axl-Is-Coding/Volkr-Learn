package com.alibaba.mtl.log.d;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: UtTrustManager.java */
/* JADX INFO: loaded from: classes.dex */
class y implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TrustManager[] f3650a;

    y() {
    }

    static synchronized TrustManager[] getTrustManagers() {
        if (f3650a == null) {
            f3650a = new TrustManager[]{new y()};
        }
        return f3650a;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("parameter is not used");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("parameter is not used");
        }
        try {
            x509CertificateArr[0].checkValidity();
        } catch (Exception unused) {
            throw new CertificateException("Certificate not valid or trusted.");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
