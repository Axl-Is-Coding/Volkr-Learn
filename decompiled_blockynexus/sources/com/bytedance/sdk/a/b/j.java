package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.b.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ConnectionPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f5250c = !j.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Executor f5251d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.a("OkHttp ConnectionPool", true));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.bytedance.sdk.a.b.a.b.d f5252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f5253b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f5255f;
    private final Runnable g;
    private final Deque<com.bytedance.sdk.a.b.a.b.c> h;

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    com.bytedance.sdk.a.b.a.b.c a(a aVar, com.bytedance.sdk.a.b.a.b.g gVar, ac acVar) {
        if (!f5250c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.a.b.a.b.c cVar : this.h) {
            if (cVar.a(aVar, acVar)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    boolean b(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (!f5250c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (cVar.f4941a || this.f5254e == 0) {
            this.h.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public j(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() { // from class: com.bytedance.sdk.a.b.j.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jA = j.this.a(System.nanoTime());
                    if (jA == -1) {
                        return;
                    }
                    if (jA > 0) {
                        long j2 = jA / 1000000;
                        long j3 = jA - (1000000 * j2);
                        synchronized (j.this) {
                            try {
                                j.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.h = new ArrayDeque();
        this.f5252a = new com.bytedance.sdk.a.b.a.b.d();
        this.f5254e = i;
        this.f5255f = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    Socket a(a aVar, com.bytedance.sdk.a.b.a.b.g gVar) {
        if (!f5250c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.a.b.a.b.c cVar : this.h) {
            if (cVar.a(aVar, null) && cVar.d() && cVar != gVar.b()) {
                return gVar.a(cVar);
            }
        }
        return null;
    }

    void a(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (!f5250c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f5253b) {
            this.f5253b = true;
            f5251d.execute(this.g);
        }
        this.h.add(cVar);
    }

    long a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            com.bytedance.sdk.a.b.a.b.c cVar = null;
            int i = 0;
            int i2 = 0;
            for (com.bytedance.sdk.a.b.a.b.c cVar2 : this.h) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.f4945e;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f5255f && i <= this.f5254e) {
                if (i > 0) {
                    return this.f5255f - j2;
                }
                if (i2 > 0) {
                    return this.f5255f;
                }
                this.f5253b = false;
                return -1L;
            }
            this.h.remove(cVar);
            com.bytedance.sdk.a.b.a.c.a(cVar.b());
            return 0L;
        }
    }

    private int a(com.bytedance.sdk.a.b.a.b.c cVar, long j) {
        List<Reference<com.bytedance.sdk.a.b.a.b.g>> list = cVar.f4944d;
        int i = 0;
        while (i < list.size()) {
            Reference<com.bytedance.sdk.a.b.a.b.g> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.bytedance.sdk.a.b.a.g.e.b().a("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f4963a);
                list.remove(i);
                cVar.f4941a = true;
                if (list.isEmpty()) {
                    cVar.f4945e = j - this.f5255f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
