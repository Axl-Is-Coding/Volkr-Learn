package io.reactivex.g;

import f.b.c;
import f.b.d;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: compiled from: SerializedSubscriber.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a<T> implements h<T>, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c<? super T> f21794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f21795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f21796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f21797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    io.reactivex.internal.util.a<Object> f21798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f21799f;

    public a(c<? super T> cVar) {
        this(cVar, false);
    }

    void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f21798e;
                if (aVar == null) {
                    this.f21797d = false;
                    return;
                }
                this.f21798e = null;
            }
        } while (!aVar.a((c) this.f21794a));
    }

    @Override // f.b.d
    public void cancel() {
        this.f21796c.cancel();
    }

    @Override // f.b.c
    public void onComplete() {
        if (this.f21799f) {
            return;
        }
        synchronized (this) {
            if (this.f21799f) {
                return;
            }
            if (!this.f21797d) {
                this.f21799f = true;
                this.f21797d = true;
                this.f21794a.onComplete();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f21798e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f21798e = aVar;
                }
                aVar.a(NotificationLite.complete());
            }
        }
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        if (this.f21799f) {
            io.reactivex.e.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f21799f) {
                if (this.f21797d) {
                    this.f21799f = true;
                    io.reactivex.internal.util.a<Object> aVar = this.f21798e;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f21798e = aVar;
                    }
                    Object objError = NotificationLite.error(th);
                    if (this.f21795b) {
                        aVar.a(objError);
                    } else {
                        aVar.b(objError);
                    }
                    return;
                }
                this.f21799f = true;
                this.f21797d = true;
                z = false;
            }
            if (z) {
                io.reactivex.e.a.b(th);
            } else {
                this.f21794a.onError(th);
            }
        }
    }

    @Override // f.b.c
    public void onNext(T t) {
        if (this.f21799f) {
            return;
        }
        if (t == null) {
            this.f21796c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f21799f) {
                return;
            }
            if (!this.f21797d) {
                this.f21797d = true;
                this.f21794a.onNext(t);
                a();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f21798e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f21798e = aVar;
                }
                NotificationLite.next(t);
                aVar.a(t);
            }
        }
    }

    @Override // io.reactivex.h, f.b.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.f21796c, dVar)) {
            this.f21796c = dVar;
            this.f21794a.onSubscribe(this);
        }
    }

    @Override // f.b.d
    public void request(long j) {
        this.f21796c.request(j);
    }

    public a(c<? super T> cVar, boolean z) {
        this.f21794a = cVar;
        this.f21795b = z;
    }
}
