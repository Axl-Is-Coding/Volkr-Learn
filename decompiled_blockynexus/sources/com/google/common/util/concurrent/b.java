package com.google.common.util.concurrent;

import com.google.common.base.v;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: AbstractFuture.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<V> implements n<V> {
    private static final a ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private volatile d listeners;
    private volatile Object value;
    private volatile j waiters;
    private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(b.class.getName());

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static abstract class a {
        private a() {
        }

        abstract void a(j jVar, j jVar2);

        abstract void a(j jVar, Thread thread);

        abstract boolean a(b<?> bVar, d dVar, d dVar2);

        abstract boolean a(b<?> bVar, j jVar, j jVar2);

        abstract boolean a(b<?> bVar, Object obj, Object obj2);
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class C0134b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f14037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f14038b;

        C0134b(boolean z, Throwable th) {
            this.f14037a = z;
            this.f14038b = th;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f14039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f14040b;

        static {
            final String str = "Failure occurred while trying to finish a future.";
            f14039a = new c(new Throwable(str) { // from class: com.google.common.util.concurrent.AbstractFuture$Failure$1
                @Override // java.lang.Throwable
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            });
        }

        c(Throwable th) {
            com.google.common.base.m.a(th);
            this.f14040b = th;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f14041a = new d(null, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f14042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f14043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d f14044d;

        d(Runnable runnable, Executor executor) {
            this.f14042b = runnable;
            this.f14043c = executor;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<j, Thread> f14045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<j, j> f14046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<b, j> f14047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<b, d> f14048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<b, Object> f14049e;

        e(AtomicReferenceFieldUpdater<j, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<j, j> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<b, j> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<b, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<b, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f14045a = atomicReferenceFieldUpdater;
            this.f14046b = atomicReferenceFieldUpdater2;
            this.f14047c = atomicReferenceFieldUpdater3;
            this.f14048d = atomicReferenceFieldUpdater4;
            this.f14049e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.b.a
        void a(j jVar, Thread thread) {
            this.f14045a.lazySet(jVar, thread);
        }

        @Override // com.google.common.util.concurrent.b.a
        void a(j jVar, j jVar2) {
            this.f14046b.lazySet(jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, j jVar, j jVar2) {
            return this.f14047c.compareAndSet(bVar, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, d dVar, d dVar2) {
            return this.f14048d.compareAndSet(bVar, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, Object obj, Object obj2) {
            return this.f14049e.compareAndSet(bVar, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final n<? extends V> f14050a;

        f(n<? extends V> nVar) {
            this.f14050a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.value != this) {
                return;
            }
            b.this.completeWithFuture(this.f14050a, this);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class g extends a {
        private g() {
            super();
        }

        @Override // com.google.common.util.concurrent.b.a
        void a(j jVar, Thread thread) {
            jVar.f14059b = thread;
        }

        @Override // com.google.common.util.concurrent.b.a
        void a(j jVar, j jVar2) {
            jVar.f14060c = jVar2;
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, j jVar, j jVar2) {
            synchronized (bVar) {
                if (((b) bVar).waiters != jVar) {
                    return false;
                }
                ((b) bVar).waiters = jVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, d dVar, d dVar2) {
            synchronized (bVar) {
                if (((b) bVar).listeners != dVar) {
                    return false;
                }
                ((b) bVar).listeners = dVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, Object obj, Object obj2) {
            synchronized (bVar) {
                if (((b) bVar).value != obj) {
                    return false;
                }
                ((b) bVar).value = obj2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    static abstract class h<V> extends b<V> {
        h() {
        }

        @Override // com.google.common.util.concurrent.b, com.google.common.util.concurrent.n
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.b, java.util.concurrent.Future
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.b, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.b, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.b, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Unsafe f14052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final long f14053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final long f14054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final long f14055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f14056e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f14057f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new com.google.common.util.concurrent.c());
                }
                try {
                    f14054c = unsafe.objectFieldOffset(b.class.getDeclaredField("waiters"));
                    f14053b = unsafe.objectFieldOffset(b.class.getDeclaredField("listeners"));
                    f14055d = unsafe.objectFieldOffset(b.class.getDeclaredField("value"));
                    f14056e = unsafe.objectFieldOffset(j.class.getDeclaredField("b"));
                    f14057f = unsafe.objectFieldOffset(j.class.getDeclaredField("c"));
                    f14052a = unsafe;
                } catch (Exception e2) {
                    v.a(e2);
                    throw null;
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        private i() {
            super();
        }

        @Override // com.google.common.util.concurrent.b.a
        void a(j jVar, Thread thread) {
            f14052a.putObject(jVar, f14056e, thread);
        }

        @Override // com.google.common.util.concurrent.b.a
        void a(j jVar, j jVar2) {
            f14052a.putObject(jVar, f14057f, jVar2);
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, j jVar, j jVar2) {
            return f14052a.compareAndSwapObject(bVar, f14054c, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, d dVar, d dVar2) {
            return f14052a.compareAndSwapObject(bVar, f14053b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.b.a
        boolean a(b<?> bVar, Object obj, Object obj2) {
            return f14052a.compareAndSwapObject(bVar, f14055d, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final j f14058a = new j(false);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Thread f14059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile j f14060c;

        j(boolean z) {
        }

        void a(j jVar) {
            b.ATOMIC_HELPER.a(this, jVar);
        }

        j() {
            b.ATOMIC_HELPER.a(this, Thread.currentThread());
        }

        void a() {
            Thread thread = this.f14059b;
            if (thread != null) {
                this.f14059b = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        a gVar;
        try {
            gVar = new i();
        } catch (Throwable th) {
            try {
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, "c"), AtomicReferenceFieldUpdater.newUpdater(b.class, j.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(b.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "value"));
            } catch (Throwable th2) {
                log.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
                log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
                gVar = new g();
            }
        }
        ATOMIC_HELPER = gVar;
        NULL = new Object();
    }

    protected b() {
    }

    static final CancellationException cancellationExceptionWithCause(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private d clearListeners() {
        d dVar;
        do {
            dVar = this.listeners;
        } while (!ATOMIC_HELPER.a((b<?>) this, dVar, d.f14041a));
        return dVar;
    }

    private j clearWaiters() {
        j jVar;
        do {
            jVar = this.waiters;
        } while (!ATOMIC_HELPER.a((b<?>) this, jVar, j.f14058a));
        return jVar;
    }

    private void complete() {
        for (j jVarClearWaiters = clearWaiters(); jVarClearWaiters != null; jVarClearWaiters = jVarClearWaiters.f14060c) {
            jVarClearWaiters.a();
        }
        d dVarClearListeners = clearListeners();
        d dVar = null;
        while (dVarClearListeners != null) {
            d dVar2 = dVarClearListeners.f14044d;
            dVarClearListeners.f14044d = dVar;
            dVar = dVarClearListeners;
            dVarClearListeners = dVar2;
        }
        while (dVar != null) {
            executeListener(dVar.f14042b, dVar.f14043c);
            dVar = dVar.f14044d;
        }
        done();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean completeWithFuture(n<? extends V> nVar, Object obj) {
        Object cVar;
        Object objA;
        if (nVar instanceof h) {
            objA = ((b) nVar).value;
        } else {
            try {
                objA = u.a(nVar);
                if (objA == null) {
                    objA = NULL;
                }
            } catch (CancellationException e2) {
                cVar = new C0134b(false, e2);
            } catch (ExecutionException e3) {
                cVar = new c(e3.getCause());
            } catch (Throwable th) {
                cVar = new c(th);
            }
        }
        cVar = objA;
        if (!ATOMIC_HELPER.a((b<?>) this, obj, cVar)) {
            return false;
        }
        complete();
        return true;
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof C0134b) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((C0134b) obj).f14038b);
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f14040b);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    private Throwable newCancellationCause() {
        return new CancellationException("Future.cancel() was called.");
    }

    private void removeWaiter(j jVar) {
        jVar.f14059b = null;
        while (true) {
            j jVar2 = this.waiters;
            if (jVar2 == j.f14058a) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.f14060c;
                if (jVar2.f14059b != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.f14060c = jVar4;
                    if (jVar3.f14059b == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.a((b<?>) this, jVar2, jVar4)) {
                    break;
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.n
    public void addListener(Runnable runnable, Executor executor) {
        com.google.common.base.m.a(runnable, "Runnable was null.");
        com.google.common.base.m.a(executor, "Executor was null.");
        d dVar = this.listeners;
        if (dVar != d.f14041a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f14044d = dVar;
                if (ATOMIC_HELPER.a((b<?>) this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.f14041a);
        }
        executeListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.value;
        if ((obj == null) | (obj instanceof f)) {
            C0134b c0134b = new C0134b(z, GENERATE_CANCELLATION_CAUSES ? newCancellationCause() : null);
            while (!ATOMIC_HELPER.a((b<?>) this, obj, (Object) c0134b)) {
                obj = this.value;
                if (!(obj instanceof f)) {
                }
            }
            if (z) {
                interruptTask();
            }
            complete();
            if (obj instanceof f) {
                ((f) obj).f14050a.cancel(z);
            }
            return true;
        }
        return false;
    }

    void done() {
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof f))) {
            return getDoneValue(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            j jVar = this.waiters;
            if (jVar != j.f14058a) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (ATOMIC_HELPER.a((b<?>) this, jVar, jVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(jVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(jVar2);
                    } else {
                        jVar = this.waiters;
                    }
                } while (jVar != j.f14058a);
            }
            return getDoneValue(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof f))) {
                return getDoneValue(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        throw new TimeoutException();
    }

    protected void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof C0134b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (obj != null) & (obj instanceof f ? false : true);
    }

    final void maybePropagateCancellation(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

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
    protected boolean set(V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (!ATOMIC_HELPER.a((b<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        complete();
        return true;
    }

    protected boolean setException(Throwable th) {
        com.google.common.base.m.a(th);
        if (!ATOMIC_HELPER.a((b<?>) this, (Object) null, (Object) new c(th))) {
            return false;
        }
        complete();
        return true;
    }

    protected boolean setFuture(n<? extends V> nVar) {
        c cVar;
        com.google.common.base.m.a(nVar);
        Object obj = this.value;
        if (obj == null) {
            if (nVar.isDone()) {
                return completeWithFuture(nVar, null);
            }
            f fVar = new f(nVar);
            if (ATOMIC_HELPER.a((b<?>) this, (Object) null, (Object) fVar)) {
                try {
                    nVar.addListener(fVar, MoreExecutors.a());
                    return true;
                } catch (Throwable th) {
                    try {
                        cVar = new c(th);
                    } catch (Throwable unused) {
                        cVar = c.f14039a;
                    }
                    ATOMIC_HELPER.a((b<?>) this, (Object) fVar, (Object) cVar);
                    return true;
                }
            }
            obj = this.value;
        }
        if (!(obj instanceof C0134b)) {
            return false;
        }
        nVar.cancel(((C0134b) obj).f14037a);
        return false;
    }

    final Throwable trustedGetException() {
        return ((c) this.value).f14040b;
    }

    protected final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof C0134b) && ((C0134b) obj).f14037a;
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return getDoneValue(obj2);
            }
            j jVar = this.waiters;
            if (jVar != j.f14058a) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (ATOMIC_HELPER.a((b<?>) this, jVar, jVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(jVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return getDoneValue(obj);
                    }
                    jVar = this.waiters;
                } while (jVar != j.f14058a);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
