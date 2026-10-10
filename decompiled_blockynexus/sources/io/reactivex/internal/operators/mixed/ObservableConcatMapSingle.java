package io.reactivex.internal.operators.mixed;

import io.reactivex.A;
import io.reactivex.b.o;
import io.reactivex.c.a.j;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.p;
import io.reactivex.w;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMapSingle<T, R> extends p<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final p<T> f21966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends A<? extends R>> f21967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f21968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f21969d;

    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements w<T>, b {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final w<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
        R item;
        final o<? super T, ? extends A<? extends R>> mapper;
        final j<T> queue;
        volatile int state;
        b upstream;

        static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements z<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleMainObserver<?, R> parent;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.parent = concatMapSingleMainObserver;
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.z, io.reactivex.k
            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }
        }

        ConcatMapSingleMainObserver(w<? super R> wVar, o<? super T, ? extends A<? extends R>> oVar, int i, ErrorMode errorMode) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.errorMode = errorMode;
            this.queue = new io.reactivex.internal.queue.a(i);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            r2.clear();
            r10.item = null;
            r0.onError(r3.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                r10 = this;
                int r0 = r10.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                io.reactivex.w<? super R> r0 = r10.downstream
                io.reactivex.internal.util.ErrorMode r1 = r10.errorMode
                io.reactivex.c.a.j<T> r2 = r10.queue
                io.reactivex.internal.util.AtomicThrowable r3 = r10.errors
                r4 = 1
                r5 = 1
            L11:
                boolean r6 = r10.cancelled
                r7 = 0
                if (r6 == 0) goto L1d
                r2.clear()
                r10.item = r7
                goto L97
            L1d:
                int r6 = r10.state
                java.lang.Object r8 = r3.get()
                if (r8 == 0) goto L3c
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r8) goto L2f
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r8) goto L3c
                if (r6 != 0) goto L3c
            L2f:
                r2.clear()
                r10.item = r7
                java.lang.Throwable r1 = r3.terminate()
                r0.onError(r1)
                return
            L3c:
                r8 = 0
                if (r6 != 0) goto L89
                boolean r6 = r10.done
                java.lang.Object r7 = r2.poll()
                if (r7 != 0) goto L48
                r8 = 1
            L48:
                if (r6 == 0) goto L5a
                if (r8 == 0) goto L5a
                java.lang.Throwable r1 = r3.terminate()
                if (r1 != 0) goto L56
                r0.onComplete()
                goto L59
            L56:
                r0.onError(r1)
            L59:
                return
            L5a:
                if (r8 == 0) goto L5d
                goto L97
            L5d:
                io.reactivex.b.o<? super T, ? extends io.reactivex.A<? extends R>> r6 = r10.mapper     // Catch: java.lang.Throwable -> L72
                java.lang.Object r6 = r6.apply(r7)     // Catch: java.lang.Throwable -> L72
                java.lang.String r7 = "The mapper returned a null SingleSource"
                io.reactivex.internal.functions.a.a(r6, r7)     // Catch: java.lang.Throwable -> L72
                io.reactivex.A r6 = (io.reactivex.A) r6     // Catch: java.lang.Throwable -> L72
                r10.state = r4
                io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver<R> r7 = r10.inner
                r6.a(r7)
                goto L97
            L72:
                r1 = move-exception
                io.reactivex.exceptions.a.b(r1)
                io.reactivex.disposables.b r4 = r10.upstream
                r4.dispose()
                r2.clear()
                r3.addThrowable(r1)
                java.lang.Throwable r1 = r3.terminate()
                r0.onError(r1)
                return
            L89:
                r9 = 2
                if (r6 != r9) goto L97
                R r6 = r10.item
                r10.item = r7
                r0.onNext(r6)
                r10.state = r8
                goto L11
            L97:
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableConcatMapSingle.ConcatMapSingleMainObserver.drain():void");
        }

        void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (this.errorMode != ErrorMode.END) {
                this.upstream.dispose();
            }
            this.state = 0;
            drain();
        }

        void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
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
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.dispose();
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(p<T> pVar, o<? super T, ? extends A<? extends R>> oVar, ErrorMode errorMode, int i) {
        this.f21966a = pVar;
        this.f21967b = oVar;
        this.f21968c = errorMode;
        this.f21969d = i;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super R> wVar) {
        if (a.b(this.f21966a, this.f21967b, wVar)) {
            return;
        }
        this.f21966a.subscribe(new ConcatMapSingleMainObserver(wVar, this.f21967b, this.f21969d, this.f21968c));
    }
}
