package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRetryBiPredicate<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.d<? super Integer, ? super Throwable> f22197b;

    static final class RetryBiObserver<T> extends AtomicInteger implements io.reactivex.w<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final io.reactivex.w<? super T> downstream;
        final io.reactivex.b.d<? super Integer, ? super Throwable> predicate;
        int retries;
        final io.reactivex.u<? extends T> source;
        final SequentialDisposable upstream;

        RetryBiObserver(io.reactivex.w<? super T> wVar, io.reactivex.b.d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, io.reactivex.u<? extends T> uVar) {
            this.downstream = wVar;
            this.upstream = sequentialDisposable;
            this.source = uVar;
            this.predicate = dVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            try {
                io.reactivex.b.d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i = this.retries + 1;
                this.retries = i;
                if (dVar.test(Integer.valueOf(i), th)) {
                    subscribeNext();
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.upstream.replace(bVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryBiPredicate(io.reactivex.p<T> pVar, io.reactivex.b.d<? super Integer, ? super Throwable> dVar) {
        super(pVar);
        this.f22197b = dVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        wVar.onSubscribe(sequentialDisposable);
        new RetryBiObserver(wVar, this.f22197b, sequentialDisposable, this.f22358a).subscribeNext();
    }
}
