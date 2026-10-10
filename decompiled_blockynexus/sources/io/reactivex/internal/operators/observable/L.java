package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* JADX INFO: compiled from: ObservableFromIterable.java */
/* JADX INFO: loaded from: classes5.dex */
public final class L<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable<? extends T> f22040a;

    /* JADX INFO: compiled from: ObservableFromIterable.java */
    static final class a<T> extends io.reactivex.internal.observers.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator<? extends T> f22042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f22043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f22046f;

        a(io.reactivex.w<? super T> wVar, Iterator<? extends T> it) {
            this.f22041a = wVar;
            this.f22042b = it;
        }

        void a() {
            while (!isDisposed()) {
                try {
                    T next = this.f22042b.next();
                    io.reactivex.internal.functions.a.a((Object) next, "The iterator returned a null value");
                    this.f22041a.onNext(next);
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f22042b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f22041a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f22041a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f22041a.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.f22045e = true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22043c = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22043c;
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.f22045e;
        }

        @Override // io.reactivex.c.a.k
        public T poll() {
            if (this.f22045e) {
                return null;
            }
            if (!this.f22046f) {
                this.f22046f = true;
            } else if (!this.f22042b.hasNext()) {
                this.f22045e = true;
                return null;
            }
            T next = this.f22042b.next();
            io.reactivex.internal.functions.a.a((Object) next, "The iterator returned a null value");
            return next;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f22044d = true;
            return 1;
        }
    }

    public L(Iterable<? extends T> iterable) {
        this.f22040a = iterable;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        try {
            Iterator<? extends T> it = this.f22040a.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(wVar);
                    return;
                }
                a aVar = new a(wVar, it);
                wVar.onSubscribe(aVar);
                if (aVar.f22044d) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                EmptyDisposable.error(th, wVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, wVar);
        }
    }
}
