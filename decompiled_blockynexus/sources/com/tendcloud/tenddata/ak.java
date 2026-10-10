package com.tendcloud.tenddata;

import com.alibaba.android.arouter.utils.Consts;
import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile HashMap<Long, String> f19778a = new HashMap<>();

    /* JADX INFO: compiled from: td */
    static class a implements X509TrustManager {
        X509Certificate cert;

        a(X509Certificate x509Certificate) {
            this.cert = x509Certificate;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            int iIndexOf;
            int length = x509CertificateArr.length;
            x509CertificateArr[0].getIssuerDN().equals(this.cert.getSubjectDN());
            try {
                String name = x509CertificateArr[0].getSubjectDN().getName();
                int iIndexOf2 = name.indexOf("CN=");
                if (iIndexOf2 >= 0 && (iIndexOf = (name = name.substring(iIndexOf2 + 3)).indexOf(",")) >= 0) {
                    name = name.substring(0, iIndexOf);
                }
                String[] strArrSplit = name.split("\\.");
                if (strArrSplit.length >= 2) {
                    name = strArrSplit[strArrSplit.length - 2] + Consts.DOT + strArrSplit[strArrSplit.length - 1];
                }
                if (!ak.f19778a.containsKey(Long.valueOf(Thread.currentThread().getId()))) {
                    throw new CertificateException("No valid host provided!");
                }
                if (!ak.f19778a.get(Long.valueOf(Thread.currentThread().getId())).endsWith(name)) {
                    throw new CertificateException("Server certificate has incorrect host name!");
                }
                x509CertificateArr[0].verify(this.cert.getPublicKey());
                x509CertificateArr[0].checkValidity();
            } catch (Throwable th) {
                bp.postSDKError(th);
                boolean z = th instanceof CertificateException;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public static SSLSocketFactory a(X509Certificate x509Certificate) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            if (x509Certificate != null) {
                sSLContext.init(null, new TrustManager[]{new a(x509Certificate)}, null);
            } else {
                sSLContext.init(null, null, null);
            }
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    private static void a(HttpsURLConnection httpsURLConnection) {
    }

    static void a(URLConnection uRLConnection, String str) {
        SSLContext sSLContext;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            if (af.a(16)) {
                sSLContext = SSLContext.getInstance("TLSv1.2");
            } else {
                sSLContext = SSLContext.getInstance("TLSv1");
            }
            sSLContext.init(null, new TrustManager[]{new a(a(str))}, null);
            httpsURLConnection.getHostnameVerifier();
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            a(httpsURLConnection);
        } catch (Throwable unused) {
        }
    }

    public static X509Certificate a(String str) {
        X509Certificate x509Certificate;
        if (af.b(str)) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            try {
                x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            } finally {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
            try {
                byteArrayInputStream.close();
            } catch (Throwable unused2) {
            }
            x509Certificate = null;
        }
        return x509Certificate;
    }
}
