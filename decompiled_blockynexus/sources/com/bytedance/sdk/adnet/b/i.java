package com.bytedance.sdk.adnet.b;

import android.os.SystemClock;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: RequestFuture.java */
/* JADX INFO: loaded from: classes.dex */
public class i<T> implements m.a<T>, Future<m<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Request<?> f5434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5435b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m<T> f5436c;

    private i() {
    }

    public static <E> i<E> a() {
        return new i<>();
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m<T> get() throws InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f5434a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f5434a.cancel();
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.f5434a;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f5435b     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto Le
            boolean r0 = r1.isCancelled()     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            monitor-exit(r1)
            return r0
        L11:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.b.i.isDone():boolean");
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public m<T> get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized m<T> a(Long l) throws InterruptedException, TimeoutException {
        if (this.f5435b) {
            return this.f5436c;
        }
        if (l == null) {
            while (!isDone()) {
                wait(0L);
            }
        } else if (l.longValue() > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jLongValue = l.longValue() + jUptimeMillis;
            while (!isDone() && jUptimeMillis < jLongValue) {
                wait(jLongValue - jUptimeMillis);
                jUptimeMillis = SystemClock.uptimeMillis();
            }
        }
        if (this.f5435b) {
            return this.f5436c;
        }
        throw new TimeoutException();
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public synchronized void b(m<T> mVar) {
        this.f5435b = true;
        this.f5436c = mVar;
        notifyAll();
    }

    @Override // com.bytedance.sdk.adnet.core.m.a
    public synchronized void a(m<T> mVar) {
        this.f5435b = true;
        this.f5436c = mVar;
        notifyAll();
    }
}
