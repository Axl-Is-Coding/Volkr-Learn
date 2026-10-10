package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableAll.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2909e<T> extends AbstractC2904a<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22392b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.e$a */
    /* JADX INFO: compiled from: ObservableAll.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super Boolean> f22393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22396d;

        a(io.reactivex.w<? super Boolean> wVar, io.reactivex.b.q<? super T> qVar) {
            this.f22393a = wVar;
            this.f22394b = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22395c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22395c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22396d) {
                return;
            }
            this.f22396d = true;
            this.f22393a.onNext(true);
            this.f22393a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22396d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22396d = true;
                this.f22393a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22396d) {
                return;
            }
            try {
                if (this.f22394b.test(t)) {
                    return;
                }
                this.f22396d = true;
                this.f22395c.dispose();
                this.f22393a.onNext(false);
                this.f22393a.onComplete();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22395c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22395c, bVar)) {
                this.f22395c = bVar;
                this.f22393a.onSubscribe(this);
            }
        }
    }

    public C2909e(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        super(uVar);
        this.f22392b = qVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super Boolean> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22392b));
    }
}
