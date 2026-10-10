package io.reactivex.internal.operators.maybe;

import io.reactivex.b.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;

/* JADX INFO: compiled from: MaybeMap.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d<T, R> extends io.reactivex.internal.operators.maybe.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends R> f21944b;

    /* JADX INFO: compiled from: MaybeMap.java */
    static final class a<T, R> implements k<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final k<? super R> f21945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final o<? super T, ? extends R> f21946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f21947c;

        a(k<? super R> kVar, o<? super T, ? extends R> oVar) {
            this.f21945a = kVar;
            this.f21946b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar = this.f21947c;
            this.f21947c = DisposableHelper.DISPOSED;
            bVar.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21947c.isDisposed();
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.f21945a.onComplete();
        }

        @Override // io.reactivex.k
        public void onError(Throwable th) {
            this.f21945a.onError(th);
        }

        @Override // io.reactivex.k
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f21947c, bVar)) {
                this.f21947c = bVar;
                this.f21945a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.k
        public void onSuccess(T t) {
            try {
                R rApply = this.f21946b.apply(t);
                io.reactivex.internal.functions.a.a(rApply, "The mapper returned a null item");
                this.f21945a.onSuccess(rApply);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f21945a.onError(th);
            }
        }
    }

    public d(m<T> mVar, o<? super T, ? extends R> oVar) {
        super(mVar);
        this.f21944b = oVar;
    }

    @Override // io.reactivex.i
    protected void b(k<? super R> kVar) {
        this.f21941a.a(new a(kVar, this.f21944b));
    }
}
