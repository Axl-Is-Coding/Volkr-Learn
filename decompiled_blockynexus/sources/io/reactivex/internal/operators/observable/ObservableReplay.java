package io.reactivex.internal.operators.observable;

import a.a.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableReplay<T> extends io.reactivex.d.a<T> implements io.reactivex.c.a.d<T>, io.reactivex.internal.disposables.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f22180a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<T> f22181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<ReplayObserver<T>> f22182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final a<T> f22183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.u<T> f22184e;

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements e<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        Node tail;

        BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                h.a aVar = (Object) leaveTransform(head.value);
                if (NotificationLite.isComplete(aVar) || NotificationLite.isError(aVar)) {
                    return;
                }
                NotificationLite.getValue(aVar);
                collection.add(aVar);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void error(Throwable th) {
            addLast(new Node(enterTransform(NotificationLite.error(th))));
            truncateFinal();
        }

        Node getHead() {
            return get();
        }

        boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isComplete(leaveTransform(obj));
        }

        boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(leaveTransform(obj));
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void next(T t) {
            NotificationLite.next(t);
            addLast(new Node(enterTransform(t)));
            truncate();
        }

        final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        final void removeSome(int i) {
            Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                Node head = (Node) innerDisposable.index();
                if (head == null) {
                    head = getHead();
                    innerDisposable.index = head;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node = head.get();
                    if (node == null) {
                        innerDisposable.index = head;
                        iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                    } else {
                        if (NotificationLite.accept(leaveTransform(node.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        }
                        head = node;
                    }
                }
                innerDisposable.index = null;
                return;
            } while (iAddAndGet != 0);
        }

        final void setFirst(Node node) {
            set(node);
        }

        final void trimHead() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        abstract void truncate();

        void truncateFinal() {
            trimHead();
        }
    }

    static final class InnerDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final io.reactivex.w<? super T> child;
        Object index;
        final ReplayObserver<T> parent;

        InnerDisposable(ReplayObserver<T> replayObserver, io.reactivex.w<? super T> wVar) {
            this.parent = replayObserver;
            this.child = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.remove(this);
            this.index = null;
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        Node(Object obj) {
            this.value = obj;
        }
    }

    static final class ReplayObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        final e<T> buffer;
        boolean done;
        final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        ReplayObserver(e<T> eVar) {
            this.buffer = eVar;
        }

        boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.done = true;
            this.buffer.error(th);
            replayFinal();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                replay();
            }
        }

        void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerDisposableArr[i2].equals(innerDisposable)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = EMPTY;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        void replay() {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                this.buffer.replay(innerDisposable);
            }
        }

        void replayFinal() {
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(innerDisposable);
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final io.reactivex.x scheduler;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            this.scheduler = xVar;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object enterTransform(Object obj) {
            return new io.reactivex.f.c(obj, this.scheduler.a(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Node getHead() {
            Node node;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                io.reactivex.f.c cVar = (io.reactivex.f.c) node2.value;
                if (NotificationLite.isComplete(cVar.b()) || NotificationLite.isError(cVar.b()) || cVar.a() > jA) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        Object leaveTransform(Object obj) {
            return ((io.reactivex.f.c) obj).b();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void truncate() {
            Node node;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i2 = this.size;
                    if (i2 <= this.limit) {
                        if (((io.reactivex.f.c) node2.value).a() > jA) {
                            break;
                        }
                        i++;
                        this.size--;
                        node3 = node2.get();
                    } else {
                        i++;
                        this.size = i2 - 1;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void truncateFinal() {
            Node node;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.size <= 1 || ((io.reactivex.f.c) node2.value).a() > jA) {
                    break;
                }
                i++;
                this.size--;
                node3 = node2.get();
            }
            if (i != 0) {
                setFirst(node);
            }
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements e<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void next(T t) {
            NotificationLite.next(t);
            add(t);
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            io.reactivex.w<? super T> wVar = innerDisposable.child;
            int iAddAndGet = 1;
            while (!innerDisposable.isDisposed()) {
                int i = this.size;
                Integer num = (Integer) innerDisposable.index();
                int iIntValue = num != null ? num.intValue() : 0;
                while (iIntValue < i) {
                    if (NotificationLite.accept(get(iIntValue), wVar) || innerDisposable.isDisposed()) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
                innerDisposable.index = Integer.valueOf(iIntValue);
                iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    interface a<T> {
        e<T> call();
    }

    static final class b<R> implements io.reactivex.b.g<io.reactivex.disposables.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObserverResourceWrapper<R> f22185a;

        b(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f22185a = observerResourceWrapper;
        }

        @Override // io.reactivex.b.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(io.reactivex.disposables.b bVar) {
            this.f22185a.setResource(bVar);
        }
    }

    static final class c<R, U> extends io.reactivex.p<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Callable<? extends io.reactivex.d.a<U>> f22186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.b.o<? super io.reactivex.p<U>, ? extends io.reactivex.u<R>> f22187b;

        c(Callable<? extends io.reactivex.d.a<U>> callable, io.reactivex.b.o<? super io.reactivex.p<U>, ? extends io.reactivex.u<R>> oVar) {
            this.f22186a = callable;
            this.f22187b = oVar;
        }

        @Override // io.reactivex.p
        protected void subscribeActual(io.reactivex.w<? super R> wVar) {
            try {
                io.reactivex.d.a<U> aVarCall = this.f22186a.call();
                io.reactivex.internal.functions.a.a(aVarCall, "The connectableFactory returned a null ConnectableObservable");
                io.reactivex.d.a<U> aVar = aVarCall;
                io.reactivex.u<R> uVarApply = this.f22187b.apply(aVar);
                io.reactivex.internal.functions.a.a(uVarApply, "The selector returned a null ObservableSource");
                io.reactivex.u<R> uVar = uVarApply;
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(wVar);
                uVar.subscribe(observerResourceWrapper);
                aVar.a(new b(observerResourceWrapper));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                EmptyDisposable.error(th, wVar);
            }
        }
    }

    static final class d<T> extends io.reactivex.d.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.d.a<T> f22188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.p<T> f22189b;

        d(io.reactivex.d.a<T> aVar, io.reactivex.p<T> pVar) {
            this.f22188a = aVar;
            this.f22189b = pVar;
        }

        @Override // io.reactivex.d.a
        public void a(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar) {
            this.f22188a.a(gVar);
        }

        @Override // io.reactivex.p
        protected void subscribeActual(io.reactivex.w<? super T> wVar) {
            this.f22189b.subscribe(wVar);
        }
    }

    interface e<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    static final class f<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22190a;

        f(int i) {
            this.f22190a = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<T> call() {
            return new SizeBoundReplayBuffer(this.f22190a);
        }
    }

    static final class g<T> implements io.reactivex.u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicReference<ReplayObserver<T>> f22191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a<T> f22192b;

        g(AtomicReference<ReplayObserver<T>> atomicReference, a<T> aVar) {
            this.f22191a = atomicReference;
            this.f22192b = aVar;
        }

        @Override // io.reactivex.u
        public void subscribe(io.reactivex.w<? super T> wVar) {
            ReplayObserver<T> replayObserver;
            while (true) {
                replayObserver = this.f22191a.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f22192b.call());
                if (this.f22191a.compareAndSet(null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, wVar);
            wVar.onSubscribe(innerDisposable);
            replayObserver.add(innerDisposable);
            if (innerDisposable.isDisposed()) {
                replayObserver.remove(innerDisposable);
            } else {
                replayObserver.buffer.replay(innerDisposable);
            }
        }
    }

    static final class h<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f22194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f22195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final io.reactivex.x f22196d;

        h(int i, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            this.f22193a = i;
            this.f22194b = j;
            this.f22195c = timeUnit;
            this.f22196d = xVar;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f22193a, this.f22194b, this.f22195c, this.f22196d);
        }
    }

    static final class i implements a<Object> {
        i() {
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    private ObservableReplay(io.reactivex.u<T> uVar, io.reactivex.u<T> uVar2, AtomicReference<ReplayObserver<T>> atomicReference, a<T> aVar) {
        this.f22184e = uVar;
        this.f22181b = uVar2;
        this.f22182c = atomicReference;
        this.f22183d = aVar;
    }

    public static <U, R> io.reactivex.p<R> a(Callable<? extends io.reactivex.d.a<U>> callable, io.reactivex.b.o<? super io.reactivex.p<U>, ? extends io.reactivex.u<R>> oVar) {
        return io.reactivex.e.a.a(new c(callable, oVar));
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22184e.subscribe(wVar);
    }

    public static <T> io.reactivex.d.a<T> a(io.reactivex.d.a<T> aVar, io.reactivex.x xVar) {
        return io.reactivex.e.a.a((io.reactivex.d.a) new d(aVar, aVar.observeOn(xVar)));
    }

    public static <T> io.reactivex.d.a<T> a(io.reactivex.u<? extends T> uVar) {
        return a(uVar, f22180a);
    }

    public static <T> io.reactivex.d.a<T> a(io.reactivex.u<T> uVar, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return a(uVar);
        }
        return a(uVar, new f(i2));
    }

    public static <T> io.reactivex.d.a<T> a(io.reactivex.u<T> uVar, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
        return a(uVar, j, timeUnit, xVar, Integer.MAX_VALUE);
    }

    public static <T> io.reactivex.d.a<T> a(io.reactivex.u<T> uVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, int i2) {
        return a(uVar, new h(i2, j, timeUnit, xVar));
    }

    static <T> io.reactivex.d.a<T> a(io.reactivex.u<T> uVar, a<T> aVar) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.e.a.a((io.reactivex.d.a) new ObservableReplay(new g(atomicReference, aVar), uVar, atomicReference, aVar));
    }

    @Override // io.reactivex.internal.disposables.c
    public void a(io.reactivex.disposables.b bVar) {
        this.f22182c.compareAndSet((ReplayObserver) bVar, null);
    }

    @Override // io.reactivex.d.a
    public void a(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar) {
        ReplayObserver<T> replayObserver;
        while (true) {
            replayObserver = this.f22182c.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f22183d.call());
            if (this.f22182c.compareAndSet(replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(replayObserver);
            if (z) {
                this.f22181b.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            io.reactivex.exceptions.a.b(th);
            throw ExceptionHelper.b(th);
        }
    }
}
