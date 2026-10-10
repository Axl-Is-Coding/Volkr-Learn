package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRepeatUntil<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.e f22178b;

    static final class RepeatUntilObserver<T> extends AtomicInteger implements io.reactivex.w<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final io.reactivex.w<? super T> downstream;
        final io.reactivex.u<? extends T> source;
        final io.reactivex.b.e stop;
        final SequentialDisposable upstream;

        RepeatUntilObserver(io.reactivex.w<? super T> wVar, io.reactivex.b.e eVar, SequentialDisposable sequentialDisposable, io.reactivex.u<? extends T> uVar) {
            this.downstream = wVar;
            this.upstream = sequentialDisposable;
            this.source = uVar;
            this.stop = eVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.downstream.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.downstream.onError(th);
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
            this.upstream.replace(bVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                do {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }
    }

    public ObservableRepeatUntil(io.reactivex.p<T> pVar, io.reactivex.b.e eVar) {
        super(pVar);
        this.f22178b = eVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        wVar.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(wVar, this.f22178b, sequentialDisposable, this.f22358a).subscribeNext();
    }
}
