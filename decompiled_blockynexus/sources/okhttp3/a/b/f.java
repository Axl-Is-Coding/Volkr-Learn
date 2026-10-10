package okhttp3.a.b;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.tls.TrustRootIndex;
import okhttp3.z;
import okio.Buffer;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f23109a = e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f23110b = Logger.getLogger(z.class.getName());

    public static f a() {
        return f23109a;
    }

    static byte[] b(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    public static boolean d() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static f e() {
        b bVarE;
        f fVarE = a.e();
        if (fVarE != null) {
            return fVarE;
        }
        if (d() && (bVarE = b.e()) != null) {
            return bVarE;
        }
        c cVarE = c.e();
        if (cVarE != null) {
            return cVarE;
        }
        f fVarE2 = d.e();
        return fVarE2 != null ? fVarE2 : new f();
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    public String b() {
        return "OkHttp";
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public SSLContext c() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        f23110b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f23110b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public TrustRootIndex b(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.tls.b(x509TrustManager.getAcceptedIssuers());
    }

    public static List<String> a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public okhttp3.internal.tls.c a(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.tls.a(b(x509TrustManager));
    }
}
