package io.grpc.internal;

import com.google.common.base.t;
import com.google.common.collect.Maps;
import io.grpc.internal.ClientTransport;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class Http2Ping {
    private static final Logger log = Logger.getLogger(Http2Ping.class.getName());
    private Map<ClientTransport.PingCallback, Executor> callbacks = Maps.c();
    private boolean completed;
    private final long data;
    private Throwable failureCause;
    private long roundTripTimeNanos;
    private final t stopwatch;

    public Http2Ping(long j, t tVar) {
        this.data = j;
        this.stopwatch = tVar;
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final long j) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.1
            @Override // java.lang.Runnable
            public void run() {
                pingCallback.onSuccess(j);
            }
        };
    }

    private static void doExecute(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            log.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void notifyFailed(ClientTransport.PingCallback pingCallback, Executor executor, Throwable th) {
        doExecute(executor, asRunnable(pingCallback, th));
    }

    public void addCallback(ClientTransport.PingCallback pingCallback, Executor executor) {
        synchronized (this) {
            if (this.completed) {
                doExecute(executor, this.failureCause != null ? asRunnable(pingCallback, this.failureCause) : asRunnable(pingCallback, this.roundTripTimeNanos));
            } else {
                this.callbacks.put(pingCallback, executor);
            }
        }
    }

    public boolean complete() {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            long jA = this.stopwatch.a(TimeUnit.NANOSECONDS);
            this.roundTripTimeNanos = jA;
            Map<ClientTransport.PingCallback, Executor> map = this.callbacks;
            this.callbacks = null;
            for (Map.Entry<ClientTransport.PingCallback, Executor> entry : map.entrySet()) {
                doExecute(entry.getValue(), asRunnable(entry.getKey(), jA));
            }
            return true;
        }
    }

    public void failed(Throwable th) {
        synchronized (this) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            this.failureCause = th;
            Map<ClientTransport.PingCallback, Executor> map = this.callbacks;
            this.callbacks = null;
            for (Map.Entry<ClientTransport.PingCallback, Executor> entry : map.entrySet()) {
                doExecute(entry.getValue(), asRunnable(entry.getKey(), th));
            }
        }
    }

    public long payload() {
        return this.data;
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final Throwable th) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.2
            @Override // java.lang.Runnable
            public void run() {
                pingCallback.onFailure(th);
            }
        };
    }
}
