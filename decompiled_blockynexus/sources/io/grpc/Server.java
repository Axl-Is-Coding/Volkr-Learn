package io.grpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Server {
    public abstract void awaitTermination() throws InterruptedException;

    public abstract boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException;

    public int getPort() {
        return -1;
    }

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    public abstract Server shutdown();

    public abstract Server shutdownNow();

    public abstract Server start() throws IOException;
}
