package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC2904a<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<? extends TRight> f22128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> f22129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> f22130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.b.c<? super TLeft, ? super io.reactivex.p<TRight>, ? extends R> f22131e;

    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, a {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final io.reactivex.w<? super R> downstream;
        final io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> leftEnd;
        int leftIndex;
        final io.reactivex.b.c<? super TLeft, ? super io.reactivex.p<TRight>, ? extends R> resultSelector;
        final io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(io.reactivex.p.bufferSize());
        final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        GroupJoinDisposable(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> oVar, io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> oVar2, io.reactivex.b.c<? super TLeft, ? super io.reactivex.p<TRight>, ? extends R> cVar) {
            this.downstream = wVar;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.a<?> aVar = this.queue;
            io.reactivex.w<? super R> wVar = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    aVar.clear();
                    cancelAll();
                    errorAll(wVar);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<UnicastSubject<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    wVar.onComplete();
                    return;
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = aVar.poll();
                    if (num == LEFT_VALUE) {
                        UnicastSubject unicastSubjectC = UnicastSubject.c();
                        int i = this.leftIndex;
                        this.leftIndex = i + 1;
                        this.lefts.put(Integer.valueOf(i), (UnicastSubject<TRight>) unicastSubjectC);
                        try {
                            io.reactivex.u uVarApply = this.leftEnd.apply(objPoll);
                            io.reactivex.internal.functions.a.a(uVarApply, "The leftEnd returned a null ObservableSource");
                            io.reactivex.u uVar = uVarApply;
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i);
                            this.disposables.b(leftRightEndObserver);
                            uVar.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(wVar);
                                return;
                            }
                            try {
                                R rApply = this.resultSelector.apply(objPoll, unicastSubjectC);
                                io.reactivex.internal.functions.a.a(rApply, "The resultSelector returned a null value");
                                wVar.onNext(rApply);
                                Iterator<TRight> it2 = this.rights.values().iterator();
                                while (it2.hasNext()) {
                                    unicastSubjectC.onNext(it2.next());
                                }
                            } catch (Throwable th) {
                                fail(th, wVar, aVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            fail(th2, wVar, aVar);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i2 = this.rightIndex;
                        this.rightIndex = i2 + 1;
                        this.rights.put(Integer.valueOf(i2), (TRight) objPoll);
                        try {
                            io.reactivex.u uVarApply2 = this.rightEnd.apply(objPoll);
                            io.reactivex.internal.functions.a.a(uVarApply2, "The rightEnd returned a null ObservableSource");
                            io.reactivex.u uVar2 = uVarApply2;
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i2);
                            this.disposables.b(leftRightEndObserver2);
                            uVar2.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(wVar);
                                return;
                            } else {
                                Iterator<UnicastSubject<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            fail(th3, wVar, aVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) objPoll;
                        UnicastSubject<TRight> unicastSubjectRemove = this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.a(leftRightEndObserver3);
                        if (unicastSubjectRemove != null) {
                            unicastSubjectRemove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.a(leftRightEndObserver4);
                    }
                }
            }
            aVar.clear();
        }

        void errorAll(io.reactivex.w<?> wVar) {
            Throwable thA = ExceptionHelper.a(this.error);
            Iterator<UnicastSubject<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(thA);
            }
            this.lefts.clear();
            this.rights.clear();
            wVar.onError(thA);
        }

        void fail(Throwable th, io.reactivex.w<?> wVar, io.reactivex.internal.queue.a<?> aVar) {
            io.reactivex.exceptions.a.b(th);
            ExceptionHelper.a(this.error, th);
            aVar.clear();
            cancelAll();
            errorAll(wVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.a((LeftRightEndObserver) (z ? LEFT_CLOSE : RIGHT_CLOSE), leftRightEndObserver);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.a(this.error, th)) {
                drain();
            } else {
                io.reactivex.e.a.b(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerComplete(LeftRightObserver leftRightObserver) {
            this.disposables.c(leftRightObserver);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerError(Throwable th) {
            if (!ExceptionHelper.a(this.error, th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.a(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class LeftRightEndObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final a parent;

        LeftRightEndObserver(a aVar, boolean z, int i) {
            this.parent = aVar;
            this.isLeft = z;
            this.index = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    static final class LeftRightObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final a parent;

        LeftRightObserver(a aVar, boolean z) {
            this.parent = aVar;
            this.isLeft = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    interface a {
        void innerClose(boolean z, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    public ObservableGroupJoin(io.reactivex.u<TLeft> uVar, io.reactivex.u<? extends TRight> uVar2, io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> oVar, io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> oVar2, io.reactivex.b.c<? super TLeft, ? super io.reactivex.p<TRight>, ? extends R> cVar) {
        super(uVar);
        this.f22128b = uVar2;
        this.f22129c = oVar;
        this.f22130d = oVar2;
        this.f22131e = cVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super R> wVar) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(wVar, this.f22129c, this.f22130d, this.f22131e);
        wVar.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.disposables.b(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.disposables.b(leftRightObserver2);
        this.f22358a.subscribe(leftRightObserver);
        this.f22128b.subscribe(leftRightObserver2);
    }
}
