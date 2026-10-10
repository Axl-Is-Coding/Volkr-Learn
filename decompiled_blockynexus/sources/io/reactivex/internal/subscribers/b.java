package io.reactivex.internal.subscribers;

import f.b.c;
import f.b.d;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: BasicFuseableSubscriber.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T, R> implements h<T>, io.reactivex.c.a.h<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c<? super R> f22717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected d f22718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected io.reactivex.c.a.h<T> f22719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f22720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f22721e;

    public b(c<? super R> cVar) {
        this.f22717a = cVar;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f22718b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // f.b.d
    public void cancel() {
        this.f22718b.cancel();
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
        this.f22719c.clear();
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return this.f22719c.isEmpty();
    }

    @Override // io.reactivex.c.a.k
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // f.b.c
    public void onComplete() {
        if (this.f22720d) {
            return;
        }
        this.f22720d = true;
        this.f22717a.onComplete();
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        if (this.f22720d) {
            io.reactivex.e.a.b(th);
        } else {
            this.f22720d = true;
            this.f22717a.onError(th);
        }
    }

    @Override // io.reactivex.h, f.b.c
    public final void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.f22718b, dVar)) {
            this.f22718b = dVar;
            if (dVar instanceof io.reactivex.c.a.h) {
                this.f22719c = (io.reactivex.c.a.h) dVar;
            }
            if (b()) {
                this.f22717a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // f.b.d
    public void request(long j) {
        this.f22718b.request(j);
    }

    protected final int a(int i) {
        io.reactivex.c.a.h<T> hVar = this.f22719c;
        if (hVar == null || (i & 4) != 0) {
            return 0;
        }
        int iRequestFusion = hVar.requestFusion(i);
        if (iRequestFusion != 0) {
            this.f22721e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
