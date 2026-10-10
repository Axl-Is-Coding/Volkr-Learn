package com.alibaba.mtl.appmonitor.c;

import com.alibaba.mtl.appmonitor.c.b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ReuseItemPool.java */
/* JADX INFO: loaded from: classes.dex */
public class c<T extends b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicLong f3579c = new AtomicLong(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicLong f3580d = new AtomicLong(0);
    private final int m = 20;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f3582b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private AtomicLong f46a = new AtomicLong(0);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private AtomicLong f48b = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<T> f3581a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Set<Integer> f47b = new HashSet();

    public T a() {
        f3579c.getAndIncrement();
        this.f46a.getAndIncrement();
        T tPoll = this.f3581a.poll();
        if (tPoll != null) {
            this.f47b.remove(Integer.valueOf(System.identityHashCode(tPoll)));
            this.f48b.getAndIncrement();
            f3580d.getAndIncrement();
        }
        return tPoll;
    }

    public void a(T t) {
        t.clean();
        if (this.f3581a.size() < 20) {
            synchronized (this.f47b) {
                int iIdentityHashCode = System.identityHashCode(t);
                if (!this.f47b.contains(Integer.valueOf(iIdentityHashCode))) {
                    this.f47b.add(Integer.valueOf(iIdentityHashCode));
                    this.f3581a.offer(t);
                }
            }
        }
    }
}
