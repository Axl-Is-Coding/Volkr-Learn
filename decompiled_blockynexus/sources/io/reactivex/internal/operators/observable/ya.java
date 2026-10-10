package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ya<T, B, V> extends AbstractC2904a<T, io.reactivex.p<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<B> f22603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super B, ? extends io.reactivex.u<V>> f22604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22605d;

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class a<T, V> extends io.reactivex.observers.c<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<T, ?, V> f22606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final UnicastSubject<T> f22607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22608d;

        a(c<T, ?, V> cVar, UnicastSubject<T> unicastSubject) {
            this.f22606b = cVar;
            this.f22607c = unicastSubject;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22608d) {
                return;
            }
            this.f22608d = true;
            this.f22606b.a((a) this);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22608d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22608d = true;
                this.f22606b.a(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class b<T, B> extends io.reactivex.observers.c<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c<T, B, ?> f22609b;

        b(c<T, B, ?> cVar) {
            this.f22609b = cVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22609b.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22609b.a(th);
        }

        @Override // io.reactivex.w
        public void onNext(B b2) {
            this.f22609b.a(b2);
        }
    }

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class d<T, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final UnicastSubject<T> f22610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final B f22611b;

        d(UnicastSubject<T> unicastSubject, B b2) {
            this.f22610a = unicastSubject;
            this.f22611b = b2;
        }
    }

    public ya(io.reactivex.u<T> uVar, io.reactivex.u<B> uVar2, io.reactivex.b.o<? super B, ? extends io.reactivex.u<V>> oVar, int i) {
        super(uVar);
        this.f22603b = uVar2;
        this.f22604c = oVar;
        this.f22605d = i;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.p<T>> wVar) {
        this.f22358a.subscribe(new c(new io.reactivex.observers.f(wVar), this.f22603b, this.f22604c, this.f22605d));
    }

    /* JADX INFO: compiled from: ObservableWindowBoundarySelector.java */
    static final class c<T, B, V> extends io.reactivex.internal.observers.j<T, Object, io.reactivex.p<T>> implements io.reactivex.disposables.b {
        final io.reactivex.u<B> g;
        final io.reactivex.b.o<? super B, ? extends io.reactivex.u<V>> h;
        final int i;
        final io.reactivex.disposables.a j;
        io.reactivex.disposables.b k;
        final AtomicReference<io.reactivex.disposables.b> l;
        final List<UnicastSubject<T>> m;
        final AtomicLong n;
        final AtomicBoolean o;

        c(io.reactivex.w<? super io.reactivex.p<T>> wVar, io.reactivex.u<B> uVar, io.reactivex.b.o<? super B, ? extends io.reactivex.u<V>> oVar, int i) {
            super(wVar, new MpscLinkedQueue());
            this.l = new AtomicReference<>();
            this.n = new AtomicLong();
            this.o = new AtomicBoolean();
            this.g = uVar;
            this.h = oVar;
            this.i = i;
            this.j = new io.reactivex.disposables.a();
            this.m = new ArrayList();
            this.n.lazySet(1L);
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public void a(io.reactivex.w<? super io.reactivex.p<T>> wVar, Object obj) {
        }

        void a(Throwable th) {
            this.k.dispose();
            this.j.dispose();
            onError(th);
        }

        void d() {
            this.j.dispose();
            DisposableHelper.dispose(this.l);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.o.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.l);
                if (this.n.decrementAndGet() == 0) {
                    this.k.dispose();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void e() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f21857c;
            io.reactivex.w<? super V> wVar = this.f21856b;
            List<UnicastSubject<T>> list = this.m;
            int iA = 1;
            while (true) {
                boolean z = this.f21859e;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    d();
                    Throwable th = this.f21860f;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll instanceof d) {
                    d dVar = (d) objPoll;
                    UnicastSubject<T> unicastSubject = dVar.f22610a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            dVar.f22610a.onComplete();
                            if (this.n.decrementAndGet() == 0) {
                                d();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.o.get()) {
                        UnicastSubject<T> unicastSubjectA = UnicastSubject.a(this.i);
                        list.add(unicastSubjectA);
                        wVar.onNext(unicastSubjectA);
                        try {
                            io.reactivex.u<V> uVarApply = this.h.apply(dVar.f22611b);
                            io.reactivex.internal.functions.a.a(uVarApply, "The ObservableSource supplied is null");
                            io.reactivex.u<V> uVar = uVarApply;
                            a aVar = new a(this, unicastSubjectA);
                            if (this.j.b(aVar)) {
                                this.n.getAndIncrement();
                                uVar.subscribe(aVar);
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.o.set(true);
                            wVar.onError(th2);
                        }
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject2 : list) {
                        NotificationLite.getValue(objPoll);
                        unicastSubject2.onNext(objPoll);
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.o.get();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f21859e) {
                return;
            }
            this.f21859e = true;
            if (b()) {
                e();
            }
            if (this.n.decrementAndGet() == 0) {
                this.j.dispose();
            }
            this.f21856b.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f21859e) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.f21860f = th;
            this.f21859e = true;
            if (b()) {
                e();
            }
            if (this.n.decrementAndGet() == 0) {
                this.j.dispose();
            }
            this.f21856b.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (c()) {
                Iterator<UnicastSubject<T>> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                io.reactivex.c.a.j<U> jVar = this.f21857c;
                NotificationLite.next(t);
                jVar.offer((U) t);
                if (!b()) {
                    return;
                }
            }
            e();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.k, bVar)) {
                this.k = bVar;
                this.f21856b.onSubscribe(this);
                if (this.o.get()) {
                    return;
                }
                b bVar2 = new b(this);
                if (this.l.compareAndSet(null, bVar2)) {
                    this.g.subscribe(bVar2);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(B b2) {
            this.f21857c.offer((U) new d(null, b2));
            if (b()) {
                e();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(a<T, V> aVar) {
            this.j.c(aVar);
            this.f21857c.offer((U) new d(aVar.f22607c, null));
            if (b()) {
                e();
            }
        }
    }
}
