package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableMapNotification.java */
/* JADX INFO: loaded from: classes5.dex */
public final class Z<T, R> extends AbstractC2904a<T, io.reactivex.u<? extends R>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> f22350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends R>> f22351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<? extends io.reactivex.u<? extends R>> f22352d;

    /* JADX INFO: compiled from: ObservableMapNotification.java */
    static final class a<T, R> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super io.reactivex.u<? extends R>> f22353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> f22354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends R>> f22355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Callable<? extends io.reactivex.u<? extends R>> f22356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        io.reactivex.disposables.b f22357e;

        a(io.reactivex.w<? super io.reactivex.u<? extends R>> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar, io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends R>> oVar2, Callable<? extends io.reactivex.u<? extends R>> callable) {
            this.f22353a = wVar;
            this.f22354b = oVar;
            this.f22355c = oVar2;
            this.f22356d = callable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22357e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22357e.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            try {
                io.reactivex.u<? extends R> uVarCall = this.f22356d.call();
                io.reactivex.internal.functions.a.a(uVarCall, "The onComplete ObservableSource returned is null");
                this.f22353a.onNext(uVarCall);
                this.f22353a.onComplete();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22353a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            try {
                io.reactivex.u<? extends R> uVarApply = this.f22355c.apply(th);
                io.reactivex.internal.functions.a.a(uVarApply, "The onError ObservableSource returned is null");
                this.f22353a.onNext(uVarApply);
                this.f22353a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f22353a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            try {
                io.reactivex.u<? extends R> uVarApply = this.f22354b.apply(t);
                io.reactivex.internal.functions.a.a(uVarApply, "The onNext ObservableSource returned is null");
                this.f22353a.onNext(uVarApply);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22353a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22357e, bVar)) {
                this.f22357e = bVar;
                this.f22353a.onSubscribe(this);
            }
        }
    }

    public Z(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar, io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends R>> oVar2, Callable<? extends io.reactivex.u<? extends R>> callable) {
        super(uVar);
        this.f22350b = oVar;
        this.f22351c = oVar2;
        this.f22352d = callable;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.u<? extends R>> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22350b, this.f22351c, this.f22352d));
    }
}
