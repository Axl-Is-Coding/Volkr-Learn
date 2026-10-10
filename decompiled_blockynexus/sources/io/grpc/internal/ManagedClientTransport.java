package io.grpc.internal;

import io.grpc.Status;

/* JADX INFO: loaded from: classes5.dex */
public interface ManagedClientTransport extends ClientTransport, WithLogId {

    public interface Listener {
        void transportInUse(boolean z);

        void transportReady();

        void transportShutdown(Status status);

        void transportTerminated();
    }

    void shutdown();

    void shutdownNow(Status status);

    void start(Listener listener);
}
