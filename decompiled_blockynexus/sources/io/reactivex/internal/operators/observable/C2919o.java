package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableCount.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2919o<T> extends AbstractC2904a<T, Long> {

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.o$a */
    /* JADX INFO: compiled from: ObservableCount.java */
    static final class a implements io.reactivex.w<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super Long> f22491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f22493c;

        a(io.reactivex.w<? super Long> wVar) {
            this.f22491a = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22492b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22492b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22491a.onNext(Long.valueOf(this.f22493c));
            this.f22491a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22491a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            this.f22493c++;
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22492b, bVar)) {
                this.f22492b = bVar;
                this.f22491a.onSubscribe(this);
            }
        }
    }

    public C2919o(io.reactivex.u<T> uVar) {
        super(uVar);
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super Long> wVar) {
        this.f22358a.subscribe(new a(wVar));
    }
}
