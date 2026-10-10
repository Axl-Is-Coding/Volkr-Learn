package com.alibaba.sdk.android.feedback.xblink.g;

import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class a implements X509TrustManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    X509TrustManager f3873a;

    public a() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        for (int i = 0; i < trustManagers.length; i++) {
            if (trustManagers[i] instanceof X509TrustManager) {
                this.f3873a = (X509TrustManager) trustManagers[i];
                return;
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        long j;
        Calendar calendar = Calendar.getInstance();
        if (TextUtils.isEmpty(null)) {
            j = 0;
        } else {
            try {
                j = Long.parseLong(null);
            } catch (NumberFormatException unused) {
                g.b("ANetX509TrustManager", "[getTimeOffset] parse t_offset failed");
                j = 0;
            }
        }
        calendar.add(13, (int) j);
        Date time = calendar.getTime();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            x509Certificate.checkValidity(time);
        }
        try {
            this.f3873a.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e2) {
            g.b("ANetX509TrustManager", "CertificateException", e2);
            Throwable cause = e2;
            while (cause.getCause() != null) {
                cause = cause.getCause();
                if ((cause instanceof CertificateExpiredException) || (cause instanceof CertificateNotYetValidException)) {
                    return;
                }
            }
            throw e2;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.f3873a.getAcceptedIssuers();
    }
}
