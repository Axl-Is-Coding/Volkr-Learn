package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
public interface ServerStream extends Stream {
    Attributes attributes();

    void cancel(Status status);

    void close(Status status, Metadata metadata);

    void writeHeaders(Metadata metadata);
}
