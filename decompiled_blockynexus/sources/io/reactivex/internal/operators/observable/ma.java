package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableSingleSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ma<T> extends io.reactivex.y<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f22473b;

    /* JADX INFO: compiled from: ObservableSingleSingle.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super T> f22474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f22475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f22477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22478e;

        a(io.reactivex.z<? super T> zVar, T t) {
            this.f22474a = zVar;
            this.f22475b = t;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22476c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22476c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22478e) {
                return;
            }
            this.f22478e = true;
            T t = this.f22477d;
            this.f22477d = null;
            if (t == null) {
                t = this.f22475b;
            }
            if (t != null) {
                this.f22474a.onSuccess(t);
            } else {
                this.f22474a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22478e) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22478e = true;
                this.f22474a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22478e) {
                return;
            }
            if (this.f22477d == null) {
                this.f22477d = t;
                return;
            }
            this.f22478e = true;
            this.f22476c.dispose();
            this.f22474a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22476c, bVar)) {
                this.f22476c = bVar;
                this.f22474a.onSubscribe(this);
            }
        }
    }

    public ma(io.reactivex.u<? extends T> uVar, T t) {
        this.f22472a = uVar;
        this.f22473b = t;
    }

    @Override // io.reactivex.y
    public void b(io.reactivex.z<? super T> zVar) {
        this.f22472a.subscribe(new a(zVar, this.f22473b));
    }
}
