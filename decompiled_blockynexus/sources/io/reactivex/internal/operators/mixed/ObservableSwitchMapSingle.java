package io.reactivex.internal.operators.mixed;

import io.reactivex.A;
import io.reactivex.b.o;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.p;
import io.reactivex.w;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMapSingle<T, R> extends p<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final p<T> f21982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends A<? extends R>> f21983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f21984c;

    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements w<T>, b {
        static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final w<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();
        final o<? super T, ? extends A<? extends R>> mapper;
        b upstream;

        static final class SwitchMapSingleObserver<R> extends AtomicReference<b> implements z<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapSingleMainObserver<?, R> parent;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.parent = switchMapSingleMainObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
            public void onError(Throwable th) {
                this.parent.innerError(this, th);
            }

            @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.z, io.reactivex.k
            public void onSuccess(R r) {
                this.item = r;
                this.parent.drain();
            }
        }

        SwitchMapSingleMainObserver(w<? super R> wVar, o<? super T, ? extends A<? extends R>> oVar, boolean z) {
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
            SwitchMapSingleObserver<R> andSet = this.inner.getAndSet((SwitchMapSingleObserver<R>) INNER_DISPOSED);
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
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    wVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z2 = switchMapSingleObserver == null;
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
                if (z2 || switchMapSingleObserver.item == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapSingleObserver, null);
                    wVar.onNext(switchMapSingleObserver.item);
                }
            }
        }

        void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (!this.inner.compareAndSet(switchMapSingleObserver, null) || !this.errors.addThrowable(th)) {
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
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.dispose();
            }
            try {
                A<? extends R> aApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(aApply, "The mapper returned a null SingleSource");
                A<? extends R> a2 = aApply;
                SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                a2.a(switchMapSingleObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.dispose();
                this.inner.getAndSet((SwitchMapSingleObserver<R>) INNER_DISPOSED);
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

    public ObservableSwitchMapSingle(p<T> pVar, o<? super T, ? extends A<? extends R>> oVar, boolean z) {
        this.f21982a = pVar;
        this.f21983b = oVar;
        this.f21984c = z;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super R> wVar) {
        if (a.b(this.f21982a, this.f21983b, wVar)) {
            return;
        }
        this.f21982a.subscribe(new SwitchMapSingleMainObserver(wVar, this.f21983b, this.f21984c));
    }
}
