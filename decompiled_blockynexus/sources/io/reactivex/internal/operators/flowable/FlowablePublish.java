package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowablePublish<T> extends io.reactivex.a.a<T> implements io.reactivex.c.a.e<T>, l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.e<T> f21888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<PublishSubscriber<T>> f21889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f21890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final f.b.b<T> f21891e;

    static final class InnerSubscriber<T> extends AtomicLong implements f.b.d {
        private static final long serialVersionUID = -4453897557930727610L;
        final f.b.c<? super T> child;
        long emitted;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(f.b.c<? super T> cVar) {
            this.child = cVar;
        }

        @Override // f.b.d
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (publishSubscriber = this.parent) == null) {
                return;
            }
            publishSubscriber.remove(this);
            publishSubscriber.dispatch();
        }

        @Override // f.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.b(this, j);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    static final class PublishSubscriber<T> extends AtomicInteger implements io.reactivex.h<T>, io.reactivex.disposables.b {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile io.reactivex.c.a.k<T> queue;
        int sourceMode;
        volatile Object terminalEvent;
        final AtomicReference<f.b.d> upstream = new AtomicReference<>();
        final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber<T>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                    } else {
                        io.reactivex.e.a.b(error);
                    }
                    return true;
                }
                if (z) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i < length2) {
                        andSet2[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x0127, code lost:
        
            if (r8 == 0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x012c, code lost:
        
            if (r25.sourceMode == 1) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x012e, code lost:
        
            r25.upstream.get().request(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x013a, code lost:
        
            r4 = r0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void dispatch() {
            /*
                Method dump skipped, instruction units count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.dispatch():void");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr == innerSubscriberArr2 || this.subscribers.getAndSet(innerSubscriberArr2) == TERMINATED) {
                return;
            }
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // f.b.c
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            if (this.terminalEvent != null) {
                io.reactivex.e.a.b(th);
            } else {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            }
        }

        @Override // f.b.c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                if (dVar instanceof io.reactivex.c.a.h) {
                    io.reactivex.c.a.h hVar = (io.reactivex.c.a.h) dVar;
                    int iRequestFusion = hVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = hVar;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = hVar;
                        dVar.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                dVar.request(this.bufferSize);
            }
        }

        void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber<T>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber<T>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }
    }

    static final class a<T> implements f.b.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicReference<PublishSubscriber<T>> f21892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f21893b;

        a(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.f21892a = atomicReference;
            this.f21893b = i;
        }

        @Override // f.b.b
        public void a(f.b.c<? super T> cVar) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber<T> innerSubscriber = new InnerSubscriber<>(cVar);
            cVar.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.f21892a.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f21892a, this.f21893b);
                    if (this.f21892a.compareAndSet(publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    } else {
                        continue;
                    }
                }
                if (publishSubscriber.add(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.remove(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.dispatch();
        }
    }

    private FlowablePublish(f.b.b<T> bVar, io.reactivex.e<T> eVar, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.f21891e = bVar;
        this.f21888b = eVar;
        this.f21889c = atomicReference;
        this.f21890d = i;
    }

    public static <T> io.reactivex.a.a<T> a(io.reactivex.e<T> eVar, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.e.a.a((io.reactivex.a.a) new FlowablePublish(new a(atomicReference, i), eVar, atomicReference, i));
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        this.f21891e.a(cVar);
    }

    @Override // io.reactivex.a.a
    public void e(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.f21889c.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f21889c, this.f21890d);
            if (this.f21889c.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = !publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(publishSubscriber);
            if (z) {
                this.f21888b.a((io.reactivex.h) publishSubscriber);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw ExceptionHelper.b(th);
        }
    }
}
