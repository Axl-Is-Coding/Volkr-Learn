package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableGenerate<T, S> extends io.reactivex.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<S> f21876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.c<S, io.reactivex.d<T>, S> f21877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.b.g<? super S> f21878d;

    static final class GeneratorSubscription<T, S> extends AtomicLong implements io.reactivex.d<T>, f.b.d {
        private static final long serialVersionUID = 7565982551505011832L;
        volatile boolean cancelled;
        final io.reactivex.b.g<? super S> disposeState;
        final f.b.c<? super T> downstream;
        final io.reactivex.b.c<S, ? super io.reactivex.d<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(f.b.c<? super T> cVar, io.reactivex.b.c<S, ? super io.reactivex.d<T>, S> cVar2, io.reactivex.b.g<? super S> gVar, S s) {
            this.downstream = cVar;
            this.generator = cVar2;
            this.disposeState = gVar;
            this.state = s;
        }

        private void dispose(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(th);
            }
        }

        @Override // f.b.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (io.reactivex.internal.util.b.a(this, 1L) == 0) {
                S s = this.state;
                this.state = null;
                dispose(s);
            }
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.downstream.onComplete();
        }

        @Override // io.reactivex.d
        public void onError(Throwable th) {
            if (this.terminate) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.downstream.onNext(t);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        
            r9.state = r0;
            r4 = addAndGet(-r10);
         */
        @Override // f.b.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void request(long r10) {
            /*
                r9 = this;
                boolean r0 = io.reactivex.internal.subscriptions.SubscriptionHelper.validate(r10)
                if (r0 != 0) goto L7
                return
            L7:
                long r0 = io.reactivex.internal.util.b.a(r9, r10)
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L12
                return
            L12:
                S r0 = r9.state
                io.reactivex.b.c<S, ? super io.reactivex.d<T>, S> r1 = r9.generator
                r4 = r10
            L17:
                r10 = r2
            L18:
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 == 0) goto L4e
                boolean r6 = r9.cancelled
                r7 = 0
                if (r6 == 0) goto L27
                r9.state = r7
                r9.dispose(r0)
                return
            L27:
                r6 = 0
                r9.hasNext = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3f
                boolean r8 = r9.terminate
                if (r8 == 0) goto L3b
                r9.cancelled = r6
                r9.state = r7
                r9.dispose(r0)
                return
            L3b:
                r6 = 1
                long r10 = r10 + r6
                goto L18
            L3f:
                r10 = move-exception
                io.reactivex.exceptions.a.b(r10)
                r9.cancelled = r6
                r9.state = r7
                r9.onError(r10)
                r9.dispose(r0)
                return
            L4e:
                long r4 = r9.get()
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 != 0) goto L18
                r9.state = r0
                long r10 = -r10
                long r4 = r9.addAndGet(r10)
                int r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r10 != 0) goto L17
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableGenerate.GeneratorSubscription.request(long):void");
        }
    }

    public FlowableGenerate(Callable<S> callable, io.reactivex.b.c<S, io.reactivex.d<T>, S> cVar, io.reactivex.b.g<? super S> gVar) {
        this.f21876b = callable;
        this.f21877c = cVar;
        this.f21878d = gVar;
    }

    @Override // io.reactivex.e
    public void b(f.b.c<? super T> cVar) {
        try {
            cVar.onSubscribe(new GeneratorSubscription(cVar, this.f21877c, this.f21878d, this.f21876b.call()));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptySubscription.error(th, cVar);
        }
    }
}
