package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC2904a<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<? extends TRight> f22142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> f22143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> f22144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> f22145e;

    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, ObservableGroupJoin.a {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final io.reactivex.w<? super R> downstream;
        final io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> leftEnd;
        int leftIndex;
        final io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(io.reactivex.p.bufferSize());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        JoinDisposable(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> oVar, io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> oVar2, io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> cVar) {
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
                        int i = this.leftIndex;
                        this.leftIndex = i + 1;
                        this.lefts.put(Integer.valueOf(i), (TLeft) objPoll);
                        try {
                            io.reactivex.u uVarApply = this.leftEnd.apply(objPoll);
                            io.reactivex.internal.functions.a.a(uVarApply, "The leftEnd returned a null ObservableSource");
                            io.reactivex.u uVar = uVarApply;
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i);
                            this.disposables.b(leftRightEndObserver);
                            uVar.subscribe(leftRightEndObserver);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(wVar);
                                return;
                            }
                            Iterator<TRight> it = this.rights.values().iterator();
                            while (it.hasNext()) {
                                try {
                                    R rApply = this.resultSelector.apply(objPoll, it.next());
                                    io.reactivex.internal.functions.a.a(rApply, "The resultSelector returned a null value");
                                    wVar.onNext(rApply);
                                } catch (Throwable th) {
                                    fail(th, wVar, aVar);
                                    return;
                                }
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
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i2);
                            this.disposables.b(leftRightEndObserver2);
                            uVar2.subscribe(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                cancelAll();
                                errorAll(wVar);
                                return;
                            }
                            Iterator<TLeft> it2 = this.lefts.values().iterator();
                            while (it2.hasNext()) {
                                try {
                                    R rApply2 = this.resultSelector.apply(it2.next(), objPoll);
                                    io.reactivex.internal.functions.a.a(rApply2, "The resultSelector returned a null value");
                                    wVar.onNext(rApply2);
                                } catch (Throwable th3) {
                                    fail(th3, wVar, aVar);
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            fail(th4, wVar, aVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.a(leftRightEndObserver3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.a(leftRightEndObserver4);
                    }
                }
            }
            aVar.clear();
        }

        void errorAll(io.reactivex.w<?> wVar) {
            Throwable thA = ExceptionHelper.a(this.error);
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
        public void innerClose(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.a((ObservableGroupJoin.LeftRightEndObserver) (z ? LEFT_CLOSE : RIGHT_CLOSE), leftRightEndObserver);
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
        public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
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

    public ObservableJoin(io.reactivex.u<TLeft> uVar, io.reactivex.u<? extends TRight> uVar2, io.reactivex.b.o<? super TLeft, ? extends io.reactivex.u<TLeftEnd>> oVar, io.reactivex.b.o<? super TRight, ? extends io.reactivex.u<TRightEnd>> oVar2, io.reactivex.b.c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(uVar);
        this.f22142b = uVar2;
        this.f22143c = oVar;
        this.f22144d = oVar2;
        this.f22145e = cVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super R> wVar) {
        JoinDisposable joinDisposable = new JoinDisposable(wVar, this.f22143c, this.f22144d, this.f22145e);
        wVar.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.disposables.b(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.disposables.b(leftRightObserver2);
        this.f22358a.subscribe(leftRightObserver);
        this.f22142b.subscribe(leftRightObserver2);
    }
}
