package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.x;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Dispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f5276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f5277d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5274a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5275b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<x.a> f5278e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Deque<x.a> f5279f = new ArrayDeque();
    private final Deque<x> g = new ArrayDeque();

    private int b(x.a aVar) {
        Iterator<x.a> it = this.f5279f.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().a().equals(aVar.a())) {
                i++;
            }
        }
        return i;
    }

    private void c() {
        if (this.f5279f.size() < this.f5274a && !this.f5278e.isEmpty()) {
            Iterator<x.a> it = this.f5278e.iterator();
            while (it.hasNext()) {
                x.a next = it.next();
                if (b(next) < this.f5275b) {
                    it.remove();
                    this.f5279f.add(next);
                    a().execute(next);
                }
                if (this.f5279f.size() >= this.f5274a) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService a() {
        if (this.f5277d == null) {
            this.f5277d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.a("OkHttp Dispatcher", false));
        }
        return this.f5277d;
    }

    void b(x xVar) {
        a(this.g, xVar, false);
    }

    public synchronized int b() {
        return this.f5279f.size() + this.g.size();
    }

    synchronized void a(x xVar) {
        this.g.add(xVar);
    }

    void a(x.a aVar) {
        a(this.f5279f, aVar, true);
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int iB;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    c();
                }
                iB = b();
                runnable = this.f5276c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (iB != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
