package c.t.m.g;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: renamed from: c.t.m.g.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
class C0454p extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3338b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3337a = C0454p.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3339c = false;

    public C0454p(String str) {
        this.f3338b = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (TextUtils.isEmpty(this.f3338b)) {
            throw new IOException("Halley set empty bizHost");
        }
        new StringBuilder("customized createSocket. host: ").append(this.f3338b);
        try {
            if (Build.VERSION.SDK_INT < 17) {
                SSLSocket sSLSocket = (SSLSocket) ((SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(fc.a()))).createSocket(socket, this.f3338b, i, z);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, this.f3338b);
                sSLSocket.startHandshake();
                return sSLSocket;
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(fc.a()));
            SSLSocket sSLSocket2 = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f3338b, i, z);
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket2, true);
            sSLSocket2.setEnabledProtocols(sSLSocket2.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(sSLSocket2, this.f3338b);
            sSLSocket2.startHandshake();
            return sSLSocket2;
        } catch (Throwable th) {
            this.f3339c = true;
            throw new IOException("HalleySNI exception: ".concat(String.valueOf(th)));
        }
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f3338b) || !(obj instanceof C0454p)) {
            return false;
        }
        String str = ((C0454p) obj).f3338b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f3338b.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
