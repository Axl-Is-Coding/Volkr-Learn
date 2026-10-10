package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import io.reactivex.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableWindowTimed.java */
/* JADX INFO: loaded from: classes5.dex */
public final class za<T> extends AbstractC2904a<T, io.reactivex.p<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f22624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.x f22625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f22626f;
    final int g;
    final boolean h;

    /* JADX INFO: compiled from: ObservableWindowTimed.java */
    static final class a<T> extends io.reactivex.internal.observers.j<T, Object, io.reactivex.p<T>> implements io.reactivex.disposables.b {
        final long g;
        final TimeUnit h;
        final io.reactivex.x i;
        final int j;
        final boolean k;
        final long l;
        final x.c m;
        long n;
        long o;
        io.reactivex.disposables.b p;
        UnicastSubject<T> q;
        volatile boolean r;
        final AtomicReference<io.reactivex.disposables.b> s;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.za$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableWindowTimed.java */
        static final class RunnableC0204a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final long f22627a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final a<?> f22628b;

            RunnableC0204a(long j, a<?> aVar) {
                this.f22627a = j;
                this.f22628b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f22628b;
                if (((io.reactivex.internal.observers.j) aVar).f21858d) {
                    aVar.r = true;
                    aVar.d();
                } else {
                    ((io.reactivex.internal.observers.j) aVar).f21857c.offer(this);
                }
                if (aVar.b()) {
                    aVar.e();
                }
            }
        }

        a(io.reactivex.w<? super io.reactivex.p<T>> wVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, int i, long j2, boolean z) {
            super(wVar, new MpscLinkedQueue());
            this.s = new AtomicReference<>();
            this.g = j;
            this.h = timeUnit;
            this.i = xVar;
            this.j = i;
            this.l = j2;
            this.k = z;
            if (z) {
                this.m = xVar.a();
            } else {
                this.m = null;
            }
        }

        void d() {
            DisposableHelper.dispose(this.s);
            x.c cVar = this.m;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f21858d = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [io.reactivex.w, io.reactivex.w<? super V>] */
        /* JADX WARN: Type inference failed for: r4v8, types: [io.reactivex.subjects.UnicastSubject] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        void e() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f21857c;
            ?? r1 = this.f21856b;
            UnicastSubject unicastSubject = this.q;
            int iA = 1;
            while (!this.r) {
                boolean z = this.f21859e;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof RunnableC0204a;
                if (z && (z2 || z3)) {
                    this.q = null;
                    mpscLinkedQueue.clear();
                    d();
                    Throwable th = this.f21860f;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC0204a runnableC0204a = (RunnableC0204a) objPoll;
                    if (this.k || this.o == runnableC0204a.f22627a) {
                        unicastSubject.onComplete();
                        this.n = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.a(this.j);
                        this.q = unicastSubject;
                        r1.onNext(unicastSubject);
                    }
                } else {
                    NotificationLite.getValue(objPoll);
                    unicastSubject.onNext(objPoll);
                    long j = this.n + 1;
                    if (j >= this.l) {
                        this.o++;
                        this.n = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.a(this.j);
                        this.q = unicastSubject;
                        this.f21856b.onNext(unicastSubject);
                        if (this.k) {
                            io.reactivex.disposables.b bVar = this.s.get();
                            bVar.dispose();
                            x.c cVar = this.m;
                            RunnableC0204a runnableC0204a2 = new RunnableC0204a(this.o, this);
                            long j2 = this.g;
                            io.reactivex.disposables.b bVarA = cVar.a(runnableC0204a2, j2, j2, this.h);
                            if (!this.s.compareAndSet(bVar, bVarA)) {
                                bVarA.dispose();
                            }
                        }
                    } else {
                        this.n = j;
                    }
                }
            }
            this.p.dispose();
            mpscLinkedQueue.clear();
            d();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21858d;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f21859e = true;
            if (b()) {
                e();
            }
            this.f21856b.onComplete();
            d();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f21860f = th;
            this.f21859e = true;
            if (b()) {
                e();
            }
            this.f21856b.onError(th);
            d();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.r) {
                return;
            }
            if (c()) {
                UnicastSubject<T> unicastSubject = this.q;
                unicastSubject.onNext(t);
                long j = this.n + 1;
                if (j >= this.l) {
                    this.o++;
                    this.n = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> unicastSubjectA = UnicastSubject.a(this.j);
                    this.q = unicastSubjectA;
                    this.f21856b.onNext(unicastSubjectA);
                    if (this.k) {
                        this.s.get().dispose();
                        x.c cVar = this.m;
                        RunnableC0204a runnableC0204a = new RunnableC0204a(this.o, this);
                        long j2 = this.g;
                        DisposableHelper.replace(this.s, cVar.a(runnableC0204a, j2, j2, this.h));
                    }
                } else {
                    this.n = j;
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

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            io.reactivex.disposables.b bVarA;
            if (DisposableHelper.validate(this.p, bVar)) {
                this.p = bVar;
                io.reactivex.w<? super V> wVar = this.f21856b;
                wVar.onSubscribe(this);
                if (this.f21858d) {
                    return;
                }
                UnicastSubject<T> unicastSubjectA = UnicastSubject.a(this.j);
                this.q = unicastSubjectA;
                wVar.onNext(unicastSubjectA);
                RunnableC0204a runnableC0204a = new RunnableC0204a(this.o, this);
                if (this.k) {
                    x.c cVar = this.m;
                    long j = this.g;
                    bVarA = cVar.a(runnableC0204a, j, j, this.h);
                } else {
                    io.reactivex.x xVar = this.i;
                    long j2 = this.g;
                    bVarA = xVar.a(runnableC0204a, j2, j2, this.h);
                }
                DisposableHelper.replace(this.s, bVarA);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableWindowTimed.java */
    static final class b<T> extends io.reactivex.internal.observers.j<T, Object, io.reactivex.p<T>> implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        static final Object g = new Object();
        final long h;
        final TimeUnit i;
        final io.reactivex.x j;
        final int k;
        io.reactivex.disposables.b l;
        UnicastSubject<T> m;
        final AtomicReference<io.reactivex.disposables.b> n;
        volatile boolean o;

        b(io.reactivex.w<? super io.reactivex.p<T>> wVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, int i) {
            super(wVar, new MpscLinkedQueue());
            this.n = new AtomicReference<>();
            this.h = j;
            this.i = timeUnit;
            this.j = xVar;
            this.k = i;
        }

        void d() {
            DisposableHelper.dispose(this.n);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f21858d = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.m = null;
            r0.clear();
            d();
            r0 = r7.f21860f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void e() {
            /*
                r7 = this;
                io.reactivex.c.a.j<U> r0 = r7.f21857c
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.w<? super V> r1 = r7.f21856b
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.m
                r3 = 1
            L9:
                boolean r4 = r7.o
                boolean r5 = r7.f21859e
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.za.b.g
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.m = r1
                r0.clear()
                r7.d()
                java.lang.Throwable r0 = r7.f21860f
                if (r0 == 0) goto L2a
                r2.onError(r0)
                goto L2d
            L2a:
                r2.onComplete()
            L2d:
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.a(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.za.b.g
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.k
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.a(r2)
                r7.m = r2
                r1.onNext(r2)
                goto L9
            L4d:
                io.reactivex.disposables.b r4 = r7.l
                r4.dispose()
                goto L9
            L53:
                io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r6)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.za.b.e():void");
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21858d;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f21859e = true;
            if (b()) {
                e();
            }
            d();
            this.f21856b.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f21860f = th;
            this.f21859e = true;
            if (b()) {
                e();
            }
            d();
            this.f21856b.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.o) {
                return;
            }
            if (c()) {
                this.m.onNext(t);
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

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.l, bVar)) {
                this.l = bVar;
                this.m = UnicastSubject.a(this.k);
                io.reactivex.w<? super V> wVar = this.f21856b;
                wVar.onSubscribe(this);
                wVar.onNext(this.m);
                if (this.f21858d) {
                    return;
                }
                io.reactivex.x xVar = this.j;
                long j = this.h;
                DisposableHelper.replace(this.n, xVar.a(this, j, j, this.i));
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f21858d) {
                this.o = true;
                d();
            }
            this.f21857c.offer((U) g);
            if (b()) {
                e();
            }
        }
    }

    /* JADX INFO: compiled from: ObservableWindowTimed.java */
    static final class c<T> extends io.reactivex.internal.observers.j<T, Object, io.reactivex.p<T>> implements io.reactivex.disposables.b, Runnable {
        final long g;
        final long h;
        final TimeUnit i;
        final x.c j;
        final int k;
        final List<UnicastSubject<T>> l;
        io.reactivex.disposables.b m;
        volatile boolean n;

        /* JADX INFO: compiled from: ObservableWindowTimed.java */
        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final UnicastSubject<T> f22629a;

            a(UnicastSubject<T> unicastSubject) {
                this.f22629a = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.f22629a);
            }
        }

        /* JADX INFO: compiled from: ObservableWindowTimed.java */
        static final class b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final UnicastSubject<T> f22631a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final boolean f22632b;

            b(UnicastSubject<T> unicastSubject, boolean z) {
                this.f22631a = unicastSubject;
                this.f22632b = z;
            }
        }

        c(io.reactivex.w<? super io.reactivex.p<T>> wVar, long j, long j2, TimeUnit timeUnit, x.c cVar, int i) {
            super(wVar, new MpscLinkedQueue());
            this.g = j;
            this.h = j2;
            this.i = timeUnit;
            this.j = cVar;
            this.k = i;
            this.l = new LinkedList();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(UnicastSubject<T> unicastSubject) {
            this.f21857c.offer((U) new b(unicastSubject, false));
            if (b()) {
                e();
            }
        }

        void d() {
            this.j.dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f21858d = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void e() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f21857c;
            io.reactivex.w<? super V> wVar = this.f21856b;
            List<UnicastSubject<T>> list = this.l;
            int iA = 1;
            while (!this.n) {
                boolean z = this.f21859e;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof b;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
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
                    d();
                    list.clear();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) objPoll;
                    if (!bVar.f22632b) {
                        list.remove(bVar.f22631a);
                        bVar.f22631a.onComplete();
                        if (list.isEmpty() && this.f21858d) {
                            this.n = true;
                        }
                    } else if (!this.f21858d) {
                        UnicastSubject<T> unicastSubjectA = UnicastSubject.a(this.k);
                        list.add(unicastSubjectA);
                        wVar.onNext(unicastSubjectA);
                        this.j.a(new a(unicastSubjectA), this.g, this.i);
                    }
                } else {
                    Iterator<UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.m.dispose();
            d();
            mpscLinkedQueue.clear();
            list.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21858d;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f21859e = true;
            if (b()) {
                e();
            }
            this.f21856b.onComplete();
            d();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f21860f = th;
            this.f21859e = true;
            if (b()) {
                e();
            }
            this.f21856b.onError(th);
            d();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (c()) {
                Iterator<UnicastSubject<T>> it = this.l.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.f21857c.offer((U) t);
                if (!b()) {
                    return;
                }
            }
            e();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.m, bVar)) {
                this.m = bVar;
                this.f21856b.onSubscribe(this);
                if (this.f21858d) {
                    return;
                }
                UnicastSubject<T> unicastSubjectA = UnicastSubject.a(this.k);
                this.l.add(unicastSubjectA);
                this.f21856b.onNext(unicastSubjectA);
                this.j.a(new a(unicastSubjectA), this.g, this.i);
                x.c cVar = this.j;
                long j = this.h;
                cVar.a(this, j, j, this.i);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            Object bVar = new b(UnicastSubject.a(this.k), true);
            if (!this.f21858d) {
                this.f21857c.offer((U) bVar);
            }
            if (b()) {
                e();
            }
        }
    }

    public za(io.reactivex.u<T> uVar, long j, long j2, TimeUnit timeUnit, io.reactivex.x xVar, long j3, int i, boolean z) {
        super(uVar);
        this.f22622b = j;
        this.f22623c = j2;
        this.f22624d = timeUnit;
        this.f22625e = xVar;
        this.f22626f = j3;
        this.g = i;
        this.h = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.p<T>> wVar) {
        io.reactivex.observers.f fVar = new io.reactivex.observers.f(wVar);
        long j = this.f22622b;
        long j2 = this.f22623c;
        if (j != j2) {
            this.f22358a.subscribe(new c(fVar, j, j2, this.f22624d, this.f22625e.a(), this.g));
            return;
        }
        long j3 = this.f22626f;
        if (j3 == Long.MAX_VALUE) {
            this.f22358a.subscribe(new b(fVar, j, this.f22624d, this.f22625e, this.g));
        } else {
            this.f22358a.subscribe(new a(fVar, j, this.f22624d, this.f22625e, this.g, j3, this.h));
        }
    }
}
