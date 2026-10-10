package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.internal.BackoffPolicy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
final class ExponentialBackoffPolicy implements BackoffPolicy {
    private Random random = new Random();
    private long initialBackoffMillis = TimeUnit.SECONDS.toMillis(1);
    private long maxBackoffMillis = TimeUnit.MINUTES.toMillis(2);
    private double multiplier = 1.6d;
    private double jitter = 0.2d;
    private long nextBackoffMillis = this.initialBackoffMillis;

    static final class Provider implements BackoffPolicy.Provider {
        Provider() {
        }

        @Override // io.grpc.internal.BackoffPolicy.Provider
        public BackoffPolicy get() {
            return new ExponentialBackoffPolicy();
        }
    }

    ExponentialBackoffPolicy() {
    }

    private long uniformRandom(double d2, double d3) {
        m.a(d3 >= d2);
        return (long) ((this.random.nextDouble() * (d3 - d2)) + d2);
    }

    @Override // io.grpc.internal.BackoffPolicy
    public long nextBackoffMillis() {
        long j = this.nextBackoffMillis;
        double d2 = j;
        double d3 = this.multiplier;
        Double.isNaN(d2);
        this.nextBackoffMillis = Math.min((long) (d3 * d2), this.maxBackoffMillis);
        double d4 = this.jitter;
        Double.isNaN(d2);
        Double.isNaN(d2);
        return j + uniformRandom((-d4) * d2, d4 * d2);
    }

    ExponentialBackoffPolicy setInitialBackoffMillis(long j) {
        this.initialBackoffMillis = j;
        return this;
    }

    ExponentialBackoffPolicy setJitter(double d2) {
        this.jitter = d2;
        return this;
    }

    ExponentialBackoffPolicy setMaxBackoffMillis(long j) {
        this.maxBackoffMillis = j;
        return this;
    }

    ExponentialBackoffPolicy setMultiplier(double d2) {
        this.multiplier = d2;
        return this;
    }

    ExponentialBackoffPolicy setRandom(Random random) {
        this.random = random;
        return this;
    }
}
