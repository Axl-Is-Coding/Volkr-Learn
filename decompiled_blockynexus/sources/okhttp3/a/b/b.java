package okhttp3.a.b;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: ConscryptPlatform.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends f {
    private b() {
    }

    public static b e() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new b();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider f() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // okhttp3.a.b.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.a(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) f.a(list).toArray(new String[0]));
    }

    @Override // okhttp3.a.b.f
    public String b(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.b(sSLSocket);
    }

    @Override // okhttp3.a.b.f
    public SSLContext c() {
        try {
            return SSLContext.getInstance("TLSv1.3", f());
        } catch (NoSuchAlgorithmException e2) {
            try {
                return SSLContext.getInstance("TLS", f());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e2);
            }
        }
    }

    @Override // okhttp3.a.b.f
    public void a(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
