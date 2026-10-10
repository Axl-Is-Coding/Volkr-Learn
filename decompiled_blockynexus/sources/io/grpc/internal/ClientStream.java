package io.grpc.internal;

import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
public interface ClientStream extends Stream {
    void cancel(Status status);

    void halfClose();

    void setAuthority(String str);

    void start(ClientStreamListener clientStreamListener);
}
