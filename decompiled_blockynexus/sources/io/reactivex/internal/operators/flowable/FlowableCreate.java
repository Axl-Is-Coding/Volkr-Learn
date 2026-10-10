package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableCreate<T> extends io.reactivex.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.g<T> f21868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BackpressureStrategy f21869c;

    static abstract class BaseEmitter<T> extends AtomicLong implements io.reactivex.f<T>, f.b.d {
        private static final long serialVersionUID = 7326289992464377023L;
        final f.b.c<? super T> downstream;
        final SequentialDisposable serial = new SequentialDisposable();

        BaseEmitter(f.b.c<? super T> cVar) {
            this.downstream = cVar;
        }

        @Override // f.b.d
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        protected void complete() {
            if (isCancelled()) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        protected boolean error(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.downstream.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        @Override // io.reactivex.f
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // io.reactivex.d
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.d
        public final void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.e.a.b(th);
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        @Override // f.b.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
                onRequested();
            }
        }

        public final long requested() {
            return get();
        }

        public final io.reactivex.f<T> serialize() {
            return new SerializedEmitter(this);
        }

        public final void setCancellable(io.reactivex.b.f fVar) {
            setDisposable(new CancellableDisposable(fVar));
        }

        public final void setDisposable(io.reactivex.disposables.b bVar) {
            this.serial.update(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th) {
            return error(th);
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicInteger wip;

        BufferAsyncEmitter(f.b.c<? super T> cVar, int i) {
            super(cVar);
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            f.b.c<? super T> cVar = this.downstream;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (isCancelled()) {
                        aVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    T tPoll = aVar.poll();
                    boolean z2 = tPoll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(tPoll);
                    j2++;
                }
                if (j2 == j) {
                    if (isCancelled()) {
                        aVar.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean zIsEmpty = aVar.isEmpty();
                    if (z3 && zIsEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    io.reactivex.internal.util.b.c(this, j2);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(f.b.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(f.b.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        LatestAsyncEmitter(f.b.c<? super T> cVar) {
            super(cVar);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
        
            if (r8 != r4) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        
            if (isCancelled() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
        
            r1.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
        
            r4 = r15.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
        
            if (r1.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
        
            if (r4 == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
        
            if (r10 == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
        
            r0 = r15.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0068, code lost:
        
            if (r0 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006a, code lost:
        
            error(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x006e, code lost:
        
            complete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0074, code lost:
        
            if (r8 == 0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
        
            io.reactivex.internal.util.b.c(r15, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
        
            r3 = r15.wip.addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                r15 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r15.wip
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                f.b.c<? super T> r0 = r15.downstream
                java.util.concurrent.atomic.AtomicReference<T> r1 = r15.queue
                r2 = 1
                r3 = 1
            Lf:
                long r4 = r15.get()
                r6 = 0
                r8 = r6
            L16:
                r10 = 0
                r11 = 0
                int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r12 == 0) goto L4b
                boolean r12 = r15.isCancelled()
                if (r12 == 0) goto L26
                r1.lazySet(r11)
                return
            L26:
                boolean r12 = r15.done
                java.lang.Object r13 = r1.getAndSet(r11)
                if (r13 != 0) goto L30
                r14 = 1
                goto L31
            L30:
                r14 = 0
            L31:
                if (r12 == 0) goto L41
                if (r14 == 0) goto L41
                java.lang.Throwable r0 = r15.error
                if (r0 == 0) goto L3d
                r15.error(r0)
                goto L40
            L3d:
                r15.complete()
            L40:
                return
            L41:
                if (r14 == 0) goto L44
                goto L4b
            L44:
                r0.onNext(r13)
                r10 = 1
                long r8 = r8 + r10
                goto L16
            L4b:
                int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r12 != 0) goto L72
                boolean r4 = r15.isCancelled()
                if (r4 == 0) goto L59
                r1.lazySet(r11)
                return
            L59:
                boolean r4 = r15.done
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L62
                r10 = 1
            L62:
                if (r4 == 0) goto L72
                if (r10 == 0) goto L72
                java.lang.Throwable r0 = r15.error
                if (r0 == 0) goto L6e
                r15.error(r0)
                goto L71
            L6e:
                r15.complete()
            L71:
                return
            L72:
                int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r4 == 0) goto L79
                io.reactivex.internal.util.b.c(r15, r8)
            L79:
                java.util.concurrent.atomic.AtomicInteger r4 = r15.wip
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.LatestAsyncEmitter.drain():void");
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.d
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(f.b.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            long j;
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.downstream.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(f.b.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.d
        public final void onNext(T t) {
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                onOverflow();
            } else {
                this.downstream.onNext(t);
                io.reactivex.internal.util.b.c(this, 1L);
            }
        }

        abstract void onOverflow();
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements io.reactivex.f<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final io.reactivex.c.a.j<T> queue = new io.reactivex.internal.queue.a(16);

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.emitter = baseEmitter;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            BaseEmitter<T> baseEmitter = this.emitter;
            io.reactivex.c.a.j<T> jVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int iAddAndGet = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    jVar.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                T tPoll = jVar.poll();
                boolean z2 = tPoll == null;
                if (z && z2) {
                    baseEmitter.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(tPoll);
                }
            }
            jVar.clear();
        }

        @Override // io.reactivex.f
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.d
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.e.a.b(th);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.c.a.j<T> jVar = this.queue;
                synchronized (jVar) {
                    jVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public long requested() {
            return this.emitter.requested();
        }

        public io.reactivex.f<T> serialize() {
            return this;
        }

        public void setCancellable(io.reactivex.b.f fVar) {
            this.emitter.setCancellable(fVar);
        }

        public void setDisposable(io.reactivex.disposables.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isCancelled() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableCreate(io.reactivex.g<T> gVar, BackpressureStrategy backpressureStrategy) {
        this.f21868b = gVar;
        this.f21869c = backpressureStrategy;
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
    @Override // io.reactivex.e
    public void b(f.b.c<? super T> cVar) {
        int i = c.f21904a[this.f21869c.ordinal()];
        BaseEmitter bufferAsyncEmitter = i != 1 ? i != 2 ? i != 3 ? i != 4 ? new BufferAsyncEmitter(cVar, io.reactivex.e.a()) : new LatestAsyncEmitter(cVar) : new DropAsyncEmitter(cVar) : new ErrorAsyncEmitter(cVar) : new MissingEmitter(cVar);
        cVar.onSubscribe(bufferAsyncEmitter);
        try {
            this.f21868b.a(bufferAsyncEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            bufferAsyncEmitter.onError(th);
        }
    }
}
