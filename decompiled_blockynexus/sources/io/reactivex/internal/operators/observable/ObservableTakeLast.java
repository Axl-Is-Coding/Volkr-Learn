package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeLast<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f22240b;

    static final class TakeLastObserver<T> extends ArrayDeque<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final io.reactivex.w<? super T> downstream;
        io.reactivex.disposables.b upstream;

        TakeLastObserver(io.reactivex.w<? super T> wVar, int i) {
            this.downstream = wVar;
            this.count = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            io.reactivex.w<? super T> wVar = this.downstream;
            while (!this.cancelled) {
                T tPoll = poll();
                if (tPoll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    wVar.onComplete();
                    return;
                }
                wVar.onNext(tPoll);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
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

    public ObservableTakeLast(io.reactivex.u<T> uVar, int i) {
        super(uVar);
        this.f22240b = i;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new TakeLastObserver(wVar, this.f22240b));
    }
}
