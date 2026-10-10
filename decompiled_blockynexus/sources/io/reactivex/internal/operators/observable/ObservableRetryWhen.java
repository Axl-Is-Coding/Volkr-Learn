package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRetryWhen<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super io.reactivex.p<Throwable>, ? extends io.reactivex.u<?>> f22200b;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final io.reactivex.w<? super T> downstream;
        final io.reactivex.subjects.b<Throwable> signaller;
        final io.reactivex.u<T> source;
        final AtomicInteger wip = new AtomicInteger();
        final AtomicThrowable error = new AtomicThrowable();
        final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        final class InnerRepeatObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            @Override // io.reactivex.w
            public void onComplete() {
                RepeatWhenObserver.this.innerComplete();
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
                RepeatWhenObserver.this.innerError(th);
            }

            @Override // io.reactivex.w
            public void onNext(Object obj) {
                RepeatWhenObserver.this.innerNext();
            }

            @Override // io.reactivex.w
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        RepeatWhenObserver(io.reactivex.w<? super T> wVar, io.reactivex.subjects.b<Throwable> bVar, io.reactivex.u<T> uVar) {
            this.downstream = wVar;
            this.signaller = bVar;
            this.source = uVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        void innerError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.a((io.reactivex.w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        void innerNext() {
            subscribeNext();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            io.reactivex.internal.util.g.a(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.upstream, bVar);
        }

        void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryWhen(io.reactivex.u<T> uVar, io.reactivex.b.o<? super io.reactivex.p<Throwable>, ? extends io.reactivex.u<?>> oVar) {
        super(uVar);
        this.f22200b = oVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        io.reactivex.subjects.b<T> bVarB = PublishSubject.c().b();
        try {
            io.reactivex.u<?> uVarApply = this.f22200b.apply(bVarB);
            io.reactivex.internal.functions.a.a(uVarApply, "The handler returned a null ObservableSource");
            io.reactivex.u<?> uVar = uVarApply;
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(wVar, bVarB, this.f22358a);
            wVar.onSubscribe(repeatWhenObserver);
            uVar.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
        }
    }
}
