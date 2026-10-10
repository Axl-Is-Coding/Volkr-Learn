package com.bytedance.sdk.a.b.a.e;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: Ping.java */
/* JADX INFO: loaded from: classes.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f5146a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5147b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5148c = -1;

    l() {
    }

    void a() {
        if (this.f5147b != -1) {
            throw new IllegalStateException();
        }
        this.f5147b = System.nanoTime();
    }

    void b() {
        if (this.f5148c != -1 || this.f5147b == -1) {
            throw new IllegalStateException();
        }
        this.f5148c = System.nanoTime();
        this.f5146a.countDown();
    }

    void c() {
        if (this.f5148c == -1) {
            long j = this.f5147b;
            if (j != -1) {
                this.f5148c = j - 1;
                this.f5146a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
