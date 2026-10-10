package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableCollectSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2918n<T, U> extends io.reactivex.y<U> implements io.reactivex.c.a.b<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends U> f22480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.b<? super U, ? super T> f22481c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.n$a */
    /* JADX INFO: compiled from: ObservableCollectSingle.java */
    static final class a<T, U> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super U> f22482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.b<? super U, ? super T> f22483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final U f22484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f22485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22486e;

        a(io.reactivex.z<? super U> zVar, U u, io.reactivex.b.b<? super U, ? super T> bVar) {
            this.f22482a = zVar;
            this.f22483b = bVar;
            this.f22484c = u;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22485d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22485d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22486e) {
                return;
            }
            this.f22486e = true;
            this.f22482a.onSuccess(this.f22484c);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22486e) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22486e = true;
                this.f22482a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22486e) {
                return;
            }
            try {
                this.f22483b.accept(this.f22484c, t);
            } catch (Throwable th) {
                this.f22485d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22485d, bVar)) {
                this.f22485d = bVar;
                this.f22482a.onSubscribe(this);
            }
        }
    }

    public C2918n(io.reactivex.u<T> uVar, Callable<? extends U> callable, io.reactivex.b.b<? super U, ? super T> bVar) {
        this.f22479a = uVar;
        this.f22480b = callable;
        this.f22481c = bVar;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<U> a() {
        return io.reactivex.e.a.a(new C2917m(this.f22479a, this.f22480b, this.f22481c));
    }

    @Override // io.reactivex.y
    protected void b(io.reactivex.z<? super U> zVar) {
        try {
            U uCall = this.f22480b.call();
            io.reactivex.internal.functions.a.a(uCall, "The initialSupplier returned a null value");
            this.f22479a.subscribe(new a(zVar, uCall, this.f22481c));
        } catch (Throwable th) {
            EmptyDisposable.error(th, zVar);
        }
    }
}
