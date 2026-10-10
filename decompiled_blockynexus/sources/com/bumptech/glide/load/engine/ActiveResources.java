package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.w;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
final class ActiveResources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f4401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<com.bumptech.glide.load.h, b> f4402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<w<?>> f4403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private w.a f4404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f4405f;
    private volatile a g;

    interface a {
        void a();
    }

    static final class b extends WeakReference<w<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.h f4406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f4407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        C<?> f4408c;

        b(com.bumptech.glide.load.h hVar, w<?> wVar, ReferenceQueue<? super w<?>> referenceQueue, boolean z) {
            C<?> c2;
            super(wVar, referenceQueue);
            com.bumptech.glide.e.l.a(hVar);
            this.f4406a = hVar;
            if (wVar.d() && z) {
                C<?> c3 = wVar.c();
                com.bumptech.glide.e.l.a(c3);
                c2 = c3;
            } else {
                c2 = null;
            }
            this.f4408c = c2;
            this.f4407b = wVar.d();
        }

        void a() {
            this.f4408c = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0492b()));
    }

    void a(w.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f4404e = aVar;
            }
        }
    }

    synchronized w<?> b(com.bumptech.glide.load.h hVar) {
        b bVar = this.f4402c.get(hVar);
        if (bVar == null) {
            return null;
        }
        w<?> wVar = bVar.get();
        if (wVar == null) {
            a(bVar);
        }
        return wVar;
    }

    void setDequeuedResourceCallback(a aVar) {
        this.g = aVar;
    }

    ActiveResources(boolean z, Executor executor) {
        this.f4402c = new HashMap();
        this.f4403d = new ReferenceQueue<>();
        this.f4400a = z;
        this.f4401b = executor;
        executor.execute(new RunnableC0493c(this));
    }

    void b() {
        this.f4405f = true;
        Executor executor = this.f4401b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.e.g.a((ExecutorService) executor);
        }
    }

    synchronized void a(com.bumptech.glide.load.h hVar, w<?> wVar) {
        b bVarPut = this.f4402c.put(hVar, new b(hVar, wVar, this.f4403d, this.f4400a));
        if (bVarPut != null) {
            bVarPut.a();
        }
    }

    synchronized void a(com.bumptech.glide.load.h hVar) {
        b bVarRemove = this.f4402c.remove(hVar);
        if (bVarRemove != null) {
            bVarRemove.a();
        }
    }

    void a(b bVar) {
        synchronized (this) {
            this.f4402c.remove(bVar.f4406a);
            if (bVar.f4407b && bVar.f4408c != null) {
                this.f4404e.a(bVar.f4406a, new w<>(bVar.f4408c, true, false, bVar.f4406a, this.f4404e));
            }
        }
    }

    void a() {
        while (!this.f4405f) {
            try {
                a((b) this.f4403d.remove());
                a aVar = this.g;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
