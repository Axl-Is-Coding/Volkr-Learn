package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDetach.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2925v<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.v$a */
    /* JADX INFO: compiled from: ObservableDetach.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        io.reactivex.w<? super T> f22577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f22578b;

        a(io.reactivex.w<? super T> wVar) {
            this.f22577a = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f22578b;
            this.f22578b = EmptyComponent.INSTANCE;
            this.f22577a = EmptyComponent.asObserver();
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22578b.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            io.reactivex.w<? super T> wVar = this.f22577a;
            this.f22578b = EmptyComponent.INSTANCE;
            this.f22577a = EmptyComponent.asObserver();
            wVar.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            io.reactivex.w<? super T> wVar = this.f22577a;
            this.f22578b = EmptyComponent.INSTANCE;
            this.f22577a = EmptyComponent.asObserver();
            wVar.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22577a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22578b, bVar)) {
                this.f22578b = bVar;
                this.f22577a.onSubscribe(this);
            }
        }
    }

    public C2925v(io.reactivex.u<T> uVar) {
        super(uVar);
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar));
    }
}
