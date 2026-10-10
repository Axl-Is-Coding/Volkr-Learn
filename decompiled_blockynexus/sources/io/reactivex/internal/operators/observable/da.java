package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableOnErrorReturn.java */
/* JADX INFO: loaded from: classes5.dex */
public final class da<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super Throwable, ? extends T> f22388b;

    /* JADX INFO: compiled from: ObservableOnErrorReturn.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.o<? super Throwable, ? extends T> f22390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22391c;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super Throwable, ? extends T> oVar) {
            this.f22389a = wVar;
            this.f22390b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22391c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22391c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22389a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            try {
                T tApply = this.f22390b.apply(th);
                if (tApply != null) {
                    this.f22389a.onNext(tApply);
                    this.f22389a.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f22389a.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f22389a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22389a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22391c, bVar)) {
                this.f22391c = bVar;
                this.f22389a.onSubscribe(this);
            }
        }
    }

    public da(io.reactivex.u<T> uVar, io.reactivex.b.o<? super Throwable, ? extends T> oVar) {
        super(uVar);
        this.f22388b = oVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22388b));
    }
}
