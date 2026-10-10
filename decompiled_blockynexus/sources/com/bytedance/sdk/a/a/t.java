package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Timeout.java */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f4893c = new t() { // from class: com.bytedance.sdk.a.a.t.1
        @Override // com.bytedance.sdk.a.a.t
        public t a(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public t a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.a.a.t
        public void g() throws IOException {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4895b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4896d;

    public t a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f4896d = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long b_() {
        return this.f4896d;
    }

    public boolean c() {
        return this.f4894a;
    }

    public long c_() {
        if (this.f4894a) {
            return this.f4895b;
        }
        throw new IllegalStateException("No deadline");
    }

    public t e() {
        this.f4896d = 0L;
        return this;
    }

    public t f() {
        this.f4894a = false;
        return this;
    }

    public void g() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f4894a && this.f4895b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public t a(long j) {
        this.f4894a = true;
        this.f4895b = j;
        return this;
    }
}
