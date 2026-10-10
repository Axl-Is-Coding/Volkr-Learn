package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRepeat<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22177b;

    static final class RepeatObserver<T> extends AtomicInteger implements io.reactivex.w<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final io.reactivex.w<? super T> downstream;
        long remaining;
        final SequentialDisposable sd;
        final io.reactivex.u<? extends T> source;

        RepeatObserver(io.reactivex.w<? super T> wVar, long j, SequentialDisposable sequentialDisposable, io.reactivex.u<? extends T> uVar) {
            this.downstream = wVar;
            this.sd = sequentialDisposable;
            this.source = uVar;
            this.remaining = j;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                subscribeNext();
            } else {
                this.downstream.onComplete();
            }
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
            this.sd.replace(bVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sd.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRepeat(io.reactivex.p<T> pVar, long j) {
        super(pVar);
        this.f22177b = j;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        wVar.onSubscribe(sequentialDisposable);
        long j = this.f22177b;
        new RepeatObserver(wVar, j != Long.MAX_VALUE ? j - 1 : Long.MAX_VALUE, sequentialDisposable, this.f22358a).subscribeNext();
    }
}
