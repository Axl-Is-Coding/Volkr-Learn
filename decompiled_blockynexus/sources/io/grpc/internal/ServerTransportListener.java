package io.grpc.internal;

import io.grpc.Metadata;

/* JADX INFO: loaded from: classes5.dex */
public interface ServerTransportListener {
    ServerStreamListener streamCreated(ServerStream serverStream, String str, Metadata metadata);

    void transportTerminated();
}
