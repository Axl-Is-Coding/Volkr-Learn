package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractC2904a<T, io.reactivex.d.b<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends K> f22123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends V> f22124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f22126e;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final boolean delayError;
        final io.reactivex.w<? super io.reactivex.d.b<K, V>> downstream;
        final io.reactivex.b.o<? super T, ? extends K> keySelector;
        io.reactivex.disposables.b upstream;
        final io.reactivex.b.o<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, a<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(io.reactivex.w<? super io.reactivex.d.b<K, V>> wVar, io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, int i, boolean z) {
            this.downstream = wVar;
            this.keySelector = oVar;
            this.valueSelector = oVar2;
            this.bufferSize = i;
            this.delayError = z;
            lazySet(1);
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            try {
                K kApply = this.keySelector.apply(t);
                Object obj = kApply != null ? kApply : NULL_KEY;
                a<K, V> aVarA = this.groups.get(obj);
                if (aVarA == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    aVarA = a.a(kApply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, aVarA);
                    getAndIncrement();
                    this.downstream.onNext(aVarA);
                }
                try {
                    V vApply = this.valueSelector.apply(t);
                    io.reactivex.internal.functions.a.a(vApply, "The value supplied is null");
                    aVarA.onNext(vApply);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.upstream.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                onError(th2);
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

    static final class State<T, K> extends AtomicInteger implements io.reactivex.disposables.b, io.reactivex.u<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupByObserver<?, K, T> parent;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicReference<io.reactivex.w<? super T>> actual = new AtomicReference<>();

        State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        boolean checkTerminated(boolean z, boolean z2, io.reactivex.w<? super T> wVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                this.actual.lazySet(null);
                if (th != null) {
                    wVar.onError(th);
                } else {
                    wVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                this.actual.lazySet(null);
                wVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.actual.lazySet(null);
            wVar.onComplete();
            return true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            boolean z = this.delayError;
            io.reactivex.w<? super T> wVar = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (wVar != null) {
                    while (true) {
                        boolean z2 = this.done;
                        T tPoll = aVar.poll();
                        boolean z3 = tPoll == null;
                        if (checkTerminated(z2, z3, wVar, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        } else {
                            wVar.onNext(tPoll);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (wVar == null) {
                    wVar = this.actual.get();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.u
        public void subscribe(io.reactivex.w<? super T> wVar) {
            if (!this.once.compareAndSet(false, true)) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), wVar);
                return;
            }
            wVar.onSubscribe(this);
            this.actual.lazySet(wVar);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                drain();
            }
        }
    }

    static final class a<K, T> extends io.reactivex.d.b<K, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final State<T, K> f22127b;

        protected a(K k, State<T, K> state) {
            super(k);
            this.f22127b = state;
        }

        public static <T, K> a<K, T> a(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new a<>(k, new State(i, groupByObserver, k, z));
        }

        public void onComplete() {
            this.f22127b.onComplete();
        }

        public void onError(Throwable th) {
            this.f22127b.onError(th);
        }

        public void onNext(T t) {
            this.f22127b.onNext(t);
        }

        @Override // io.reactivex.p
        protected void subscribeActual(io.reactivex.w<? super T> wVar) {
            this.f22127b.subscribe(wVar);
        }
    }

    public ObservableGroupBy(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, int i, boolean z) {
        super(uVar);
        this.f22123b = oVar;
        this.f22124c = oVar2;
        this.f22125d = i;
        this.f22126e = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.d.b<K, V>> wVar) {
        this.f22358a.subscribe(new GroupByObserver(wVar, this.f22123b, this.f22124c, this.f22125d, this.f22126e));
    }
}
