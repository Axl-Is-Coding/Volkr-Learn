package io.reactivex.processors;

import f.b.c;
import f.b.d;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: compiled from: SerializedProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
final class b<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a<T> f22764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f22765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    io.reactivex.internal.util.a<Object> f22766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile boolean f22767e;

    b(a<T> aVar) {
        this.f22764b = aVar;
    }

    @Override // io.reactivex.e
    protected void b(c<? super T> cVar) {
        this.f22764b.a((c) cVar);
    }

    void i() {
        io.reactivex.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f22766d;
                if (aVar == null) {
                    this.f22765c = false;
                    return;
                }
                this.f22766d = null;
            }
            aVar.a((c) this.f22764b);
        }
    }

    @Override // f.b.c
    public void onComplete() {
        if (this.f22767e) {
            return;
        }
        synchronized (this) {
            if (this.f22767e) {
                return;
            }
            this.f22767e = true;
            if (!this.f22765c) {
                this.f22765c = true;
                this.f22764b.onComplete();
                return;
            }
            io.reactivex.internal.util.a<Object> aVar = this.f22766d;
            if (aVar == null) {
                aVar = new io.reactivex.internal.util.a<>(4);
                this.f22766d = aVar;
            }
            aVar.a(NotificationLite.complete());
        }
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        boolean z;
        if (this.f22767e) {
            io.reactivex.e.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f22767e) {
                z = true;
            } else {
                this.f22767e = true;
                if (this.f22765c) {
                    io.reactivex.internal.util.a<Object> aVar = this.f22766d;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f22766d = aVar;
                    }
                    aVar.b(NotificationLite.error(th));
                    return;
                }
                z = false;
                this.f22765c = true;
            }
            if (z) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22764b.onError(th);
            }
        }
    }

    @Override // f.b.c
    public void onNext(T t) {
        if (this.f22767e) {
            return;
        }
        synchronized (this) {
            if (this.f22767e) {
                return;
            }
            if (!this.f22765c) {
                this.f22765c = true;
                this.f22764b.onNext(t);
                i();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f22766d;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f22766d = aVar;
                }
                NotificationLite.next(t);
                aVar.a(t);
            }
        }
    }

    @Override // f.b.c
    public void onSubscribe(d dVar) {
        boolean z = true;
        if (!this.f22767e) {
            synchronized (this) {
                if (!this.f22767e) {
                    if (this.f22765c) {
                        io.reactivex.internal.util.a<Object> aVar = this.f22766d;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.f22766d = aVar;
                        }
                        aVar.a(NotificationLite.subscription(dVar));
                        return;
                    }
                    this.f22765c = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.cancel();
        } else {
            this.f22764b.onSubscribe(dVar);
            i();
        }
    }
}
