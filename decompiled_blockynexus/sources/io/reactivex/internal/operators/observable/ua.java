package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableTakeWhile.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ua<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22572b;

    /* JADX INFO: compiled from: ObservableTakeWhile.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22576d;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.q<? super T> qVar) {
            this.f22573a = wVar;
            this.f22574b = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22575c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22575c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22576d) {
                return;
            }
            this.f22576d = true;
            this.f22573a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22576d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22576d = true;
                this.f22573a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22576d) {
                return;
            }
            try {
                if (this.f22574b.test(t)) {
                    this.f22573a.onNext(t);
                    return;
                }
                this.f22576d = true;
                this.f22575c.dispose();
                this.f22573a.onComplete();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22575c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22575c, bVar)) {
                this.f22575c = bVar;
                this.f22573a.onSubscribe(this);
            }
        }
    }

    public ua(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        super(uVar);
        this.f22572b = qVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22572b));
    }
}
