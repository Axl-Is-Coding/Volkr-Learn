package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableReduceMaybe.java */
/* JADX INFO: loaded from: classes5.dex */
public final class fa<T> extends io.reactivex.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.c<T, T, T> f22404b;

    /* JADX INFO: compiled from: ObservableReduceMaybe.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.k<? super T> f22405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.c<T, T, T> f22406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f22408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        io.reactivex.disposables.b f22409e;

        a(io.reactivex.k<? super T> kVar, io.reactivex.b.c<T, T, T> cVar) {
            this.f22405a = kVar;
            this.f22406b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22409e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22409e.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22407c) {
                return;
            }
            this.f22407c = true;
            T t = this.f22408d;
            this.f22408d = null;
            if (t != null) {
                this.f22405a.onSuccess(t);
            } else {
                this.f22405a.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22407c) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.f22407c = true;
            this.f22408d = null;
            this.f22405a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22407c) {
                return;
            }
            T t2 = this.f22408d;
            if (t2 == null) {
                this.f22408d = t;
                return;
            }
            try {
                T tApply = this.f22406b.apply(t2, t);
                io.reactivex.internal.functions.a.a((Object) tApply, "The reducer returned a null value");
                this.f22408d = tApply;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22409e.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22409e, bVar)) {
                this.f22409e = bVar;
                this.f22405a.onSubscribe(this);
            }
        }
    }

    public fa(io.reactivex.u<T> uVar, io.reactivex.b.c<T, T, T> cVar) {
        this.f22403a = uVar;
        this.f22404b = cVar;
    }

    @Override // io.reactivex.i
    protected void b(io.reactivex.k<? super T> kVar) {
        this.f22403a.subscribe(new a(kVar, this.f22404b));
    }
}
