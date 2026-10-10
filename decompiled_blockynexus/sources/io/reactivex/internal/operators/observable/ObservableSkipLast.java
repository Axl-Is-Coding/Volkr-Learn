package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSkipLast<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f22228b;

    static final class SkipLastObserver<T> extends ArrayDeque<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -3807491841935125653L;
        final io.reactivex.w<? super T> downstream;
        final int skip;
        io.reactivex.disposables.b upstream;

        SkipLastObserver(io.reactivex.w<? super T> wVar, int i) {
            super(i);
            this.downstream = wVar;
            this.skip = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            }
            offer(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(io.reactivex.u<T> uVar, int i) {
        super(uVar);
        this.f22228b = i;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new SkipLastObserver(wVar, this.f22228b));
    }
}
