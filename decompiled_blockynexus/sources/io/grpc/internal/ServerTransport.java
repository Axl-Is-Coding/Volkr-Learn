package io.grpc.internal;

import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
public interface ServerTransport {
    void shutdown();

    void shutdownNow(Status status);
}
