package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMap<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> f22237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f22238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f22239d;

    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        volatile io.reactivex.c.a.k<R> queue;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int i) {
            this.parent = switchMapObserver;
            this.index = j;
            this.bufferSize = i;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // io.reactivex.w
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                if (r != null) {
                    this.queue.offer(r);
                }
                this.parent.drain();
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                if (bVar instanceof io.reactivex.c.a.f) {
                    io.reactivex.c.a.f fVar = (io.reactivex.c.a.f) bVar;
                    int iRequestFusion = fVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.queue = fVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (iRequestFusion == 2) {
                        this.queue = fVar;
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
            }
        }
    }

    static final class SwitchMapObserver<T, R> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED = new SwitchMapInnerObserver<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final io.reactivex.w<? super R> downstream;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> mapper;
        volatile long unique;
        io.reactivex.disposables.b upstream;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            CANCELLED.cancel();
        }

        SwitchMapObserver(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar, int i, boolean z) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.bufferSize = i;
            this.delayErrors = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
        }

        void disposeInner() {
            SwitchMapInnerObserver<T, R> andSet;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver = this.active.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver2 = CANCELLED;
            if (switchMapInnerObserver == switchMapInnerObserver2 || (andSet = this.active.getAndSet((SwitchMapInnerObserver<T, R>) switchMapInnerObserver2)) == CANCELLED || andSet == null) {
                return;
            }
            andSet.cancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x00e9 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.drain():void");
        }

        void innerError(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.index != this.unique || !this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
            }
            switchMapInnerObserver.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.done || !this.errors.addThrowable(th)) {
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
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                io.reactivex.u<? extends R> uVarApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(uVarApply, "The ObservableSource returned is null");
                io.reactivex.u<? extends R> uVar = uVarApply;
                SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = new SwitchMapInnerObserver<>(this, j, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerObserver, switchMapInnerObserver3));
                uVar.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar, int i, boolean z) {
        super(uVar);
        this.f22237b = oVar;
        this.f22238c = i;
        this.f22239d = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super R> wVar) {
        if (ObservableScalarXMap.a(this.f22358a, wVar, this.f22237b)) {
            return;
        }
        this.f22358a.subscribe(new SwitchMapObserver(wVar, this.f22237b, this.f22238c, this.f22239d));
    }
}
