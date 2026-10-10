package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: ObservableTake.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ra<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22532b;

    /* JADX INFO: compiled from: ObservableTake.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f22534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f22536d;

        a(io.reactivex.w<? super T> wVar, long j) {
            this.f22533a = wVar;
            this.f22536d = j;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22535c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22535c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22534b) {
                return;
            }
            this.f22534b = true;
            this.f22535c.dispose();
            this.f22533a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22534b) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.f22534b = true;
            this.f22535c.dispose();
            this.f22533a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22534b) {
                return;
            }
            long j = this.f22536d;
            this.f22536d = j - 1;
            if (j > 0) {
                boolean z = this.f22536d == 0;
                this.f22533a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22535c, bVar)) {
                this.f22535c = bVar;
                if (this.f22536d != 0) {
                    this.f22533a.onSubscribe(this);
                    return;
                }
                this.f22534b = true;
                bVar.dispose();
                EmptyDisposable.complete(this.f22533a);
            }
        }
    }

    public ra(io.reactivex.u<T> uVar, long j) {
        super(uVar);
        this.f22532b = j;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22532b));
    }
}
