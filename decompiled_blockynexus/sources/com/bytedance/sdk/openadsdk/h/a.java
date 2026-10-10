package com.bytedance.sdk.openadsdk.h;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.i;
import com.bytedance.sdk.openadsdk.h.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: AbsTask.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a implements k {
    private static final AtomicLong m = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile com.bytedance.sdk.openadsdk.h.a.a f6818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.h.b.c f6819b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.h.d.a f6822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected volatile List<i.b> f6823f;
    protected volatile String g;
    protected volatile String h;
    protected volatile i i;
    protected volatile l j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AtomicInteger f6820c = new AtomicInteger();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final AtomicLong f6821d = new AtomicLong();
    protected volatile boolean k = false;
    public final long l = m.incrementAndGet();
    private final AtomicInteger n = new AtomicInteger(0);
    private int o = -1;

    public a(com.bytedance.sdk.openadsdk.h.a.a aVar, com.bytedance.sdk.openadsdk.h.b.c cVar) {
        this.f6818a = aVar;
        this.f6819b = cVar;
    }

    protected void a(Boolean bool, String str, Throwable th) {
    }

    public boolean b() {
        return this.n.get() == 1;
    }

    protected void c() {
        this.n.compareAndSet(0, 2);
    }

    public boolean d() {
        return this.n.get() == 2;
    }

    protected void e() throws com.bytedance.sdk.openadsdk.h.c.a {
        if (b()) {
            throw new com.bytedance.sdk.openadsdk.h.c.a();
        }
    }

    protected int f() {
        return this.i != null ? this.i.f6957c.f6958a : this.f6818a instanceof com.bytedance.sdk.openadsdk.h.a.b ? 1 : 0;
    }

    protected boolean g() {
        return f() == 1;
    }

    public void a() {
        this.n.compareAndSet(0, 1);
    }

    protected com.bytedance.sdk.openadsdk.h.e.a a(l.a aVar, int i, int i2, String str) throws IOException, VAdError {
        com.bytedance.sdk.openadsdk.h.e.b bVarB = com.bytedance.sdk.openadsdk.h.e.c.a().b();
        com.bytedance.sdk.openadsdk.h.e.f fVar = new com.bytedance.sdk.openadsdk.h.e.f();
        HashMap map = new HashMap();
        fVar.f6899b = aVar.f6979a;
        fVar.f6898a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            fVar.f6898a = 4;
        }
        List<i.b> list = this.f6823f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!"Range".equalsIgnoreCase(bVar.f6964a) && !"Connection".equalsIgnoreCase(bVar.f6964a) && !"Proxy-Connection".equalsIgnoreCase(bVar.f6964a) && !"Host".equalsIgnoreCase(bVar.f6964a)) {
                    map.put(bVar.f6964a, bVar.f6965b);
                }
            }
        }
        String strA = com.bytedance.sdk.openadsdk.h.g.d.a(i, i2);
        if (strA != null) {
            map.put("Range", strA);
        }
        if (e.f6893f) {
            map.put("Cache-Control", "no-cache");
        }
        d dVarC = d.c();
        f fVarA = f.a();
        boolean z = this.i == null;
        c cVarA = z ? dVarC.a() : fVarA.b();
        c cVarB = z ? dVarC.b() : fVarA.c();
        if (cVarA != null || cVarB != null) {
            if (cVarA != null) {
                fVar.f6900c = cVarA.a(aVar.f6980b);
            }
            if (cVarB != null) {
                fVar.f6901d = cVarB.a(aVar.f6980b);
            }
        }
        fVar.f6902e = map;
        if (this.k) {
            this.k = false;
            return null;
        }
        return bVarB.a(fVar);
    }

    protected void a(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = e.g;
        int iF = f();
        if (i3 == 1 || (i3 == 2 && iF == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.o) {
                    return;
                }
                this.o = i4;
                com.bytedance.sdk.openadsdk.h.g.d.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar = a.this;
                        com.bytedance.sdk.openadsdk.h.d.a aVar2 = aVar.f6822e;
                        if (aVar2 != null) {
                            aVar2.a(aVar.j, a.this.o);
                        }
                    }
                });
            }
        }
    }
}
