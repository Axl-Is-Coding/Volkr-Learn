package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTimeout<T, U, V> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<U> f22254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.u<V>> f22255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22256d;

    static final class TimeoutConsumer extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final a parent;

        TimeoutConsumer(long j, a aVar) {
            this.idx = j;
            this.parent = aVar;
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
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper) {
                io.reactivex.e.a.b(th);
            } else {
                lazySet(disposableHelper);
                this.parent.onTimeoutError(this.idx, th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) get();
            if (bVar != DisposableHelper.DISPOSED) {
                bVar.dispose();
                lazySet(DisposableHelper.DISPOSED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.disposables.b, a {
        private static final long serialVersionUID = -7508389464265974549L;
        final io.reactivex.w<? super T> downstream;
        io.reactivex.u<? extends T> fallback;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicLong index = new AtomicLong();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutFallbackObserver(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<?>> oVar, io.reactivex.u<? extends T> uVar) {
            this.downstream = wVar;
            this.itemTimeoutIndicator = oVar;
            this.fallback = uVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.task.dispose();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    io.reactivex.disposables.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        io.reactivex.u<?> uVarApply = this.itemTimeoutIndicator.apply(t);
                        io.reactivex.internal.functions.a.a(uVarApply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        io.reactivex.u<?> uVar = uVarApply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            uVar.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.upstream.get().dispose();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                io.reactivex.u<? extends T> uVar = this.fallback;
                this.fallback = null;
                uVar.subscribe(new ObservableTimeoutTimed.a(this.downstream, this));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long j, Throwable th) {
            if (!this.index.compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.e.a.b(th);
            } else {
                DisposableHelper.dispose(this);
                this.downstream.onError(th);
            }
        }

        void startFirstTimeout(io.reactivex.u<?> uVar) {
            if (uVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    uVar.subscribe(timeoutConsumer);
                }
            }
        }
    }

    static final class TimeoutObserver<T> extends AtomicLong implements io.reactivex.w<T>, io.reactivex.disposables.b, a {
        private static final long serialVersionUID = 3764492702657003550L;
        final io.reactivex.w<? super T> downstream;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        TimeoutObserver(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<?>> oVar) {
            this.downstream = wVar;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                io.reactivex.e.a.b(th);
            } else {
                this.task.dispose();
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    io.reactivex.disposables.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        io.reactivex.u<?> uVarApply = this.itemTimeoutIndicator.apply(t);
                        io.reactivex.internal.functions.a.a(uVarApply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        io.reactivex.u<?> uVar = uVarApply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            uVar.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.upstream.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long j, Throwable th) {
            if (!compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.e.a.b(th);
            } else {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(th);
            }
        }

        void startFirstTimeout(io.reactivex.u<?> uVar) {
            if (uVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    uVar.subscribe(timeoutConsumer);
                }
            }
        }
    }

    interface a extends ObservableTimeoutTimed.b {
        void onTimeoutError(long j, Throwable th);
    }

    public ObservableTimeout(io.reactivex.p<T> pVar, io.reactivex.u<U> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<V>> oVar, io.reactivex.u<? extends T> uVar2) {
        super(pVar);
        this.f22254b = uVar;
        this.f22255c = oVar;
        this.f22256d = uVar2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        io.reactivex.u<? extends T> uVar = this.f22256d;
        if (uVar == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(wVar, this.f22255c);
            wVar.onSubscribe(timeoutObserver);
            timeoutObserver.startFirstTimeout(this.f22254b);
            this.f22358a.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(wVar, this.f22255c, uVar);
        wVar.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.startFirstTimeout(this.f22254b);
        this.f22358a.subscribe(timeoutFallbackObserver);
    }
}
