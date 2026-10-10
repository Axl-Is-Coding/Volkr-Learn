package io.grpc.internal;

import java.io.Closeable;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public interface ClientTransportFactory extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ConnectionClientTransport newClientTransport(SocketAddress socketAddress, String str, String str2);
}
