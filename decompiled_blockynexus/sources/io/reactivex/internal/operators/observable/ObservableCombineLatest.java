package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableCombineLatest<T, R> extends io.reactivex.p<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<? extends T>[] f22084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends io.reactivex.u<? extends T>> f22085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super Object[], ? extends R> f22086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f22088e;

    static final class CombinerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final io.reactivex.b.o<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final io.reactivex.w<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final io.reactivex.internal.queue.a<Object[]> queue;

        LatestCoordinator(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i, int i2, boolean z) {
            this.downstream = wVar;
            this.combiner = oVar;
            this.delayError = z;
            this.latest = new Object[i];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i];
            for (int i3 = 0; i3 < i; i3++) {
                combinerObserverArr[i3] = new CombinerObserver<>(this, i3);
            }
            this.observers = combinerObserverArr;
            this.queue = new io.reactivex.internal.queue.a<>(i2);
        }

        void cancelSources() {
            for (CombinerObserver<T, R> combinerObserver : this.observers) {
                combinerObserver.dispose();
            }
        }

        void clear(io.reactivex.internal.queue.a<?> aVar) {
            synchronized (this) {
                this.latest = null;
            }
            aVar.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear(this.queue);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.a<Object[]> aVar = this.queue;
            io.reactivex.w<? super R> wVar = this.downstream;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!z && this.errors.get() != null) {
                    cancelSources();
                    clear(aVar);
                    wVar.onError(this.errors.terminate());
                    return;
                }
                boolean z2 = this.done;
                Object[] objArrPoll = aVar.poll();
                boolean z3 = objArrPoll == null;
                if (z2 && z3) {
                    clear(aVar);
                    Throwable thTerminate = this.errors.terminate();
                    if (thTerminate == null) {
                        wVar.onComplete();
                        return;
                    } else {
                        wVar.onError(thTerminate);
                        return;
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        R rApply = this.combiner.apply(objArrPoll);
                        io.reactivex.internal.functions.a.a(rApply, "The combiner returned a null value");
                        wVar.onNext(rApply);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.errors.addThrowable(th);
                        cancelSources();
                        clear(aVar);
                        wVar.onError(this.errors.terminate());
                        return;
                    }
                }
            }
            clear(aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0019 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0007, B:12:0x0011, B:15:0x001b, B:14:0x0019), top: B:23:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerComplete(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = 1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.complete     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.complete = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.done = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.cancelSources()
            L21:
                r3.drain()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerComplete(int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0025 A[Catch: all -> 0x0029, TryCatch #0 {, blocks: (B:7:0x000e, B:9:0x0012, B:11:0x0014, B:16:0x001d, B:19:0x0027, B:18:0x0025), top: B:30:0x000e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerError(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.errors
                boolean r0 = r0.addThrowable(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L2c
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch: java.lang.Throwable -> L29
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L29
                if (r3 != 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.complete     // Catch: java.lang.Throwable -> L29
                int r1 = r1 + r0
                r2.complete = r1     // Catch: java.lang.Throwable -> L29
                int r4 = r4.length     // Catch: java.lang.Throwable -> L29
                if (r1 != r4) goto L27
            L25:
                r2.done = r0     // Catch: java.lang.Throwable -> L29
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                goto L2d
            L29:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                throw r3
            L2c:
                r3 = 1
            L2d:
                if (r3 == 0) goto L32
                r2.cancelSources()
            L32:
                r2.drain()
                goto L39
            L36:
                io.reactivex.e.a.b(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.innerError(int, java.lang.Throwable):void");
        }

        void innerNext(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i];
                int i2 = this.active;
                if (obj == null) {
                    i2++;
                    this.active = i2;
                }
                objArr[i] = t;
                if (i2 == objArr.length) {
                    this.queue.offer((Object[]) objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    drain();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(io.reactivex.u<? extends T>[] uVarArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.downstream.onSubscribe(this);
            for (int i = 0; i < length && !this.done && !this.cancelled; i++) {
                uVarArr[i].subscribe(combinerObserverArr[i]);
            }
        }
    }

    public ObservableCombineLatest(io.reactivex.u<? extends T>[] uVarArr, Iterable<? extends io.reactivex.u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i, boolean z) {
        this.f22084a = uVarArr;
        this.f22085b = iterable;
        this.f22086c = oVar;
        this.f22087d = i;
        this.f22088e = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super R> wVar) {
        int length;
        io.reactivex.u<? extends T>[] uVarArr = this.f22084a;
        if (uVarArr == null) {
            uVarArr = new io.reactivex.p[8];
            length = 0;
            for (io.reactivex.u<? extends T> uVar : this.f22085b) {
                if (length == uVarArr.length) {
                    io.reactivex.u<? extends T>[] uVarArr2 = new io.reactivex.u[(length >> 2) + length];
                    System.arraycopy(uVarArr, 0, uVarArr2, 0, length);
                    uVarArr = uVarArr2;
                }
                uVarArr[length] = uVar;
                length++;
            }
        } else {
            length = uVarArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptyDisposable.complete(wVar);
        } else {
            new LatestCoordinator(wVar, this.f22086c, i, this.f22087d, this.f22088e).subscribe(uVarArr);
        }
    }
}
