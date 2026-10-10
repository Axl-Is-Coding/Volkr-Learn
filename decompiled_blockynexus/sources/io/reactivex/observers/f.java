package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.w;

/* JADX INFO: compiled from: SerializedObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f<T> implements w<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w<? super T> f22749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f22750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    io.reactivex.disposables.b f22751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f22752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    io.reactivex.internal.util.a<Object> f22753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f22754f;

    public f(w<? super T> wVar) {
        this(wVar, false);
    }

    void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f22753e;
                if (aVar == null) {
                    this.f22752d = false;
                    return;
                }
                this.f22753e = null;
            }
        } while (!aVar.a((w) this.f22749a));
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f22751c.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f22751c.isDisposed();
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (this.f22754f) {
            return;
        }
        synchronized (this) {
            if (this.f22754f) {
                return;
            }
            if (!this.f22752d) {
                this.f22754f = true;
                this.f22752d = true;
                this.f22749a.onComplete();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f22753e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f22753e = aVar;
                }
                aVar.a(NotificationLite.complete());
            }
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        if (this.f22754f) {
            io.reactivex.e.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f22754f) {
                if (this.f22752d) {
                    this.f22754f = true;
                    io.reactivex.internal.util.a<Object> aVar = this.f22753e;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f22753e = aVar;
                    }
                    Object objError = NotificationLite.error(th);
                    if (this.f22750b) {
                        aVar.a(objError);
                    } else {
                        aVar.b(objError);
                    }
                    return;
                }
                this.f22754f = true;
                this.f22752d = true;
                z = false;
            }
            if (z) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22749a.onError(th);
            }
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (this.f22754f) {
            return;
        }
        if (t == null) {
            this.f22751c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f22754f) {
                return;
            }
            if (!this.f22752d) {
                this.f22752d = true;
                this.f22749a.onNext(t);
                a();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f22753e;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f22753e = aVar;
                }
                NotificationLite.next(t);
                aVar.a(t);
            }
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f22751c, bVar)) {
            this.f22751c = bVar;
            this.f22749a.onSubscribe(this);
        }
    }

    public f(w<? super T> wVar, boolean z) {
        this.f22749a = wVar;
        this.f22750b = z;
    }
}
