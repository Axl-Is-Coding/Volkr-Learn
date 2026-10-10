package io.reactivex.internal.observers;

import io.reactivex.w;

/* JADX INFO: compiled from: QueueDrainObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class j<T, U, V> extends l implements w<T>, io.reactivex.internal.util.h<U, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final w<? super V> f21856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final io.reactivex.c.a.j<U> f21857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile boolean f21858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected volatile boolean f21859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Throwable f21860f;

    public j(w<? super V> wVar, io.reactivex.c.a.j<U> jVar) {
        this.f21856b = wVar;
        this.f21857c = jVar;
    }

    @Override // io.reactivex.internal.util.h
    public void a(w<? super V> wVar, U u) {
    }

    @Override // io.reactivex.internal.util.h
    public final boolean a() {
        return this.f21858d;
    }

    public final boolean b() {
        return this.f21861a.getAndIncrement() == 0;
    }

    public final boolean c() {
        return this.f21861a.get() == 0 && this.f21861a.compareAndSet(0, 1);
    }

    @Override // io.reactivex.internal.util.h
    public final boolean done() {
        return this.f21859e;
    }

    @Override // io.reactivex.internal.util.h
    public final Throwable error() {
        return this.f21860f;
    }

    protected final void a(U u, boolean z, io.reactivex.disposables.b bVar) {
        w<? super V> wVar = this.f21856b;
        io.reactivex.c.a.j<U> jVar = this.f21857c;
        if (this.f21861a.get() == 0 && this.f21861a.compareAndSet(0, 1)) {
            a(wVar, u);
            if (a(-1) == 0) {
                return;
            }
        } else {
            jVar.offer(u);
            if (!b()) {
                return;
            }
        }
        io.reactivex.internal.util.k.a(jVar, wVar, z, bVar, this);
    }

    protected final void b(U u, boolean z, io.reactivex.disposables.b bVar) {
        w<? super V> wVar = this.f21856b;
        io.reactivex.c.a.j<U> jVar = this.f21857c;
        if (this.f21861a.get() != 0 || !this.f21861a.compareAndSet(0, 1)) {
            jVar.offer(u);
            if (!b()) {
                return;
            }
        } else if (jVar.isEmpty()) {
            a(wVar, u);
            if (a(-1) == 0) {
                return;
            }
        } else {
            jVar.offer(u);
        }
        io.reactivex.internal.util.k.a(jVar, wVar, z, bVar, this);
    }

    @Override // io.reactivex.internal.util.h
    public final int a(int i) {
        return this.f21861a.addAndGet(i);
    }
}
