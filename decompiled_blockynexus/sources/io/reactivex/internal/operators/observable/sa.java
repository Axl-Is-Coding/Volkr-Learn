package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableTakeLastOne.java */
/* JADX INFO: loaded from: classes5.dex */
public final class sa<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: compiled from: ObservableTakeLastOne.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f22554c;

        a(io.reactivex.w<? super T> wVar) {
            this.f22552a = wVar;
        }

        void a() {
            T t = this.f22554c;
            if (t != null) {
                this.f22554c = null;
                this.f22552a.onNext(t);
            }
            this.f22552a.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22554c = null;
            this.f22553b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22553b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22554c = null;
            this.f22552a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22554c = t;
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22553b, bVar)) {
                this.f22553b = bVar;
                this.f22552a.onSubscribe(this);
            }
        }
    }

    public sa(io.reactivex.u<T> uVar) {
        super(uVar);
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar));
    }
}
