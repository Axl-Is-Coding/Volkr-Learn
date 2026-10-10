package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableSkipWhile.java */
/* JADX INFO: loaded from: classes5.dex */
public final class pa<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22509b;

    /* JADX INFO: compiled from: ObservableSkipWhile.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22513d;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.q<? super T> qVar) {
            this.f22510a = wVar;
            this.f22511b = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22512c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22512c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22510a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22510a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22513d) {
                this.f22510a.onNext(t);
                return;
            }
            try {
                if (this.f22511b.test(t)) {
                    return;
                }
                this.f22513d = true;
                this.f22510a.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22512c.dispose();
                this.f22510a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22512c, bVar)) {
                this.f22512c = bVar;
                this.f22510a.onSubscribe(this);
            }
        }
    }

    public pa(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        super(uVar);
        this.f22509b = qVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22509b));
    }
}
