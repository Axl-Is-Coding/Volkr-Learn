package io.grpc;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ManagedChannel extends Channel {
    public abstract boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException;

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    public abstract ManagedChannel shutdown();

    public abstract ManagedChannel shutdownNow();
}
