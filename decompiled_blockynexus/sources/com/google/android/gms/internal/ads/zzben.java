package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzben extends SSLSocketFactory {
    private SSLSocketFactory zzekh = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private final /* synthetic */ zzbek zzeki;

    zzben(zzbek zzbekVar) {
        this.zzeki = zzbekVar;
    }

    private final Socket zzb(Socket socket) throws SocketException {
        if (this.zzeki.zzeka > 0) {
            socket.setReceiveBufferSize(this.zzeki.zzeka);
        }
        this.zzeki.zza(socket);
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socketCreateSocket = this.zzekh.createSocket(socket, str, i, z);
        zzb(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zzekh.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zzekh.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.zzekh.createSocket(str, i);
        zzb(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.zzekh.createSocket(str, i, inetAddress, i2);
        zzb(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.zzekh.createSocket(inetAddress, i);
        zzb(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket socketCreateSocket = this.zzekh.createSocket(inetAddress, i, inetAddress2, i2);
        zzb(socketCreateSocket);
        return socketCreateSocket;
    }
}
