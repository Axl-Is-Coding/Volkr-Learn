package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableSingleMaybe.java */
/* JADX INFO: loaded from: classes5.dex */
public final class la<T> extends io.reactivex.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22460a;

    /* JADX INFO: compiled from: ObservableSingleMaybe.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.k<? super T> f22461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f22463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22464d;

        a(io.reactivex.k<? super T> kVar) {
            this.f22461a = kVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22462b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22462b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22464d) {
                return;
            }
            this.f22464d = true;
            T t = this.f22463c;
            this.f22463c = null;
            if (t == null) {
                this.f22461a.onComplete();
            } else {
                this.f22461a.onSuccess(t);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22464d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22464d = true;
                this.f22461a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22464d) {
                return;
            }
            if (this.f22463c == null) {
                this.f22463c = t;
                return;
            }
            this.f22464d = true;
            this.f22462b.dispose();
            this.f22461a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22462b, bVar)) {
                this.f22462b = bVar;
                this.f22461a.onSubscribe(this);
            }
        }
    }

    public la(io.reactivex.u<T> uVar) {
        this.f22460a = uVar;
    }

    @Override // io.reactivex.i
    public void b(io.reactivex.k<? super T> kVar) {
        this.f22460a.subscribe(new a(kVar));
    }
}
