package io.grpc.internal;

import io.grpc.Metadata;
import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
public interface ClientStreamListener extends StreamListener {
    void closed(Status status, Metadata metadata);

    void headersRead(Metadata metadata);
}
