package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.aa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableMaterialize.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2905aa<T> extends AbstractC2904a<T, io.reactivex.n<T>> {

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.aa$a */
    /* JADX INFO: compiled from: ObservableMaterialize.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super io.reactivex.n<T>> f22359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22360b;

        a(io.reactivex.w<? super io.reactivex.n<T>> wVar) {
            this.f22359a = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22360b.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22360b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22359a.onNext(io.reactivex.n.a());
            this.f22359a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22359a.onNext(io.reactivex.n.a(th));
            this.f22359a.onComplete();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22359a.onNext(io.reactivex.n.a(t));
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22360b, bVar)) {
                this.f22360b = bVar;
                this.f22359a.onSubscribe(this);
            }
        }
    }

    public C2905aa(io.reactivex.u<T> uVar) {
        super(uVar);
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.n<T>> wVar) {
        this.f22358a.subscribe(new a(wVar));
    }
}
