package io.reactivex.processors;

import f.b.c;
import f.b.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
public final class BehaviorProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object[] f22755b = new Object[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final BehaviorSubscription[] f22756c = new BehaviorSubscription[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final BehaviorSubscription[] f22757d = new BehaviorSubscription[0];
    long k;
    final AtomicReference<Object> i = new AtomicReference<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ReadWriteLock f22759f = new ReentrantReadWriteLock();
    final Lock g = this.f22759f.readLock();
    final Lock h = this.f22759f.writeLock();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final AtomicReference<BehaviorSubscription<T>[]> f22758e = new AtomicReference<>(f22756c);
    final AtomicReference<Throwable> j = new AtomicReference<>();

    static final class BehaviorSubscription<T> extends AtomicLong implements d, a.InterfaceC0208a<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final c<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.a<Object> queue;
        final BehaviorProcessor<T> state;

        BehaviorSubscription(c<? super T> cVar, BehaviorProcessor<T> behaviorProcessor) {
            this.downstream = cVar;
            this.state = behaviorProcessor;
        }

        @Override // f.b.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b((BehaviorSubscription) this);
        }

        void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorProcessor<T> behaviorProcessor = this.state;
                Lock lock = behaviorProcessor.g;
                lock.lock();
                this.index = behaviorProcessor.k;
                Object obj = behaviorProcessor.i.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        void emitLoop() {
            io.reactivex.internal.util.a<Object> aVar;
            while (!this.cancelled) {
                synchronized (this) {
                    aVar = this.queue;
                    if (aVar == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                aVar.a((a.InterfaceC0208a<? super Object>) this);
            }
        }

        void emitNext(Object obj, long j) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        io.reactivex.internal.util.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.a(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        public boolean isFull() {
            return get() == 0;
        }

        @Override // f.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // io.reactivex.internal.util.a.InterfaceC0208a, io.reactivex.b.q
        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.downstream.onComplete();
                return true;
            }
            if (NotificationLite.isError(obj)) {
                this.downstream.onError(NotificationLite.getError(obj));
                return true;
            }
            long j = get();
            if (j == 0) {
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
            c<? super T> cVar = this.downstream;
            NotificationLite.getValue(obj);
            cVar.onNext(obj);
            if (j == Long.MAX_VALUE) {
                return false;
            }
            decrementAndGet();
            return false;
        }
    }

    BehaviorProcessor() {
    }

    public static <T> BehaviorProcessor<T> i() {
        return new BehaviorProcessor<>();
    }

    boolean a(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.f22758e.get();
            if (behaviorSubscriptionArr == f22757d) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[length + 1];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!this.f22758e.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    @Override // io.reactivex.e
    protected void b(c<? super T> cVar) {
        BehaviorSubscription<T> behaviorSubscription = new BehaviorSubscription<>(cVar, this);
        cVar.onSubscribe(behaviorSubscription);
        if (a((BehaviorSubscription) behaviorSubscription)) {
            if (behaviorSubscription.cancelled) {
                b((BehaviorSubscription) behaviorSubscription);
                return;
            } else {
                behaviorSubscription.emitFirst();
                return;
            }
        }
        Throwable th = this.j.get();
        if (th == ExceptionHelper.f22722a) {
            cVar.onComplete();
        } else {
            cVar.onError(th);
        }
    }

    BehaviorSubscription<T>[] c(Object obj) {
        BehaviorSubscription<T>[] andSet = this.f22758e.get();
        BehaviorSubscription<T>[] behaviorSubscriptionArr = f22757d;
        if (andSet != behaviorSubscriptionArr && (andSet = this.f22758e.getAndSet(behaviorSubscriptionArr)) != f22757d) {
            b(obj);
        }
        return andSet;
    }

    @Override // f.b.c
    public void onComplete() {
        if (this.j.compareAndSet(null, ExceptionHelper.f22722a)) {
            Object objComplete = NotificationLite.complete();
            for (BehaviorSubscription<T> behaviorSubscription : c(objComplete)) {
                behaviorSubscription.emitNext(objComplete, this.k);
            }
        }
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.j.compareAndSet(null, th)) {
            io.reactivex.e.a.b(th);
            return;
        }
        Object objError = NotificationLite.error(th);
        for (BehaviorSubscription<T> behaviorSubscription : c(objError)) {
            behaviorSubscription.emitNext(objError, this.k);
        }
    }

    @Override // f.b.c
    public void onNext(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.j.get() != null) {
            return;
        }
        NotificationLite.next(t);
        b(t);
        for (BehaviorSubscription<T> behaviorSubscription : this.f22758e.get()) {
            behaviorSubscription.emitNext(t, this.k);
        }
    }

    @Override // f.b.c
    public void onSubscribe(d dVar) {
        if (this.j.get() != null) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    void b(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.f22758e.get();
            int length = behaviorSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (behaviorSubscriptionArr[i2] == behaviorSubscription) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                behaviorSubscriptionArr2 = f22756c;
            } else {
                BehaviorSubscription<T>[] behaviorSubscriptionArr3 = new BehaviorSubscription[length - 1];
                System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i);
                System.arraycopy(behaviorSubscriptionArr, i + 1, behaviorSubscriptionArr3, i, (length - i) - 1);
                behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
            }
        } while (!this.f22758e.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    void b(Object obj) {
        Lock lock = this.h;
        lock.lock();
        this.k++;
        this.i.lazySet(obj);
        lock.unlock();
    }
}
