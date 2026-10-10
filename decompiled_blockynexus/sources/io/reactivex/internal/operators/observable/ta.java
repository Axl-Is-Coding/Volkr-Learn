package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableTakeUntilPredicate.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ta<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22562b;

    /* JADX INFO: compiled from: ObservableTakeUntilPredicate.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22566d;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.q<? super T> qVar) {
            this.f22563a = wVar;
            this.f22564b = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22565c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22565c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22566d) {
                return;
            }
            this.f22566d = true;
            this.f22563a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22566d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22566d = true;
                this.f22563a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22566d) {
                return;
            }
            this.f22563a.onNext(t);
            try {
                if (this.f22564b.test(t)) {
                    this.f22566d = true;
                    this.f22565c.dispose();
                    this.f22563a.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22565c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22565c, bVar)) {
                this.f22565c = bVar;
                this.f22563a.onSubscribe(this);
            }
        }
    }

    public ta(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        super(uVar);
        this.f22562b = qVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22562b));
    }
}
