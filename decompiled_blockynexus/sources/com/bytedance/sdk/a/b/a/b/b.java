package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: ConnectionSpecSelector.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<k> f4937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4938b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4940d;

    public b(List<k> list) {
        this.f4937a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f4938b; i < this.f4937a.size(); i++) {
            if (this.f4937a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i = this.f4938b;
        int size = this.f4937a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f4937a.get(i);
            if (kVar.a(sSLSocket)) {
                this.f4938b = i + 1;
                break;
            }
            i++;
        }
        if (kVar != null) {
            this.f4939c = b(sSLSocket);
            com.bytedance.sdk.a.b.a.a.f4904a.a(kVar, sSLSocket, this.f4940d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f4940d + ", modes=" + this.f4937a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f4940d = true;
        if (!this.f4939c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
