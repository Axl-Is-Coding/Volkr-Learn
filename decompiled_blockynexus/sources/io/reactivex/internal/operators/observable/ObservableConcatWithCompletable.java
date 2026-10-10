package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatWithCompletable<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.c f22096b;

    static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.b, io.reactivex.disposables.b {
        private static final long serialVersionUID = -1953724749712440952L;
        final io.reactivex.w<? super T> downstream;
        boolean inCompletable;
        io.reactivex.c other;

        ConcatWithObserver(io.reactivex.w<? super T> wVar, io.reactivex.c cVar) {
            this.downstream = wVar;
            this.other = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            DisposableHelper.replace(this, null);
            io.reactivex.c cVar = this.other;
            this.other = null;
            cVar.a(this);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (!DisposableHelper.setOnce(this, bVar) || this.inCompletable) {
                return;
            }
            this.downstream.onSubscribe(this);
        }
    }

    public ObservableConcatWithCompletable(io.reactivex.p<T> pVar, io.reactivex.c cVar) {
        super(pVar);
        this.f22096b = cVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new ConcatWithObserver(wVar, this.f22096b));
    }
}
