package io.reactivex.internal.subscribers;

import f.b.d;
import io.reactivex.c.a.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: BasicFuseableConditionalSubscriber.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, R> implements io.reactivex.c.a.a<T>, h<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final io.reactivex.c.a.a<? super R> f22712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected d f22713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected h<T> f22714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f22715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f22716e;

    public a(io.reactivex.c.a.a<? super R> aVar) {
        this.f22712a = aVar;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f22713b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // f.b.d
    public void cancel() {
        this.f22713b.cancel();
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
        this.f22714c.clear();
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return this.f22714c.isEmpty();
    }

    @Override // io.reactivex.c.a.k
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // f.b.c
    public void onComplete() {
        if (this.f22715d) {
            return;
        }
        this.f22715d = true;
        this.f22712a.onComplete();
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        if (this.f22715d) {
            io.reactivex.e.a.b(th);
        } else {
            this.f22715d = true;
            this.f22712a.onError(th);
        }
    }

    @Override // io.reactivex.h, f.b.c
    public final void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.f22713b, dVar)) {
            this.f22713b = dVar;
            if (dVar instanceof h) {
                this.f22714c = (h) dVar;
            }
            if (b()) {
                this.f22712a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // f.b.d
    public void request(long j) {
        this.f22713b.request(j);
    }

    protected final int a(int i) {
        h<T> hVar = this.f22714c;
        if (hVar == null || (i & 4) != 0) {
            return 0;
        }
        int iRequestFusion = hVar.requestFusion(i);
        if (iRequestFusion != 0) {
            this.f22716e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
