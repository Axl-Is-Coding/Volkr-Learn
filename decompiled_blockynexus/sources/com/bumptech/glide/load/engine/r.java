package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.b.a;
import com.bumptech.glide.load.engine.b.i;
import com.bumptech.glide.load.engine.w;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes.dex */
public class r implements i.a, t, w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f4587a = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f4588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v f4589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b.i f4590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f4591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final F f4592f;
    private final c g;
    private final a h;
    private final ActiveResources i;

    /* JADX INFO: compiled from: Engine.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DecodeJob.d f4593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.core.f.e<DecodeJob<?>> f4594b = com.bumptech.glide.e.a.d.a(150, new q(this));

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4595c;

        a(DecodeJob.d dVar) {
            this.f4593a = dVar;
        }

        <R> DecodeJob<R> a(com.bumptech.glide.f fVar, Object obj, u uVar, com.bumptech.glide.load.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, p pVar, Map<Class<?>, com.bumptech.glide.load.o<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.l lVar, DecodeJob.a<R> aVar) {
            DecodeJob decodeJobA = this.f4594b.a();
            com.bumptech.glide.e.l.a(decodeJobA);
            DecodeJob decodeJob = decodeJobA;
            int i3 = this.f4595c;
            this.f4595c = i3 + 1;
            decodeJob.a(fVar, obj, uVar, hVar, i, i2, cls, cls2, priority, pVar, map, z, z2, z3, lVar, aVar, i3);
            return decodeJob;
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    private static class c implements DecodeJob.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0061a f4602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.b.a f4603b;

        c(a.InterfaceC0061a interfaceC0061a) {
            this.f4602a = interfaceC0061a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.d
        public com.bumptech.glide.load.engine.b.a a() {
            if (this.f4603b == null) {
                synchronized (this) {
                    if (this.f4603b == null) {
                        this.f4603b = this.f4602a.build();
                    }
                    if (this.f4603b == null) {
                        this.f4603b = new com.bumptech.glide.load.engine.b.b();
                    }
                }
            }
            return this.f4603b;
        }

        synchronized void b() {
            if (this.f4603b == null) {
                return;
            }
            this.f4603b.clear();
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EngineJob<?> f4604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.g f4605b;

        d(com.bumptech.glide.request.g gVar, EngineJob<?> engineJob) {
            this.f4605b = gVar;
            this.f4604a = engineJob;
        }

        public void a() {
            synchronized (r.this) {
                this.f4604a.removeCallback(this.f4605b);
            }
        }
    }

    public r(com.bumptech.glide.load.engine.b.i iVar, a.InterfaceC0061a interfaceC0061a, com.bumptech.glide.load.engine.c.a aVar, com.bumptech.glide.load.engine.c.a aVar2, com.bumptech.glide.load.engine.c.a aVar3, com.bumptech.glide.load.engine.c.a aVar4, boolean z) {
        this(iVar, interfaceC0061a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    private w<?> b(com.bumptech.glide.load.h hVar) {
        w<?> wVarB = this.i.b(hVar);
        if (wVarB != null) {
            wVarB.b();
        }
        return wVarB;
    }

    private w<?> c(com.bumptech.glide.load.h hVar) {
        w<?> wVarA = a(hVar);
        if (wVarA != null) {
            wVarA.b();
            this.i.a(hVar, wVarA);
        }
        return wVarA;
    }

    public <R> d a(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, p pVar, Map<Class<?>, com.bumptech.glide.load.o<?>> map, boolean z, boolean z2, com.bumptech.glide.load.l lVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.g gVar, Executor executor) {
        long jA = f4587a ? com.bumptech.glide.e.h.a() : 0L;
        u uVarA = this.f4589c.a(obj, hVar, i, i2, map, cls, cls2, lVar);
        synchronized (this) {
            w<?> wVarA = a(uVarA, z3, jA);
            if (wVarA == null) {
                return a(fVar, obj, hVar, i, i2, cls, cls2, priority, pVar, map, z, z2, lVar, z3, z4, z5, z6, gVar, executor, uVarA, jA);
            }
            gVar.a(wVarA, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    r(com.bumptech.glide.load.engine.b.i iVar, a.InterfaceC0061a interfaceC0061a, com.bumptech.glide.load.engine.c.a aVar, com.bumptech.glide.load.engine.c.a aVar2, com.bumptech.glide.load.engine.c.a aVar3, com.bumptech.glide.load.engine.c.a aVar4, y yVar, v vVar, ActiveResources activeResources, b bVar, a aVar5, F f2, boolean z) {
        this.f4590d = iVar;
        this.g = new c(interfaceC0061a);
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.i = activeResources2;
        activeResources2.a(this);
        this.f4589c = vVar == null ? new v() : vVar;
        this.f4588b = yVar == null ? new y() : yVar;
        this.f4591e = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.h = aVar5 == null ? new a(this.g) : aVar5;
        this.f4592f = f2 == null ? new F() : f2;
        iVar.a(this);
    }

    public void b(C<?> c2) {
        if (c2 instanceof w) {
            ((w) c2).e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /* JADX INFO: compiled from: Engine.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f4596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f4597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f4598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.a f4599d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final t f4600e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final w.a f4601f;
        final androidx.core.f.e<EngineJob<?>> g = com.bumptech.glide.e.a.d.a(150, new s(this));

        b(com.bumptech.glide.load.engine.c.a aVar, com.bumptech.glide.load.engine.c.a aVar2, com.bumptech.glide.load.engine.c.a aVar3, com.bumptech.glide.load.engine.c.a aVar4, t tVar, w.a aVar5) {
            this.f4596a = aVar;
            this.f4597b = aVar2;
            this.f4598c = aVar3;
            this.f4599d = aVar4;
            this.f4600e = tVar;
            this.f4601f = aVar5;
        }

        void a() {
            com.bumptech.glide.e.g.a(this.f4596a);
            com.bumptech.glide.e.g.a(this.f4597b);
            com.bumptech.glide.e.g.a(this.f4598c);
            com.bumptech.glide.e.g.a(this.f4599d);
        }

        <R> EngineJob<R> a(com.bumptech.glide.load.h hVar, boolean z, boolean z2, boolean z3, boolean z4) {
            EngineJob<?> engineJobA = this.g.a();
            com.bumptech.glide.e.l.a(engineJobA);
            return (EngineJob<R>) engineJobA.a(hVar, z, z2, z3, z4);
        }
    }

    private <R> d a(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, p pVar, Map<Class<?>, com.bumptech.glide.load.o<?>> map, boolean z, boolean z2, com.bumptech.glide.load.l lVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.g gVar, Executor executor, u uVar, long j) {
        EngineJob<?> engineJobA = this.f4588b.a(uVar, z6);
        if (engineJobA != null) {
            engineJobA.addCallback(gVar, executor);
            if (f4587a) {
                a("Added to existing load", j, uVar);
            }
            return new d(gVar, engineJobA);
        }
        EngineJob<R> engineJobA2 = this.f4591e.a(uVar, z3, z4, z5, z6);
        DecodeJob<R> decodeJobA = this.h.a(fVar, obj, uVar, hVar, i, i2, cls, cls2, priority, pVar, map, z, z2, z6, lVar, engineJobA2);
        this.f4588b.a((com.bumptech.glide.load.h) uVar, (EngineJob<?>) engineJobA2);
        engineJobA2.addCallback(gVar, executor);
        engineJobA2.b(decodeJobA);
        if (f4587a) {
            a("Started new load", j, uVar);
        }
        return new d(gVar, engineJobA2);
    }

    private w<?> a(u uVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        w<?> wVarB = b(uVar);
        if (wVarB != null) {
            if (f4587a) {
                a("Loaded resource from active resources", j, uVar);
            }
            return wVarB;
        }
        w<?> wVarC = c(uVar);
        if (wVarC == null) {
            return null;
        }
        if (f4587a) {
            a("Loaded resource from cache", j, uVar);
        }
        return wVarC;
    }

    private static void a(String str, long j, com.bumptech.glide.load.h hVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.e.h.a(j) + "ms, key: " + hVar);
    }

    private w<?> a(com.bumptech.glide.load.h hVar) {
        C<?> cA = this.f4590d.a(hVar);
        if (cA == null) {
            return null;
        }
        if (cA instanceof w) {
            return (w) cA;
        }
        return new w<>(cA, true, true, hVar, this);
    }

    @Override // com.bumptech.glide.load.engine.t
    public synchronized void a(EngineJob<?> engineJob, com.bumptech.glide.load.h hVar, w<?> wVar) {
        if (wVar != null) {
            if (wVar.d()) {
                this.i.a(hVar, wVar);
            }
            this.f4588b.b(hVar, engineJob);
        } else {
            this.f4588b.b(hVar, engineJob);
        }
    }

    @Override // com.bumptech.glide.load.engine.t
    public synchronized void a(EngineJob<?> engineJob, com.bumptech.glide.load.h hVar) {
        this.f4588b.b(hVar, engineJob);
    }

    @Override // com.bumptech.glide.load.engine.b.i.a
    public void a(C<?> c2) {
        this.f4592f.a(c2, true);
    }

    @Override // com.bumptech.glide.load.engine.w.a
    public void a(com.bumptech.glide.load.h hVar, w<?> wVar) {
        this.i.a(hVar);
        if (wVar.d()) {
            this.f4590d.a(hVar, wVar);
        } else {
            this.f4592f.a(wVar, false);
        }
    }

    public void a() {
        this.f4591e.a();
        this.g.b();
        this.i.b();
    }
}
