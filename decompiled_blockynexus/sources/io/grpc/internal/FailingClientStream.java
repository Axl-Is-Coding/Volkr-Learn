package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.Metadata;
import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
class FailingClientStream extends NoopClientStream {
    private final Status error;
    private boolean started;

    public FailingClientStream(Status status) {
        m.a(!status.isOk(), "error must not be OK");
        this.error = status;
    }

    Status getError() {
        return this.error;
    }

    @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        m.b(!this.started, "already started");
        this.started = true;
        clientStreamListener.closed(this.error, new Metadata());
    }
}
