package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableElementAtSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class D<T> extends io.reactivex.y<T> implements io.reactivex.c.a.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final T f22015c;

    /* JADX INFO: compiled from: ObservableElementAtSingle.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super T> f22016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f22017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final T f22018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f22019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f22020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f22021f;

        a(io.reactivex.z<? super T> zVar, long j, T t) {
            this.f22016a = zVar;
            this.f22017b = j;
            this.f22018c = t;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22019d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22019d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22021f) {
                return;
            }
            this.f22021f = true;
            T t = this.f22018c;
            if (t != null) {
                this.f22016a.onSuccess(t);
            } else {
                this.f22016a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22021f) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22021f = true;
                this.f22016a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22021f) {
                return;
            }
            long j = this.f22020e;
            if (j != this.f22017b) {
                this.f22020e = j + 1;
                return;
            }
            this.f22021f = true;
            this.f22019d.dispose();
            this.f22016a.onSuccess(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22019d, bVar)) {
                this.f22019d = bVar;
                this.f22016a.onSubscribe(this);
            }
        }
    }

    public D(io.reactivex.u<T> uVar, long j, T t) {
        this.f22013a = uVar;
        this.f22014b = j;
        this.f22015c = t;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<T> a() {
        return io.reactivex.e.a.a(new B(this.f22013a, this.f22014b, this.f22015c, true));
    }

    @Override // io.reactivex.y
    public void b(io.reactivex.z<? super T> zVar) {
        this.f22013a.subscribe(new a(zVar, this.f22014b, this.f22015c));
    }
}
