package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.n;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class RequestFutureTarget<R> implements c<R>, e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4775a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f4779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private R f4780f;
    private d g;
    private boolean h;
    private boolean i;
    private boolean j;
    private GlideException k;

    static class a {
        a() {
        }

        void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        void a(Object obj) {
            obj.notifyAll();
        }
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, f4775a);
    }

    private synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f4778d && !isDone()) {
            n.a();
        }
        if (this.h) {
            throw new CancellationException();
        }
        if (this.j) {
            throw new ExecutionException(this.k);
        }
        if (this.i) {
            return this.f4780f;
        }
        if (l == null) {
            this.f4779e.a(this, 0L);
        } else if (l.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                this.f4779e.a(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.j) {
            throw new ExecutionException(this.k);
        }
        if (this.h) {
            throw new CancellationException();
        }
        if (!this.i) {
            throw new TimeoutException();
        }
        return this.f4780f;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        d dVar;
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.h = true;
            this.f4779e.a(this);
            if (z) {
                dVar = this.g;
                this.g = null;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return a(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized d getRequest() {
        return this.g;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(com.bumptech.glide.request.target.h hVar) {
        hVar.a(this.f4776b, this.f4777c);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.h     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.i     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.j     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto Le
            goto L10
        Le:
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            monitor-exit(r1)
            return r0
        L13:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.isDone():boolean");
    }

    @Override // com.bumptech.glide.manager.j
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(R r, com.bumptech.glide.request.a.b<? super R> bVar) {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(com.bumptech.glide.request.target.h hVar) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void setRequest(d dVar) {
        this.g = dVar;
    }

    RequestFutureTarget(int i, int i2, boolean z, a aVar) {
        this.f4776b = i;
        this.f4777c = i2;
        this.f4778d = z;
        this.f4779e = aVar;
    }

    @Override // com.bumptech.glide.request.e
    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.j = true;
        this.k = glideException;
        this.f4779e.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.e
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.i = true;
        this.f4780f = r;
        this.f4779e.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j)));
    }
}
