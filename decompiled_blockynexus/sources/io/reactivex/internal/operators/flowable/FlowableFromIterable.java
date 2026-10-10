package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFromIterable<T> extends io.reactivex.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends T> f21875b;

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.it = it;
        }

        @Override // f.b.d
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.c.a.k
        public final void clear() {
            this.it = null;
        }

        abstract void fastPath();

        @Override // io.reactivex.c.a.k
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.it;
            return it == null || !it.hasNext();
        }

        @Override // io.reactivex.c.a.k
        public final T poll() {
            Iterator<? extends T> it = this.it;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            T next = this.it.next();
            io.reactivex.internal.functions.a.a((Object) next, "Iterator.next() returned a null value");
            return next;
        }

        @Override // f.b.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // io.reactivex.c.a.g
        public final int requestFusion(int i) {
            return i & 1;
        }

        abstract void slowPath(long j);
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final io.reactivex.c.a.a<? super T> downstream;

        IteratorConditionalSubscription(io.reactivex.c.a.a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            io.reactivex.c.a.a<? super T> aVar = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.tryOnNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                io.reactivex.c.a.a<? super T> r1 = r8.downstream
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L54
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4c
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                boolean r6 = r1.tryOnNext(r6)
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L30
                return
            L30:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L44
                if (r7 != 0) goto L3e
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3d
                r1.onComplete()
            L3d:
                return
            L3e:
                if (r6 == 0) goto L8
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L44:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L4c:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L54:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorConditionalSubscription.slowPath(long):void");
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final f.b.c<? super T> downstream;

        IteratorSubscription(f.b.c<? super T> cVar, Iterator<? extends T> it) {
            super(it);
            this.downstream = cVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            f.b.c<? super T> cVar = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    cVar.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        cVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void slowPath(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.it
                f.b.c<? super T> r1 = r8.downstream
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L51
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L49
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L27:
                r1.onNext(r6)
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L2f
                return
            L2f:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L41
                if (r6 != 0) goto L3d
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L41:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L49:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L51:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorSubscription.slowPath(long):void");
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f21875b = iterable;
    }

    public static <T> void a(f.b.c<? super T> cVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(cVar);
            } else if (cVar instanceof io.reactivex.c.a.a) {
                cVar.onSubscribe(new IteratorConditionalSubscription((io.reactivex.c.a.a) cVar, it));
            } else {
                cVar.onSubscribe(new IteratorSubscription(cVar, it));
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptySubscription.error(th, cVar);
        }
    }

    @Override // io.reactivex.e
    public void b(f.b.c<? super T> cVar) {
        try {
            a(cVar, this.f21875b.iterator());
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptySubscription.error(th, cVar);
        }
    }
}
