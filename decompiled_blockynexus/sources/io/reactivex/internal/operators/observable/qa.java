package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: compiled from: ObservableSwitchIfEmpty.java */
/* JADX INFO: loaded from: classes5.dex */
public final class qa<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22526b;

    /* JADX INFO: compiled from: ObservableSwitchIfEmpty.java */
    static final class a<T> implements io.reactivex.w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.u<? extends T> f22528b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22530d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SequentialDisposable f22529c = new SequentialDisposable();

        a(io.reactivex.w<? super T> wVar, io.reactivex.u<? extends T> uVar) {
            this.f22527a = wVar;
            this.f22528b = uVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (!this.f22530d) {
                this.f22527a.onComplete();
            } else {
                this.f22530d = false;
                this.f22528b.subscribe(this);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22527a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22530d) {
                this.f22530d = false;
            }
            this.f22527a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22529c.update(bVar);
        }
    }

    public qa(io.reactivex.u<T> uVar, io.reactivex.u<? extends T> uVar2) {
        super(uVar);
        this.f22526b = uVar2;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        a aVar = new a(wVar, this.f22526b);
        wVar.onSubscribe(aVar.f22529c);
        this.f22358a.subscribe(aVar);
    }
}
