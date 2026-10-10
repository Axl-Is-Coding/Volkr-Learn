package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableToListSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class xa<T, U extends Collection<? super T>> extends io.reactivex.y<U> implements io.reactivex.c.a.b<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f22597b;

    /* JADX INFO: compiled from: ObservableToListSingle.java */
    static final class a<T, U extends Collection<? super T>> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super U> f22598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        U f22599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22600c;

        a(io.reactivex.z<? super U> zVar, U u) {
            this.f22598a = zVar;
            this.f22599b = u;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22600c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22600c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            U u = this.f22599b;
            this.f22599b = null;
            this.f22598a.onSuccess(u);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22599b = null;
            this.f22598a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22599b.add(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22600c, bVar)) {
                this.f22600c = bVar;
                this.f22598a.onSubscribe(this);
            }
        }
    }

    public xa(io.reactivex.u<T> uVar, int i) {
        this.f22596a = uVar;
        this.f22597b = Functions.a(i);
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<U> a() {
        return io.reactivex.e.a.a(new wa(this.f22596a, this.f22597b));
    }

    @Override // io.reactivex.y
    public void b(io.reactivex.z<? super U> zVar) {
        try {
            U uCall = this.f22597b.call();
            io.reactivex.internal.functions.a.a(uCall, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f22596a.subscribe(new a(zVar, uCall));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, zVar);
        }
    }

    public xa(io.reactivex.u<T> uVar, Callable<U> callable) {
        this.f22596a = uVar;
        this.f22597b = callable;
    }
}
