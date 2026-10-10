package com.bumptech.glide.load.engine;

import com.bumptech.glide.e.a.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class EngineJob<R> implements DecodeJob.a<R>, d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f4440a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f4441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.e.a.g f4442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w.a f4443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.core.f.e<EngineJob<?>> f4444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f4445f;
    private final t g;
    private final com.bumptech.glide.load.engine.c.a h;
    private final com.bumptech.glide.load.engine.c.a i;
    private final com.bumptech.glide.load.engine.c.a j;
    private final com.bumptech.glide.load.engine.c.a k;
    private final AtomicInteger l;
    private com.bumptech.glide.load.h m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private C<?> r;
    DataSource s;
    private boolean t;
    GlideException u;
    private boolean v;
    w<?> w;
    private DecodeJob<R> x;
    private volatile boolean y;

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.request.g f4446a;

        a(com.bumptech.glide.request.g gVar) {
            this.f4446a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f4446a.c()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f4441b.a(this.f4446a)) {
                        EngineJob.this.a(this.f4446a);
                    }
                    EngineJob.this.c();
                }
            }
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.request.g f4448a;

        b(com.bumptech.glide.request.g gVar) {
            this.f4448a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f4448a.c()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f4441b.a(this.f4448a)) {
                        EngineJob.this.w.b();
                        EngineJob.this.b(this.f4448a);
                        EngineJob.this.removeCallback(this.f4448a);
                    }
                    EngineJob.this.c();
                }
            }
        }
    }

    static class c {
        c() {
        }

        public <R> w<R> a(C<R> c2, boolean z, com.bumptech.glide.load.h hVar, w.a aVar) {
            return new w<>(c2, z, true, hVar, aVar);
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.request.g f4450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f4451b;

        d(com.bumptech.glide.request.g gVar, Executor executor) {
            this.f4450a = gVar;
            this.f4451b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f4450a.equals(((d) obj).f4450a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4450a.hashCode();
        }
    }

    static final class e implements Iterable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<d> f4452a;

        e() {
            this(new ArrayList(2));
        }

        private static d c(com.bumptech.glide.request.g gVar) {
            return new d(gVar, com.bumptech.glide.e.g.a());
        }

        void a(com.bumptech.glide.request.g gVar, Executor executor) {
            this.f4452a.add(new d(gVar, executor));
        }

        void b(com.bumptech.glide.request.g gVar) {
            this.f4452a.remove(c(gVar));
        }

        void clear() {
            this.f4452a.clear();
        }

        boolean isEmpty() {
            return this.f4452a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f4452a.iterator();
        }

        int size() {
            return this.f4452a.size();
        }

        e(List<d> list) {
            this.f4452a = list;
        }

        boolean a(com.bumptech.glide.request.g gVar) {
            return this.f4452a.contains(c(gVar));
        }

        e a() {
            return new e(new ArrayList(this.f4452a));
        }
    }

    EngineJob(com.bumptech.glide.load.engine.c.a aVar, com.bumptech.glide.load.engine.c.a aVar2, com.bumptech.glide.load.engine.c.a aVar3, com.bumptech.glide.load.engine.c.a aVar4, t tVar, w.a aVar5, androidx.core.f.e<EngineJob<?>> eVar) {
        this(aVar, aVar2, aVar3, aVar4, tVar, aVar5, eVar, f4440a);
    }

    private com.bumptech.glide.load.engine.c.a g() {
        return this.o ? this.j : this.p ? this.k : this.i;
    }

    private boolean h() {
        return this.v || this.t || this.y;
    }

    private synchronized void i() {
        if (this.m == null) {
            throw new IllegalArgumentException();
        }
        this.f4441b.clear();
        this.m = null;
        this.w = null;
        this.r = null;
        this.v = false;
        this.y = false;
        this.t = false;
        this.x.a(false);
        this.x = null;
        this.u = null;
        this.s = null;
        this.f4444e.a(this);
    }

    synchronized EngineJob<R> a(com.bumptech.glide.load.h hVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.m = hVar;
        this.n = z;
        this.o = z2;
        this.p = z3;
        this.q = z4;
        return this;
    }

    synchronized void addCallback(com.bumptech.glide.request.g gVar, Executor executor) {
        this.f4442c.b();
        this.f4441b.a(gVar, executor);
        boolean z = true;
        if (this.t) {
            a(1);
            executor.execute(new b(gVar));
        } else if (this.v) {
            a(1);
            executor.execute(new a(gVar));
        } else {
            if (this.y) {
                z = false;
            }
            com.bumptech.glide.e.l.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public synchronized void b(DecodeJob<R> decodeJob) {
        this.x = decodeJob;
        (decodeJob.d() ? this.h : g()).execute(decodeJob);
    }

    void c() {
        w<?> wVar;
        synchronized (this) {
            this.f4442c.b();
            com.bumptech.glide.e.l.a(h(), "Not yet complete!");
            int iDecrementAndGet = this.l.decrementAndGet();
            com.bumptech.glide.e.l.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                wVar = this.w;
                i();
            } else {
                wVar = null;
            }
        }
        if (wVar != null) {
            wVar.e();
        }
    }

    void d() {
        synchronized (this) {
            this.f4442c.b();
            if (this.y) {
                i();
                return;
            }
            if (this.f4441b.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.v) {
                throw new IllegalStateException("Already failed once");
            }
            this.v = true;
            com.bumptech.glide.load.h hVar = this.m;
            e eVarA = this.f4441b.a();
            a(eVarA.size() + 1);
            this.g.a(this, hVar, null);
            for (d dVar : eVarA) {
                dVar.f4451b.execute(new a(dVar.f4450a));
            }
            c();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void e() {
        synchronized (this) {
            this.f4442c.b();
            if (this.y) {
                this.r.recycle();
                i();
                return;
            }
            if (this.f4441b.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.t) {
                throw new IllegalStateException("Already have resource");
            }
            this.w = this.f4445f.a(this.r, this.n, this.m, this.f4443d);
            this.t = true;
            e eVarA = this.f4441b.a();
            a(eVarA.size() + 1);
            this.g.a(this, this.m, this.w);
            for (d dVar : eVarA) {
                dVar.f4451b.execute(new b(dVar.f4450a));
            }
            c();
        }
    }

    boolean f() {
        return this.q;
    }

    synchronized void removeCallback(com.bumptech.glide.request.g gVar) {
        this.f4442c.b();
        this.f4441b.b(gVar);
        if (this.f4441b.isEmpty()) {
            a();
            if ((this.t || this.v) && this.l.get() == 0) {
                i();
            }
        }
    }

    EngineJob(com.bumptech.glide.load.engine.c.a aVar, com.bumptech.glide.load.engine.c.a aVar2, com.bumptech.glide.load.engine.c.a aVar3, com.bumptech.glide.load.engine.c.a aVar4, t tVar, w.a aVar5, androidx.core.f.e<EngineJob<?>> eVar, c cVar) {
        this.f4441b = new e();
        this.f4442c = com.bumptech.glide.e.a.g.a();
        this.l = new AtomicInteger();
        this.h = aVar;
        this.i = aVar2;
        this.j = aVar3;
        this.k = aVar4;
        this.g = tVar;
        this.f4443d = aVar5;
        this.f4444e = eVar;
        this.f4445f = cVar;
    }

    void b(com.bumptech.glide.request.g gVar) {
        try {
            gVar.a(this.w, this.s);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void a(com.bumptech.glide.request.g gVar) {
        try {
            gVar.a(this.u);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    @Override // com.bumptech.glide.e.a.d.c
    public com.bumptech.glide.e.a.g b() {
        return this.f4442c;
    }

    void a() {
        if (h()) {
            return;
        }
        this.y = true;
        this.x.a();
        this.g.a(this, this.m);
    }

    synchronized void a(int i) {
        com.bumptech.glide.e.l.a(h(), "Not yet complete!");
        if (this.l.getAndAdd(i) == 0 && this.w != null) {
            this.w.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(C<R> c2, DataSource dataSource) {
        synchronized (this) {
            this.r = c2;
            this.s = dataSource;
        }
        e();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(GlideException glideException) {
        synchronized (this) {
            this.u = glideException;
        }
        d();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.a
    public void a(DecodeJob<?> decodeJob) {
        g().execute(decodeJob);
    }
}
