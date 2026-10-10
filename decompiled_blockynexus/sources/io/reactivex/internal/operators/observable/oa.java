package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableSkipUntil.java */
/* JADX INFO: loaded from: classes5.dex */
public final class oa<T, U> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<U> f22494b;

    /* JADX INFO: compiled from: ObservableSkipUntil.java */
    final class a implements io.reactivex.w<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayCompositeDisposable f22495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T> f22496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final io.reactivex.observers.f<T> f22497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f22498d;

        a(ArrayCompositeDisposable arrayCompositeDisposable, b<T> bVar, io.reactivex.observers.f<T> fVar) {
            this.f22495a = arrayCompositeDisposable;
            this.f22496b = bVar;
            this.f22497c = fVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22496b.f22503d = true;
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22495a.dispose();
            this.f22497c.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(U u) {
            this.f22498d.dispose();
            this.f22496b.f22503d = true;
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22498d, bVar)) {
                this.f22498d = bVar;
                this.f22495a.setResource(1, bVar);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableSkipUntil.java */
    static final class b<T> implements io.reactivex.w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayCompositeDisposable f22501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f22503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22504e;

        b(io.reactivex.w<? super T> wVar, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f22500a = wVar;
            this.f22501b = arrayCompositeDisposable;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22501b.dispose();
            this.f22500a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22501b.dispose();
            this.f22500a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22504e) {
                this.f22500a.onNext(t);
            } else if (this.f22503d) {
                this.f22504e = true;
                this.f22500a.onNext(t);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22502c, bVar)) {
                this.f22502c = bVar;
                this.f22501b.setResource(0, bVar);
            }
        }
    }

    public oa(io.reactivex.u<T> uVar, io.reactivex.u<U> uVar2) {
        super(uVar);
        this.f22494b = uVar2;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        io.reactivex.observers.f fVar = new io.reactivex.observers.f(wVar);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        fVar.onSubscribe(arrayCompositeDisposable);
        b bVar = new b(fVar, arrayCompositeDisposable);
        this.f22494b.subscribe(new a(arrayCompositeDisposable, bVar, fVar));
        this.f22358a.subscribe(bVar);
    }
}
