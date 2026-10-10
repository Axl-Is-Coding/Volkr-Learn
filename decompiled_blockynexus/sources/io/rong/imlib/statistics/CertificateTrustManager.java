package io.rong.imlib.statistics;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes5.dex */
public final class CertificateTrustManager implements X509TrustManager {
    private final List<byte[]> keys;

    public CertificateTrustManager(List<String> list) throws CertificateException {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("You must specify non-empty keys list");
        }
        this.keys = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.keys.add(CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(it.next(), 0))).getPublicKey().getEncoded());
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            throw new IllegalArgumentException("PublicKeyManager: X509Certificate array is null");
        }
        if (x509CertificateArr.length <= 0) {
            throw new IllegalArgumentException("PublicKeyManager: X509Certificate is empty");
        }
        if (str == null || !str.equalsIgnoreCase("RSA")) {
            throw new CertificateException("PublicKeyManager: AuthType is not RSA");
        }
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init((KeyStore) null);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
            }
            byte[] encoded = x509CertificateArr[0].getPublicKey().getEncoded();
            Iterator<byte[]> it = this.keys.iterator();
            while (it.hasNext()) {
                if (Arrays.equals(it.next(), encoded)) {
                    return;
                }
            }
            throw new CertificateException("Public keys didn't pass checks");
        } catch (Exception e2) {
            throw new CertificateException(e2);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
