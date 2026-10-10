package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.x;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableObserveOn<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.x f22149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f22150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22151d;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements io.reactivex.w<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.w<? super T> downstream;
        Throwable error;
        boolean outputFused;
        io.reactivex.c.a.k<T> queue;
        int sourceMode;
        io.reactivex.disposables.b upstream;
        final x.c worker;

        ObserveOnObserver(io.reactivex.w<? super T> wVar, x.c cVar, boolean z, int i) {
            this.downstream = wVar;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i;
        }

        boolean checkTerminated(boolean z, boolean z2, io.reactivex.w<? super T> wVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (this.delayError) {
                if (!z2) {
                    return false;
                }
                this.disposed = true;
                if (th != null) {
                    wVar.onError(th);
                } else {
                    wVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            if (th != null) {
                this.disposed = true;
                this.queue.clear();
                wVar.onError(th);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.disposed = true;
            wVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drainFused() {
            int iAddAndGet = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.disposed = true;
                    this.downstream.onError(th);
                    this.worker.dispose();
                    return;
                }
                this.downstream.onNext(null);
                if (z) {
                    this.disposed = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drainNormal() {
            /*
                r7 = this;
                io.reactivex.c.a.k<T> r0 = r7.queue
                io.reactivex.w<? super T> r1 = r7.downstream
                r2 = 1
                r3 = 1
            L6:
                boolean r4 = r7.done
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.checkTerminated(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.done
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = 1
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.checkTerminated(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r3 = move-exception
                io.reactivex.exceptions.a.b(r3)
                r7.disposed = r2
                io.reactivex.disposables.b r2 = r7.upstream
                r2.dispose()
                r0.clear()
                r1.onError(r3)
                io.reactivex.x$c r0 = r7.worker
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.drainNormal():void");
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            schedule();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.c.a.f) {
                    io.reactivex.c.a.f fVar = (io.reactivex.c.a.f) bVar;
                    int iRequestFusion = fVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = fVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.a(this);
            }
        }
    }

    public ObservableObserveOn(io.reactivex.u<T> uVar, io.reactivex.x xVar, boolean z, int i) {
        super(uVar);
        this.f22149b = xVar;
        this.f22150c = z;
        this.f22151d = i;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        io.reactivex.x xVar = this.f22149b;
        if (xVar instanceof io.reactivex.internal.schedulers.j) {
            this.f22358a.subscribe(wVar);
        } else {
            this.f22358a.subscribe(new ObserveOnObserver(wVar, xVar.a(), this.f22150c, this.f22151d));
        }
    }
}
