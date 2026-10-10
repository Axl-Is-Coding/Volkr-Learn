package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.a.b.f;

/* JADX INFO: compiled from: CertificateChainCleaner.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {
    public static c a(X509TrustManager x509TrustManager) {
        return f.a().a(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
