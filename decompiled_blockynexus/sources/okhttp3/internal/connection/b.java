package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.m;

/* JADX INFO: compiled from: ConnectionSpecSelector.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<m> f23206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23207b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23209d;

    public b(List<m> list) {
        this.f23206a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f23207b; i < this.f23206a.size(); i++) {
            if (this.f23206a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public m a(SSLSocket sSLSocket) throws IOException {
        m mVar;
        int i = this.f23207b;
        int size = this.f23206a.size();
        while (true) {
            if (i >= size) {
                mVar = null;
                break;
            }
            mVar = this.f23206a.get(i);
            if (mVar.a(sSLSocket)) {
                this.f23207b = i + 1;
                break;
            }
            i++;
        }
        if (mVar != null) {
            this.f23208c = b(sSLSocket);
            okhttp3.a.a.f23061a.a(mVar, sSLSocket, this.f23209d);
            return mVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f23209d + ", modes=" + this.f23206a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f23209d = true;
        if (!this.f23208c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
