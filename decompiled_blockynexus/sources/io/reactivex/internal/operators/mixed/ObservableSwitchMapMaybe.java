package io.reactivex.internal.operators.mixed;

import io.reactivex.b.o;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.p;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMapMaybe<T, R> extends p<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final p<T> f21979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends m<? extends R>> f21980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f21981c;

    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements w<T>, b {
        static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final w<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
        final o<? super T, ? extends m<? extends R>> mapper;
        b upstream;

        static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements k<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapMaybeMainObserver<?, R> parent;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.parent = switchMapMaybeMainObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.k
            public void onComplete() {
                this.parent.innerComplete(this);
            }

            @Override // io.reactivex.k
            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            @Override // io.reactivex.k
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.k
            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }
        }

        SwitchMapMaybeMainObserver(w<? super R> wVar, o<? super T, ? extends m<? extends R>> oVar, boolean z) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.delayErrors = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        void disposeInner() {
            SwitchMapMaybeObserver<R> andSet = this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
            if (andSet == null || andSet == INNER_DISPOSED) {
                return;
            }
            andSet.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            w<? super R> wVar = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    wVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z2 = switchMapMaybeObserver == null;
                if (z && z2) {
                    Throwable thTerminate = atomicThrowable.terminate();
                    if (thTerminate != null) {
                        wVar.onError(thTerminate);
                        return;
                    } else {
                        wVar.onComplete();
                        return;
                    }
                }
                if (z2 || switchMapMaybeObserver.item == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapMaybeObserver, null);
                    wVar.onNext(switchMapMaybeObserver.item);
                }
            }
        }

        void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, null)) {
                drain();
            }
        }

        void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!this.inner.compareAndSet(switchMapMaybeObserver, null) || !this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                disposeInner();
            }
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.dispose();
            }
            try {
                m<? extends R> mVarApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(mVarApply, "The mapper returned a null MaybeSource");
                m<? extends R> mVar = mVarApply;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                mVar.a(switchMapMaybeObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.dispose();
                this.inner.getAndSet((SwitchMapMaybeObserver<R>) INNER_DISPOSED);
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(p<T> pVar, o<? super T, ? extends m<? extends R>> oVar, boolean z) {
        this.f21979a = pVar;
        this.f21980b = oVar;
        this.f21981c = z;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super R> wVar) {
        if (a.a(this.f21979a, this.f21980b, wVar)) {
            return;
        }
        this.f21979a.subscribe(new SwitchMapMaybeMainObserver(wVar, this.f21980b, this.f21981c));
    }
}
