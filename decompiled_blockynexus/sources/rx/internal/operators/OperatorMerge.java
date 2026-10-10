package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: loaded from: classes5.dex */
public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        HolderDelayErrors() {
        }
    }

    static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        HolderNoDelay() {
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = RxRingBuffer.SIZE / 4;
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.parent = mergeSubscriber;
            this.id = j;
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.done = true;
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            this.done = true;
            this.parent.getOrCreateErrorQueue().offer(th);
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onNext(T t) throws Throwable {
            this.parent.tryEmit(this, t);
        }

        @Override // rx.Subscriber
        public void onStart() {
            int i = RxRingBuffer.SIZE;
            this.outstanding = i;
            request(i);
        }

        public void requestMore(long j) {
            int i = this.outstanding - ((int) j);
            if (i > LIMIT) {
                this.outstanding = i;
                return;
            }
            int i2 = RxRingBuffer.SIZE;
            this.outstanding = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                request(i3);
            }
        }
    }

    static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        public long produced(int i) {
            return addAndGet(-i);
        }

        @Override // rx.Producer
        public void request(long j) throws Throwable {
            if (j <= 0) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                BackpressureUtils.getAndAddRequest(this, j);
                this.subscriber.emit();
            }
        }
    }

    static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.delayErrors = z;
            this.maxConcurrent = i;
            if (i == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
            } else {
                this.scalarEmissionLimit = Math.max(1, i >> 1);
                request(i);
            }
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (this.delayErrors || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }

        void emit() throws Throwable {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    emitLoop();
                }
            }
        }

        void emitEmpty() {
            int i = this.scalarEmissionCount + 1;
            if (i != this.scalarEmissionLimit) {
                this.scalarEmissionCount = i;
            } else {
                this.scalarEmissionCount = 0;
                requestMore(i);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:139:0x0196, code lost:
        
            r22.lastIndex = r2;
            r22.lastId = r5[r2].id;
            r0 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
        
            if (r2 <= 0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
        
            if (r10 == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
        
            r6 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007e, code lost:
        
            r6 = r22.producer.produced(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
        
            if (r6 == 0) goto L207;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0088, code lost:
        
            if (r0 != null) goto L45;
         */
        /* JADX WARN: Removed duplicated region for block: B:169:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:218:0x0194 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x00f8 A[Catch: all -> 0x01cc, TryCatch #7 {all -> 0x01cc, blocks: (B:3:0x0002, B:4:0x0004, B:7:0x000b, B:17:0x002e, B:22:0x003e, B:23:0x0042, B:36:0x0067, B:27:0x0049, B:29:0x004d, B:35:0x0060, B:40:0x007e, B:47:0x0095, B:50:0x00a0, B:53:0x00a8, B:55:0x00ac, B:58:0x00b3, B:59:0x00b7, B:62:0x00bd, B:64:0x00c3, B:72:0x00d7, B:75:0x00e0, B:79:0x00e7, B:80:0x00ea, B:83:0x00f8, B:86:0x00ff, B:90:0x0108, B:93:0x010f, B:96:0x0114, B:99:0x011f, B:101:0x0125, B:114:0x0147, B:116:0x0153, B:122:0x0166, B:125:0x016e, B:127:0x0174, B:130:0x017e, B:139:0x0196, B:142:0x01a7, B:145:0x01b0, B:134:0x0188, B:137:0x018d), top: B:192:0x0002 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void emitLoop() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 477
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitLoop():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void emitScalar(rx.internal.operators.OperatorMerge.InnerSubscriber<T> r5, T r6, long r7) throws java.lang.Throwable {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.Subscriber<? super T> r2 = r4.child     // Catch: java.lang.Throwable -> L8 java.lang.Throwable -> Lb
                r2.onNext(r6)     // Catch: java.lang.Throwable -> L8 java.lang.Throwable -> Lb
                goto L23
            L8:
                r5 = move-exception
                r0 = 0
                goto L49
            Lb:
                r6 = move-exception
                boolean r2 = r4.delayErrors     // Catch: java.lang.Throwable -> L8
                if (r2 != 0) goto L1c
                rx.exceptions.Exceptions.throwIfFatal(r6)     // Catch: java.lang.Throwable -> L8
                r5.unsubscribe()     // Catch: java.lang.Throwable -> L1a
                r5.onError(r6)     // Catch: java.lang.Throwable -> L1a
                return
            L1a:
                r5 = move-exception
                goto L49
            L1c:
                java.util.Queue r2 = r4.getOrCreateErrorQueue()     // Catch: java.lang.Throwable -> L8
                r2.offer(r6)     // Catch: java.lang.Throwable -> L8
            L23:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 == 0) goto L31
                rx.internal.operators.OperatorMerge$MergeProducer<T> r6 = r4.producer     // Catch: java.lang.Throwable -> L8
                r6.produced(r0)     // Catch: java.lang.Throwable -> L8
            L31:
                r6 = 1
                r5.requestMore(r6)     // Catch: java.lang.Throwable -> L8
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L8
                boolean r5 = r4.missed     // Catch: java.lang.Throwable -> L46
                if (r5 != 0) goto L3f
                r4.emitting = r1     // Catch: java.lang.Throwable -> L46
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L46
                return
            L3f:
                r4.missed = r1     // Catch: java.lang.Throwable -> L46
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L46
                r4.emitLoop()
                return
            L46:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L46
                throw r5     // Catch: java.lang.Throwable -> L1a
            L49:
                if (r0 != 0) goto L53
                monitor-enter(r4)
                r4.emitting = r1     // Catch: java.lang.Throwable -> L50
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L50
                goto L53
            L50:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L50
                throw r5
            L53:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(rx.internal.operators.OperatorMerge$InnerSubscriber, java.lang.Object, long):void");
        }

        CompositeSubscription getOrCreateComposite() {
            CompositeSubscription compositeSubscription;
            CompositeSubscription compositeSubscription2 = this.subscriptions;
            if (compositeSubscription2 != null) {
                return compositeSubscription2;
            }
            boolean z = false;
            synchronized (this) {
                compositeSubscription = this.subscriptions;
                if (compositeSubscription == null) {
                    CompositeSubscription compositeSubscription3 = new CompositeSubscription();
                    this.subscriptions = compositeSubscription3;
                    compositeSubscription = compositeSubscription3;
                    z = true;
                }
            }
            if (z) {
                add(compositeSubscription);
            }
            return compositeSubscription;
        }

        Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.errors;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.errors = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            getOrCreateErrorQueue().offer(th);
            this.done = true;
            emit();
        }

        protected void queueScalar(InnerSubscriber<T> innerSubscriber, T t) throws Throwable {
            RxRingBuffer spscInstance = innerSubscriber.queue;
            if (spscInstance == null) {
                spscInstance = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(spscInstance);
                innerSubscriber.queue = spscInstance;
            }
            try {
                spscInstance.onNext(NotificationLite.next(t));
            } catch (IllegalStateException e2) {
                if (innerSubscriber.isUnsubscribed()) {
                    return;
                }
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e2);
            } catch (MissingBackpressureException e3) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e3);
            }
        }

        void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriber.equals(innerSubscriberArr[i2])) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    this.innerSubscribers = EMPTY;
                    return;
                }
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length - 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        public void requestMore(long j) {
            request(j);
        }

        void tryEmit(InnerSubscriber<T> innerSubscriber, T t) throws Throwable {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (!z) {
                queueScalar(innerSubscriber, t);
                emit();
                return;
            }
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer == null || rxRingBuffer.isEmpty()) {
                emitScalar(innerSubscriber, t, j);
            } else {
                queueScalar(innerSubscriber, t);
                emitLoop();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) throws Throwable {
            if (observable == null) {
                return;
            }
            if (observable == Observable.empty()) {
                emitEmpty();
                return;
            }
            if (observable instanceof ScalarSynchronousObservable) {
                tryEmit(((ScalarSynchronousObservable) observable).get());
                return;
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
            addInner(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
            emit();
        }

        protected void queueScalar(T t) throws Throwable {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> spscUnboundedAtomicArrayQueue = this.queue;
            if (spscUnboundedAtomicArrayQueue == null) {
                int i = this.maxConcurrent;
                if (i == Integer.MAX_VALUE) {
                    spscUnboundedAtomicArrayQueue = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (Pow2.isPowerOfTwo(i)) {
                        if (UnsafeAccess.isUnsafeAvailable()) {
                            spscExactAtomicArrayQueue = new SpscArrayQueue<>(i);
                        } else {
                            spscExactAtomicArrayQueue = new SpscAtomicArrayQueue<>(i);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                    }
                    spscUnboundedAtomicArrayQueue = spscExactAtomicArrayQueue;
                }
                this.queue = spscUnboundedAtomicArrayQueue;
            }
            if (spscUnboundedAtomicArrayQueue.offer(NotificationLite.next(t))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
        }

        void tryEmit(T t) throws Throwable {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.queue;
                if (queue != null && !queue.isEmpty()) {
                    queueScalar(t);
                    emitLoop();
                    return;
                } else {
                    emitScalar(t, j);
                    return;
                }
            }
            queueScalar(t);
            emit();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0056  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void emitScalar(T r5, long r6) throws java.lang.Throwable {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.Subscriber<? super T> r2 = r4.child     // Catch: java.lang.Throwable -> L8 java.lang.Throwable -> Lb
                r2.onNext(r5)     // Catch: java.lang.Throwable -> L8 java.lang.Throwable -> Lb
                goto L23
            L8:
                r5 = move-exception
                r0 = 0
                goto L54
            Lb:
                r5 = move-exception
                boolean r2 = r4.delayErrors     // Catch: java.lang.Throwable -> L8
                if (r2 != 0) goto L1c
                rx.exceptions.Exceptions.throwIfFatal(r5)     // Catch: java.lang.Throwable -> L8
                r4.unsubscribe()     // Catch: java.lang.Throwable -> L1a
                r4.onError(r5)     // Catch: java.lang.Throwable -> L1a
                return
            L1a:
                r5 = move-exception
                goto L54
            L1c:
                java.util.Queue r2 = r4.getOrCreateErrorQueue()     // Catch: java.lang.Throwable -> L8
                r2.offer(r5)     // Catch: java.lang.Throwable -> L8
            L23:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r5 == 0) goto L31
                rx.internal.operators.OperatorMerge$MergeProducer<T> r5 = r4.producer     // Catch: java.lang.Throwable -> L8
                r5.produced(r0)     // Catch: java.lang.Throwable -> L8
            L31:
                int r5 = r4.scalarEmissionCount     // Catch: java.lang.Throwable -> L8
                int r5 = r5 + r0
                int r6 = r4.scalarEmissionLimit     // Catch: java.lang.Throwable -> L8
                if (r5 != r6) goto L3f
                r4.scalarEmissionCount = r1     // Catch: java.lang.Throwable -> L8
                long r5 = (long) r5     // Catch: java.lang.Throwable -> L8
                r4.requestMore(r5)     // Catch: java.lang.Throwable -> L8
                goto L41
            L3f:
                r4.scalarEmissionCount = r5     // Catch: java.lang.Throwable -> L8
            L41:
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L8
                boolean r5 = r4.missed     // Catch: java.lang.Throwable -> L51
                if (r5 != 0) goto L4a
                r4.emitting = r1     // Catch: java.lang.Throwable -> L51
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                return
            L4a:
                r4.missed = r1     // Catch: java.lang.Throwable -> L51
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                r4.emitLoop()
                return
            L51:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
                throw r5     // Catch: java.lang.Throwable -> L1a
            L54:
                if (r0 != 0) goto L5e
                monitor-enter(r4)
                r4.emitting = r1     // Catch: java.lang.Throwable -> L5b
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L5b
                goto L5e
            L5b:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L5b
                throw r5
            L5e:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(java.lang.Object, long):void");
        }
    }

    OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.maxConcurrent = i;
    }

    public static <T> OperatorMerge<T> instance(boolean z) {
        return z ? (OperatorMerge<T>) HolderDelayErrors.INSTANCE : (OperatorMerge<T>) HolderNoDelay.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    public static <T> OperatorMerge<T> instance(boolean z, int i) {
        if (i > 0) {
            if (i == Integer.MAX_VALUE) {
                return instance(z);
            }
            return new OperatorMerge<>(z, i);
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
    }
}
