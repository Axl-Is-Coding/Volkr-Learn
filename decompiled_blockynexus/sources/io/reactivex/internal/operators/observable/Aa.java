package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* JADX INFO: compiled from: ObservableZipIterable.java */
/* JADX INFO: loaded from: classes5.dex */
public final class Aa<T, U, V> extends io.reactivex.p<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.p<? extends T> f21987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<U> f21988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.c<? super T, ? super U, ? extends V> f21989c;

    /* JADX INFO: compiled from: ObservableZipIterable.java */
    static final class a<T, U, V> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super V> f21990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator<U> f21991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final io.reactivex.b.c<? super T, ? super U, ? extends V> f21992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f21993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f21994e;

        a(io.reactivex.w<? super V> wVar, Iterator<U> it, io.reactivex.b.c<? super T, ? super U, ? extends V> cVar) {
            this.f21990a = wVar;
            this.f21991b = it;
            this.f21992c = cVar;
        }

        void a(Throwable th) {
            this.f21994e = true;
            this.f21993d.dispose();
            this.f21990a.onError(th);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f21993d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21993d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f21994e) {
                return;
            }
            this.f21994e = true;
            this.f21990a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f21994e) {
                io.reactivex.e.a.b(th);
            } else {
                this.f21994e = true;
                this.f21990a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f21994e) {
                return;
            }
            try {
                U next = this.f21991b.next();
                io.reactivex.internal.functions.a.a(next, "The iterator returned a null value");
                try {
                    V vApply = this.f21992c.apply(t, next);
                    io.reactivex.internal.functions.a.a(vApply, "The zipper function returned a null value");
                    this.f21990a.onNext(vApply);
                    try {
                        if (this.f21991b.hasNext()) {
                            return;
                        }
                        this.f21994e = true;
                        this.f21993d.dispose();
                        this.f21990a.onComplete();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        a(th);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    a(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                a(th3);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f21993d, bVar)) {
                this.f21993d = bVar;
                this.f21990a.onSubscribe(this);
            }
        }
    }

    public Aa(io.reactivex.p<? extends T> pVar, Iterable<U> iterable, io.reactivex.b.c<? super T, ? super U, ? extends V> cVar) {
        this.f21987a = pVar;
        this.f21988b = iterable;
        this.f21989c = cVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super V> wVar) {
        try {
            Iterator<U> it = this.f21988b.iterator();
            io.reactivex.internal.functions.a.a(it, "The iterator returned by other is null");
            Iterator<U> it2 = it;
            try {
                if (it2.hasNext()) {
                    this.f21987a.subscribe(new a(wVar, it2, this.f21989c));
                } else {
                    EmptyDisposable.complete(wVar);
                }
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
