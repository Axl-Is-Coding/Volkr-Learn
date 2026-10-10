package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableBufferTimed.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2916l<T, U extends Collection<? super T>> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f22453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.x f22454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Callable<U> f22455f;
    final int g;
    final boolean h;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l$a */
    /* JADX INFO: compiled from: ObservableBufferTimed.java */
    static final class a<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.j<T, U, U> implements Runnable, io.reactivex.disposables.b {
        final Callable<U> g;
        final long h;
        final TimeUnit i;
        final int j;
        final boolean k;
        final x.c l;
        U m;
        io.reactivex.disposables.b n;
        io.reactivex.disposables.b o;
        long p;
        long q;

        a(io.reactivex.w<? super U> wVar, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, x.c cVar) {
            super(wVar, new MpscLinkedQueue());
            this.g = callable;
            this.h = j;
            this.i = timeUnit;
            this.j = i;
            this.k = z;
            this.l = cVar;
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public /* bridge */ /* synthetic */ void a(io.reactivex.w wVar, Object obj) {
            a((io.reactivex.w<? super Collection>) wVar, (Collection) obj);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f21858d) {
                return;
            }
            this.f21858d = true;
            this.o.dispose();
            this.l.dispose();
            synchronized (this) {
                this.m = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21858d;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            U u;
            this.l.dispose();
            synchronized (this) {
                u = this.m;
                this.m = null;
            }
            if (u != null) {
                this.f21857c.offer(u);
                this.f21859e = true;
                if (b()) {
                    io.reactivex.internal.util.k.a(this.f21857c, this.f21856b, false, this, this);
                }
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            synchronized (this) {
                this.m = null;
            }
            this.f21856b.onError(th);
            this.l.dispose();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.j) {
                    return;
                }
                this.m = null;
                this.p++;
                if (this.k) {
                    this.n.dispose();
                }
                b(u, false, this);
                try {
                    U uCall = this.g.call();
                    io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                    U u2 = uCall;
                    synchronized (this) {
                        this.m = u2;
                        this.q++;
                    }
                    if (this.k) {
                        x.c cVar = this.l;
                        long j = this.h;
                        this.n = cVar.a(this, j, j, this.i);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f21856b.onError(th);
                    dispose();
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.o, bVar)) {
                this.o = bVar;
                try {
                    U uCall = this.g.call();
                    io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                    this.m = uCall;
                    this.f21856b.onSubscribe(this);
                    x.c cVar = this.l;
                    long j = this.h;
                    this.n = cVar.a(this, j, j, this.i);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    bVar.dispose();
                    EmptyDisposable.error(th, this.f21856b);
                    this.l.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U uCall = this.g.call();
                io.reactivex.internal.functions.a.a(uCall, "The bufferSupplier returned a null buffer");
                U u = uCall;
                synchronized (this) {
                    U u2 = this.m;
                    if (u2 != null && this.p == this.q) {
                        this.m = u;
                        b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                this.f21856b.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(io.reactivex.w<? super U> wVar, U u) {
            wVar.onNext(u);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l$b */
    /* JADX INFO: compiled from: ObservableBufferTimed.java */
    static final class b<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.j<T, U, U> implements Runnable, io.reactivex.disposables.b {
        final Callable<U> g;
        final long h;
        final TimeUnit i;
        final io.reactivex.x j;
        io.reactivex.disposables.b k;
        U l;
        final AtomicReference<io.reactivex.disposables.b> m;

        b(io.reactivex.w<? super U> wVar, Callable<U> callable, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            super(wVar, new MpscLinkedQueue());
            this.m = new AtomicReference<>();
            this.g = callable;
            this.h = j;
            this.i = timeUnit;
            this.j = xVar;
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public /* bridge */ /* synthetic */ void a(io.reactivex.w wVar, Object obj) {
            a((io.reactivex.w<? super Collection>) wVar, (Collection) obj);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.m);
            this.k.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.m.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.l;
                this.l = null;
            }
            if (u != null) {
                this.f21857c.offer(u);
                this.f21859e = true;
                if (b()) {
                    io.reactivex.internal.util.k.a(this.f21857c, this.f21856b, false, null, this);
                }
            }
            DisposableHelper.dispose(this.m);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            synchronized (this) {
                this.l = null;
            }
            this.f21856b.onError(th);
            DisposableHelper.dispose(this.m);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            synchronized (this) {
                U u = this.l;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.k, bVar)) {
                this.k = bVar;
                try {
                    U uCall = this.g.call();
                    io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                    this.l = uCall;
                    this.f21856b.onSubscribe(this);
                    if (this.f21858d) {
                        return;
                    }
                    io.reactivex.x xVar = this.j;
                    long j = this.h;
                    io.reactivex.disposables.b bVarA = xVar.a(this, j, j, this.i);
                    if (this.m.compareAndSet(null, bVarA)) {
                        return;
                    }
                    bVarA.dispose();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    dispose();
                    EmptyDisposable.error(th, this.f21856b);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U uCall = this.g.call();
                io.reactivex.internal.functions.a.a(uCall, "The bufferSupplier returned a null buffer");
                U u2 = uCall;
                synchronized (this) {
                    u = this.l;
                    if (u != null) {
                        this.l = u2;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.m);
                } else {
                    a(u, false, this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f21856b.onError(th);
                dispose();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void a(io.reactivex.w<? super U> wVar, U u) {
            this.f21856b.onNext((Object) u);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l$c */
    /* JADX INFO: compiled from: ObservableBufferTimed.java */
    static final class c<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.j<T, U, U> implements Runnable, io.reactivex.disposables.b {
        final Callable<U> g;
        final long h;
        final long i;
        final TimeUnit j;
        final x.c k;
        final List<U> l;
        io.reactivex.disposables.b m;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l$c$a */
        /* JADX INFO: compiled from: ObservableBufferTimed.java */
        final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final U f22456a;

            a(U u) {
                this.f22456a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.l.remove(this.f22456a);
                }
                c cVar = c.this;
                cVar.b(this.f22456a, false, cVar.k);
            }
        }

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l$c$b */
        /* JADX INFO: compiled from: ObservableBufferTimed.java */
        final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final U f22458a;

            b(U u) {
                this.f22458a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.l.remove(this.f22458a);
                }
                c cVar = c.this;
                cVar.b(this.f22458a, false, cVar.k);
            }
        }

        c(io.reactivex.w<? super U> wVar, Callable<U> callable, long j, long j2, TimeUnit timeUnit, x.c cVar) {
            super(wVar, new MpscLinkedQueue());
            this.g = callable;
            this.h = j;
            this.i = j2;
            this.j = timeUnit;
            this.k = cVar;
            this.l = new LinkedList();
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public /* bridge */ /* synthetic */ void a(io.reactivex.w wVar, Object obj) {
            a((io.reactivex.w<? super Collection>) wVar, (Collection) obj);
        }

        void d() {
            synchronized (this) {
                this.l.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f21858d) {
                return;
            }
            this.f21858d = true;
            d();
            this.m.dispose();
            this.k.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21858d;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.l);
                this.l.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f21857c.offer((U) ((Collection) it.next()));
            }
            this.f21859e = true;
            if (b()) {
                io.reactivex.internal.util.k.a(this.f21857c, this.f21856b, false, this.k, this);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f21859e = true;
            d();
            this.f21856b.onError(th);
            this.k.dispose();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.l.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.m, bVar)) {
                this.m = bVar;
                try {
                    U uCall = this.g.call();
                    io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                    U u = uCall;
                    this.l.add(u);
                    this.f21856b.onSubscribe(this);
                    x.c cVar = this.k;
                    long j = this.i;
                    cVar.a(this, j, j, this.j);
                    this.k.a(new b(u), this.h, this.j);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    bVar.dispose();
                    EmptyDisposable.error(th, this.f21856b);
                    this.k.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21858d) {
                return;
            }
            try {
                U uCall = this.g.call();
                io.reactivex.internal.functions.a.a(uCall, "The bufferSupplier returned a null buffer");
                U u = uCall;
                synchronized (this) {
                    if (this.f21858d) {
                        return;
                    }
                    this.l.add(u);
                    this.k.a(new a(u), this.h, this.j);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f21856b.onError(th);
                dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(io.reactivex.w<? super U> wVar, U u) {
            wVar.onNext(u);
        }
    }

    public C2916l(io.reactivex.u<T> uVar, long j, long j2, TimeUnit timeUnit, io.reactivex.x xVar, Callable<U> callable, int i, boolean z) {
        super(uVar);
        this.f22451b = j;
        this.f22452c = j2;
        this.f22453d = timeUnit;
        this.f22454e = xVar;
        this.f22455f = callable;
        this.g = i;
        this.h = z;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super U> wVar) {
        if (this.f22451b == this.f22452c && this.g == Integer.MAX_VALUE) {
            this.f22358a.subscribe(new b(new io.reactivex.observers.f(wVar), this.f22455f, this.f22451b, this.f22453d, this.f22454e));
            return;
        }
        x.c cVarA = this.f22454e.a();
        if (this.f22451b == this.f22452c) {
            this.f22358a.subscribe(new a(new io.reactivex.observers.f(wVar), this.f22455f, this.f22451b, this.f22453d, this.g, this.h, cVarA));
        } else {
            this.f22358a.subscribe(new c(new io.reactivex.observers.f(wVar), this.f22455f, this.f22451b, this.f22452c, this.f22453d, cVarA));
        }
    }
}
