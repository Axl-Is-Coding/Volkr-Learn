package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableFlattenIterable.java */
/* JADX INFO: loaded from: classes5.dex */
public final class H<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends Iterable<? extends R>> f22026b;

    /* JADX INFO: compiled from: ObservableFlattenIterable.java */
    static final class a<T, R> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super R> f22027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.o<? super T, ? extends Iterable<? extends R>> f22028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22029c;

        a(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.f22027a = wVar;
            this.f22028b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22029c.dispose();
            this.f22029c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22029c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            io.reactivex.disposables.b bVar = this.f22029c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            this.f22029c = disposableHelper;
            this.f22027a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            io.reactivex.disposables.b bVar = this.f22029c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22029c = disposableHelper;
                this.f22027a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22029c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                io.reactivex.w<? super R> wVar = this.f22027a;
                for (R r : this.f22028b.apply(t)) {
                    try {
                        try {
                            io.reactivex.internal.functions.a.a(r, "The iterator returned a null value");
                            wVar.onNext(r);
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            this.f22029c.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.f22029c.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f22029c.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22029c, bVar)) {
                this.f22029c = bVar;
                this.f22027a.onSubscribe(this);
            }
        }
    }

    public H(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends Iterable<? extends R>> oVar) {
        super(uVar);
        this.f22026b = oVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super R> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22026b));
    }
}
