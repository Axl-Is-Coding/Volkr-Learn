package io.grpc;

import com.google.common.base.m;
import io.grpc.internal.LogExceptionRunnable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class Deadline implements Comparable<Deadline> {
    private final long deadlineNanos;
    private volatile boolean expired;
    private final Ticker ticker;
    private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
    private static final long MAX_OFFSET = TimeUnit.DAYS.toNanos(36500);
    private static final long MIN_OFFSET = -MAX_OFFSET;

    private static class SystemTicker extends Ticker {
        private SystemTicker() {
        }

        @Override // io.grpc.Deadline.Ticker
        public long read() {
            return System.nanoTime();
        }
    }

    static abstract class Ticker {
        Ticker() {
        }

        public abstract long read();
    }

    private Deadline(Ticker ticker, long j, boolean z) {
        this(ticker, ticker.read(), j, z);
    }

    public static Deadline after(long j, TimeUnit timeUnit) {
        return after(j, timeUnit, SYSTEM_TICKER);
    }

    public boolean isBefore(Deadline deadline) {
        return this.deadlineNanos - deadline.deadlineNanos < 0;
    }

    public boolean isExpired() {
        if (!this.expired) {
            if (this.deadlineNanos - this.ticker.read() > 0) {
                return false;
            }
            this.expired = true;
        }
        return true;
    }

    public Deadline minimum(Deadline deadline) {
        return isBefore(deadline) ? this : deadline;
    }

    public Deadline offset(long j, TimeUnit timeUnit) {
        return j == 0 ? this : new Deadline(this.ticker, this.deadlineNanos, timeUnit.toNanos(j), isExpired());
    }

    public ScheduledFuture<?> runOnExpiration(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        m.a(runnable, "task");
        m.a(scheduledExecutorService, "scheduler");
        return scheduledExecutorService.schedule(new LogExceptionRunnable(runnable), this.deadlineNanos - this.ticker.read(), TimeUnit.NANOSECONDS);
    }

    public long timeRemaining(TimeUnit timeUnit) {
        long j = this.ticker.read();
        if (!this.expired && this.deadlineNanos - j <= 0) {
            this.expired = true;
        }
        return timeUnit.convert(this.deadlineNanos - j, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        return timeRemaining(TimeUnit.NANOSECONDS) + " ns from now";
    }

    private Deadline(Ticker ticker, long j, long j2, boolean z) {
        this.ticker = ticker;
        long jMin = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, j2));
        this.deadlineNanos = j + jMin;
        this.expired = z && jMin <= 0;
    }

    static Deadline after(long j, TimeUnit timeUnit, Ticker ticker) {
        m.a(timeUnit);
        return new Deadline(ticker, timeUnit.toNanos(j), true);
    }

    @Override // java.lang.Comparable
    public int compareTo(Deadline deadline) {
        long j = this.deadlineNanos - deadline.deadlineNanos;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }
}
