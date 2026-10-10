package com.alibaba.sdk.android.feedback.xblink.g;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class b extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f3874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3877d;

    public b(String str, int i, SSLSocketFactory sSLSocketFactory, String str2) {
        this.f3875b = str;
        this.f3876c = i;
        if (sSLSocketFactory != null) {
            this.f3874a = sSLSocketFactory;
        } else {
            this.f3874a = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
        this.f3877d = str2;
    }

    private void a(Socket socket, String str, int i) throws IOException {
        byte[] bytes;
        String str2;
        OutputStream outputStream = socket.getOutputStream();
        String str3 = "CONNECT " + str + ":" + i + " HTTP/1.1\nUser-Agent: " + this.f3877d + UMCustomLogInfoBuilder.LINE_SEP + "Host:" + str + "\r\n\r\n";
        try {
            bytes = str3.getBytes("ASCII7");
        } catch (UnsupportedEncodingException unused) {
            bytes = str3.getBytes();
        }
        outputStream.write(bytes);
        outputStream.flush();
        byte[] bArr = new byte[200];
        InputStream inputStream = socket.getInputStream();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < 2) {
            int i4 = inputStream.read();
            if (i4 < 0) {
                throw new IOException("Unexpected EOF from proxy");
            }
            if (i4 == 10) {
                i2++;
                z = true;
            } else if (i4 != 13) {
                if (!z && i3 < bArr.length) {
                    bArr[i3] = (byte) i4;
                    i3++;
                }
                i2 = 0;
            }
        }
        try {
            str2 = new String(bArr, 0, i3, "ASCII7");
        } catch (UnsupportedEncodingException unused2) {
            str2 = new String(bArr, 0, i3);
        }
        if (str2.toLowerCase().contains("200 connection established")) {
            return;
        }
        throw new IOException("Unable to tunnel through " + this.f3875b + ":" + this.f3876c + ".  Proxy returns \"" + str2 + "\"");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return createSocket((Socket) null, str, i, true);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return createSocket((Socket) null, str, i, true);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return createSocket((Socket) null, inetAddress.getHostName(), i, true);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return createSocket((Socket) null, inetAddress.getHostName(), i, true);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socket2 = new Socket(this.f3875b, this.f3876c);
        a(socket2, str, i);
        SSLSocket sSLSocket = (SSLSocket) this.f3874a.createSocket(socket2, str, i, z);
        sSLSocket.addHandshakeCompletedListener(new c(this));
        sSLSocket.startHandshake();
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f3874a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f3874a.getSupportedCipherSuites();
    }
}
