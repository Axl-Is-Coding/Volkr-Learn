package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableToList.java */
/* JADX INFO: loaded from: classes5.dex */
public final class wa<T, U extends Collection<? super T>> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f22589b;

    /* JADX INFO: compiled from: ObservableToList.java */
    static final class a<T, U extends Collection<? super T>> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super U> f22590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        U f22592c;

        a(io.reactivex.w<? super U> wVar, U u) {
            this.f22590a = wVar;
            this.f22592c = u;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22591b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22591b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            U u = this.f22592c;
            this.f22592c = null;
            this.f22590a.onNext(u);
            this.f22590a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22592c = null;
            this.f22590a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22592c.add(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22591b, bVar)) {
                this.f22591b = bVar;
                this.f22590a.onSubscribe(this);
            }
        }
    }

    public wa(io.reactivex.u<T> uVar, int i) {
        super(uVar);
        this.f22589b = Functions.a(i);
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super U> wVar) {
        try {
            U uCall = this.f22589b.call();
            io.reactivex.internal.functions.a.a(uCall, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f22358a.subscribe(new a(wVar, uCall));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
        }
    }

    public wa(io.reactivex.u<T> uVar, Callable<U> callable) {
        super(uVar);
        this.f22589b = callable;
    }
}
