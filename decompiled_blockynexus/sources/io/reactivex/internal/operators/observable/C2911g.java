package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableAny.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2911g<T> extends AbstractC2904a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22410b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.g$a */
    /* JADX INFO: compiled from: ObservableAny.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super Boolean> f22411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22414d;

        a(io.reactivex.w<? super Boolean> wVar, io.reactivex.b.q<? super T> qVar) {
            this.f22411a = wVar;
            this.f22412b = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22413c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22413c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22414d) {
                return;
            }
            this.f22414d = true;
            this.f22411a.onNext(false);
            this.f22411a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22414d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22414d = true;
                this.f22411a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22414d) {
                return;
            }
            try {
                if (this.f22412b.test(t)) {
                    this.f22414d = true;
                    this.f22413c.dispose();
                    this.f22411a.onNext(true);
                    this.f22411a.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22413c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22413c, bVar)) {
                this.f22413c = bVar;
                this.f22411a.onSubscribe(this);
            }
        }
    }

    public C2911g(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        super(uVar);
        this.f22410b = qVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super Boolean> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22410b));
    }
}
