package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class KeepAliveManager {
    private long keepAliveDelayInNanos;
    private long keepAliveTimeoutInNanos;
    private long nextKeepaliveTime;
    private ScheduledFuture<?> pingFuture;
    private final ScheduledExecutorService scheduler;
    private ScheduledFuture<?> shutdownFuture;
    private final Ticker ticker;
    private final ManagedClientTransport transport;
    private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
    private static final long MIN_KEEPALIVE_DELAY_NANOS = TimeUnit.MINUTES.toNanos(1);
    private State state = State.IDLE;
    private final Runnable shutdown = new Runnable() { // from class: io.grpc.internal.KeepAliveManager.1
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            synchronized (KeepAliveManager.this) {
                if (KeepAliveManager.this.state != State.DISCONNECTED) {
                    KeepAliveManager.this.state = State.DISCONNECTED;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                KeepAliveManager.this.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
            }
        }
    };
    private final Runnable sendPing = new Runnable() { // from class: io.grpc.internal.KeepAliveManager.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            synchronized (KeepAliveManager.this) {
                if (KeepAliveManager.this.state == State.PING_SCHEDULED) {
                    z = true;
                    KeepAliveManager.this.state = State.PING_SENT;
                    KeepAliveManager.this.shutdownFuture = KeepAliveManager.this.scheduler.schedule(KeepAliveManager.this.shutdown, KeepAliveManager.this.keepAliveTimeoutInNanos, TimeUnit.NANOSECONDS);
                } else {
                    if (KeepAliveManager.this.state == State.PING_DELAYED) {
                        KeepAliveManager.this.pingFuture = KeepAliveManager.this.scheduler.schedule(KeepAliveManager.this.sendPing, KeepAliveManager.this.nextKeepaliveTime - KeepAliveManager.this.ticker.read(), TimeUnit.NANOSECONDS);
                        KeepAliveManager.this.state = State.PING_SCHEDULED;
                    }
                    z = false;
                }
            }
            if (z) {
                KeepAliveManager.this.transport.ping(KeepAliveManager.this.pingCallback, MoreExecutors.a());
            }
        }
    };
    private final KeepAlivePingCallback pingCallback = new KeepAlivePingCallback();

    private class KeepAlivePingCallback implements ClientTransport.PingCallback {
        private KeepAlivePingCallback() {
        }

        @Override // io.grpc.internal.ClientTransport.PingCallback
        public void onFailure(Throwable th) {
            synchronized (KeepAliveManager.this) {
                KeepAliveManager.this.shutdownFuture.cancel(false);
            }
            KeepAliveManager.this.shutdown.run();
        }

        @Override // io.grpc.internal.ClientTransport.PingCallback
        public void onSuccess(long j) {
            synchronized (KeepAliveManager.this) {
                KeepAliveManager.this.shutdownFuture.cancel(false);
                KeepAliveManager.this.nextKeepaliveTime = KeepAliveManager.this.ticker.read() + KeepAliveManager.this.keepAliveDelayInNanos;
                if (KeepAliveManager.this.state == State.PING_SENT) {
                    KeepAliveManager.this.pingFuture = KeepAliveManager.this.scheduler.schedule(KeepAliveManager.this.sendPing, KeepAliveManager.this.keepAliveDelayInNanos, TimeUnit.NANOSECONDS);
                    KeepAliveManager.this.state = State.PING_SCHEDULED;
                }
                if (KeepAliveManager.this.state == State.IDLE_AND_PING_SENT) {
                    KeepAliveManager.this.state = State.IDLE;
                }
            }
        }
    }

    private enum State {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    private static class SystemTicker extends Ticker {
        private SystemTicker() {
        }

        @Override // io.grpc.internal.KeepAliveManager.Ticker
        public long read() {
            return System.nanoTime();
        }
    }

    static abstract class Ticker {
        Ticker() {
        }

        public abstract long read();
    }

    public KeepAliveManager(ManagedClientTransport managedClientTransport, ScheduledExecutorService scheduledExecutorService, long j, long j2) {
        m.a(managedClientTransport, "transport");
        this.transport = managedClientTransport;
        m.a(scheduledExecutorService, "scheduler");
        this.scheduler = scheduledExecutorService;
        this.ticker = SYSTEM_TICKER;
        this.keepAliveDelayInNanos = Math.max(MIN_KEEPALIVE_DELAY_NANOS, j);
        this.keepAliveTimeoutInNanos = j2;
        this.nextKeepaliveTime = this.ticker.read() + j;
    }

    public synchronized void onDataReceived() {
        this.nextKeepaliveTime = this.ticker.read() + this.keepAliveDelayInNanos;
        if (this.state == State.PING_SCHEDULED) {
            this.state = State.PING_DELAYED;
        }
    }

    public synchronized void onTransportActive() {
        if (this.state == State.IDLE) {
            this.state = State.PING_SCHEDULED;
            this.pingFuture = this.scheduler.schedule(this.sendPing, this.nextKeepaliveTime - this.ticker.read(), TimeUnit.NANOSECONDS);
        }
    }

    public synchronized void onTransportIdle() {
        if (this.state == State.PING_SCHEDULED || this.state == State.PING_DELAYED) {
            this.state = State.IDLE;
        }
        if (this.state == State.PING_SENT) {
            this.state = State.IDLE_AND_PING_SENT;
        }
    }

    public synchronized void onTransportShutdown() {
        if (this.state != State.DISCONNECTED) {
            this.state = State.DISCONNECTED;
            if (this.shutdownFuture != null) {
                this.shutdownFuture.cancel(false);
            }
            if (this.pingFuture != null) {
                this.pingFuture.cancel(false);
            }
        }
    }

    KeepAliveManager(ManagedClientTransport managedClientTransport, ScheduledExecutorService scheduledExecutorService, Ticker ticker, long j, long j2) {
        m.a(managedClientTransport, "transport");
        this.transport = managedClientTransport;
        m.a(scheduledExecutorService, "scheduler");
        this.scheduler = scheduledExecutorService;
        m.a(ticker, "ticker");
        this.ticker = ticker;
        this.keepAliveDelayInNanos = j;
        this.keepAliveTimeoutInNanos = j2;
        this.nextKeepaliveTime = ticker.read() + j;
    }
}
