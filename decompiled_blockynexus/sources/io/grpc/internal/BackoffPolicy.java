package io.grpc.internal;

/* JADX INFO: loaded from: classes5.dex */
interface BackoffPolicy {

    public interface Provider {
        BackoffPolicy get();
    }

    long nextBackoffMillis();
}
