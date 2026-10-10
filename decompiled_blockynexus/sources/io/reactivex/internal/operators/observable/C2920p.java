package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableCountSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2920p<T> extends io.reactivex.y<Long> implements io.reactivex.c.a.b<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22505a;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.p$a */
    /* JADX INFO: compiled from: ObservableCountSingle.java */
    static final class a implements io.reactivex.w<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super Long> f22506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f22508c;

        a(io.reactivex.z<? super Long> zVar) {
            this.f22506a = zVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22507b.dispose();
            this.f22507b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22507b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22507b = DisposableHelper.DISPOSED;
            this.f22506a.onSuccess(Long.valueOf(this.f22508c));
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22507b = DisposableHelper.DISPOSED;
            this.f22506a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            this.f22508c++;
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22507b, bVar)) {
                this.f22507b = bVar;
                this.f22506a.onSubscribe(this);
            }
        }
    }

    public C2920p(io.reactivex.u<T> uVar) {
        this.f22505a = uVar;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<Long> a() {
        return io.reactivex.e.a.a(new C2919o(this.f22505a));
    }

    @Override // io.reactivex.y
    public void b(io.reactivex.z<? super Long> zVar) {
        this.f22505a.subscribe(new a(zVar));
    }
}
