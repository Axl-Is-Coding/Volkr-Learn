package io.reactivex.internal.operators.maybe;

import io.reactivex.b.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatten<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends m<? extends R>> f21935b;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements k<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4375739915521278546L;
        final k<? super R> downstream;
        final o<? super T, ? extends m<? extends R>> mapper;
        io.reactivex.disposables.b upstream;

        final class a implements k<R> {
            a() {
            }

            @Override // io.reactivex.k
            public void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // io.reactivex.k
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // io.reactivex.k
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, bVar);
            }

            @Override // io.reactivex.k
            public void onSuccess(R r) {
                FlatMapMaybeObserver.this.downstream.onSuccess(r);
            }
        }

        FlatMapMaybeObserver(k<? super R> kVar, o<? super T, ? extends m<? extends R>> oVar) {
            this.downstream = kVar;
            this.mapper = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.k
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.k
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.k
        public void onSuccess(T t) {
            try {
                m<? extends R> mVarApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(mVarApply, "The mapper returned a null MaybeSource");
                m<? extends R> mVar = mVarApply;
                if (isDisposed()) {
                    return;
                }
                mVar.a(new a());
            } catch (Exception e2) {
                io.reactivex.exceptions.a.b(e2);
                this.downstream.onError(e2);
            }
        }
    }

    public MaybeFlatten(m<T> mVar, o<? super T, ? extends m<? extends R>> oVar) {
        super(mVar);
        this.f21935b = oVar;
    }

    @Override // io.reactivex.i
    protected void b(k<? super R> kVar) {
        this.f21941a.a(new FlatMapMaybeObserver(kVar, this.f21935b));
    }
}
