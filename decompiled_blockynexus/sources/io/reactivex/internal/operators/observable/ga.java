package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableReduceSeedSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ga<T, R> extends io.reactivex.y<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final R f22416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.c<R, ? super T, R> f22417c;

    /* JADX INFO: compiled from: ObservableReduceSeedSingle.java */
    static final class a<T, R> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super R> f22418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.c<R, ? super T, R> f22419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        R f22420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f22421d;

        a(io.reactivex.z<? super R> zVar, io.reactivex.b.c<R, ? super T, R> cVar, R r) {
            this.f22418a = zVar;
            this.f22420c = r;
            this.f22419b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22421d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22421d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            R r = this.f22420c;
            if (r != null) {
                this.f22420c = null;
                this.f22418a.onSuccess(r);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22420c == null) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22420c = null;
                this.f22418a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            R r = this.f22420c;
            if (r != null) {
                try {
                    R rApply = this.f22419b.apply(r, t);
                    io.reactivex.internal.functions.a.a(rApply, "The reducer returned a null value");
                    this.f22420c = rApply;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f22421d.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22421d, bVar)) {
                this.f22421d = bVar;
                this.f22418a.onSubscribe(this);
            }
        }
    }

    public ga(io.reactivex.u<T> uVar, R r, io.reactivex.b.c<R, ? super T, R> cVar) {
        this.f22415a = uVar;
        this.f22416b = r;
        this.f22417c = cVar;
    }

    @Override // io.reactivex.y
    protected void b(io.reactivex.z<? super R> zVar) {
        this.f22415a.subscribe(new a(zVar, this.f22417c, this.f22416b));
    }
}
