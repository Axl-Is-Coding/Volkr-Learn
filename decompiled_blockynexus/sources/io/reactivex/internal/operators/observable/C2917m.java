package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableCollect.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2917m<T, U> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f22465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.b<? super U, ? super T> f22466c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.m$a */
    /* JADX INFO: compiled from: ObservableCollect.java */
    static final class a<T, U> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super U> f22467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.b<? super U, ? super T> f22468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final U f22469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f22470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22471e;

        a(io.reactivex.w<? super U> wVar, U u, io.reactivex.b.b<? super U, ? super T> bVar) {
            this.f22467a = wVar;
            this.f22468b = bVar;
            this.f22469c = u;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22470d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22470d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22471e) {
                return;
            }
            this.f22471e = true;
            this.f22467a.onNext(this.f22469c);
            this.f22467a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22471e) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22471e = true;
                this.f22467a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22471e) {
                return;
            }
            try {
                this.f22468b.accept(this.f22469c, t);
            } catch (Throwable th) {
                this.f22470d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22470d, bVar)) {
                this.f22470d = bVar;
                this.f22467a.onSubscribe(this);
            }
        }
    }

    public C2917m(io.reactivex.u<T> uVar, Callable<? extends U> callable, io.reactivex.b.b<? super U, ? super T> bVar) {
        super(uVar);
        this.f22465b = callable;
        this.f22466c = bVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super U> wVar) {
        try {
            U uCall = this.f22465b.call();
            io.reactivex.internal.functions.a.a(uCall, "The initialSupplier returned a null value");
            this.f22358a.subscribe(new a(wVar, uCall, this.f22466c));
        } catch (Throwable th) {
            EmptyDisposable.error(th, wVar);
        }
    }
}
