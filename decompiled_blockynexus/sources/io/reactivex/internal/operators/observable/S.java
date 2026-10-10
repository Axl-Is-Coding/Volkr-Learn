package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC2894a;

/* JADX INFO: compiled from: ObservableIgnoreElementsCompletable.java */
/* JADX INFO: loaded from: classes5.dex */
public final class S<T> extends AbstractC2894a implements io.reactivex.c.a.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22307a;

    /* JADX INFO: compiled from: ObservableIgnoreElementsCompletable.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b f22308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22309b;

        a(io.reactivex.b bVar) {
            this.f22308a = bVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22309b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22309b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22308a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22308a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22309b = bVar;
            this.f22308a.onSubscribe(this);
        }
    }

    public S(io.reactivex.u<T> uVar) {
        this.f22307a = uVar;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<T> a() {
        return io.reactivex.e.a.a(new Q(this.f22307a));
    }

    @Override // io.reactivex.AbstractC2894a
    public void b(io.reactivex.b bVar) {
        this.f22307a.subscribe(new a(bVar));
    }
}
