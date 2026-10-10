package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import io.reactivex.w;

/* JADX INFO: compiled from: SerializedSubject.java */
/* JADX INFO: loaded from: classes5.dex */
final class a<T> extends b<T> implements a.InterfaceC0208a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b<T> f22783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f22784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    io.reactivex.internal.util.a<Object> f22785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f22786d;

    a(b<T> bVar) {
        this.f22783a = bVar;
    }

    void c() {
        io.reactivex.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f22785c;
                if (aVar == null) {
                    this.f22784b = false;
                    return;
                }
                this.f22785c = null;
            }
            aVar.a((a.InterfaceC0208a<? super Object>) this);
        }
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (this.f22786d) {
            return;
        }
        synchronized (this) {
            if (this.f22786d) {
                return;
            }
            this.f22786d = true;
            if (!this.f22784b) {
                this.f22784b = true;
                this.f22783a.onComplete();
                return;
            }
            io.reactivex.internal.util.a<Object> aVar = this.f22785c;
            if (aVar == null) {
                aVar = new io.reactivex.internal.util.a<>(4);
                this.f22785c = aVar;
            }
            aVar.a(NotificationLite.complete());
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        boolean z;
        if (this.f22786d) {
            io.reactivex.e.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f22786d) {
                z = true;
            } else {
                this.f22786d = true;
                if (this.f22784b) {
                    io.reactivex.internal.util.a<Object> aVar = this.f22785c;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.f22785c = aVar;
                    }
                    aVar.b(NotificationLite.error(th));
                    return;
                }
                z = false;
                this.f22784b = true;
            }
            if (z) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22783a.onError(th);
            }
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (this.f22786d) {
            return;
        }
        synchronized (this) {
            if (this.f22786d) {
                return;
            }
            if (!this.f22784b) {
                this.f22784b = true;
                this.f22783a.onNext(t);
                c();
            } else {
                io.reactivex.internal.util.a<Object> aVar = this.f22785c;
                if (aVar == null) {
                    aVar = new io.reactivex.internal.util.a<>(4);
                    this.f22785c = aVar;
                }
                NotificationLite.next(t);
                aVar.a(t);
            }
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        boolean z = true;
        if (!this.f22786d) {
            synchronized (this) {
                if (!this.f22786d) {
                    if (this.f22784b) {
                        io.reactivex.internal.util.a<Object> aVar = this.f22785c;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.f22785c = aVar;
                        }
                        aVar.a(NotificationLite.disposable(bVar));
                        return;
                    }
                    this.f22784b = true;
                    z = false;
                }
            }
        }
        if (z) {
            bVar.dispose();
        } else {
            this.f22783a.onSubscribe(bVar);
            c();
        }
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super T> wVar) {
        this.f22783a.subscribe(wVar);
    }

    @Override // io.reactivex.internal.util.a.InterfaceC0208a, io.reactivex.b.q
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f22783a);
    }
}
