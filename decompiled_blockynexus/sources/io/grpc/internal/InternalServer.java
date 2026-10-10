package io.grpc.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface InternalServer {
    int getPort();

    void shutdown();

    void start(ServerListener serverListener) throws IOException;
}
