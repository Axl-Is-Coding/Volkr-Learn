package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRetryPredicate<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super Throwable> f22198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22199c;

    static final class RepeatObserver<T> extends AtomicInteger implements io.reactivex.w<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final io.reactivex.w<? super T> downstream;
        final io.reactivex.b.q<? super Throwable> predicate;
        long remaining;
        final io.reactivex.u<? extends T> source;
        final SequentialDisposable upstream;

        RepeatObserver(io.reactivex.w<? super T> wVar, long j, io.reactivex.b.q<? super Throwable> qVar, SequentialDisposable sequentialDisposable, io.reactivex.u<? extends T> uVar) {
            this.downstream = wVar;
            this.upstream = sequentialDisposable;
            this.source = uVar;
            this.predicate = qVar;
            this.remaining = j;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.downstream.onError(th);
                return;
            }
            try {
                if (this.predicate.test(th)) {
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

    public ObservableRetryPredicate(io.reactivex.p<T> pVar, long j, io.reactivex.b.q<? super Throwable> qVar) {
        super(pVar);
        this.f22198b = qVar;
        this.f22199c = j;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        wVar.onSubscribe(sequentialDisposable);
        new RepeatObserver(wVar, this.f22199c, this.f22198b, sequentialDisposable, this.f22358a).subscribeNext();
    }
}
