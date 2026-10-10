package c.t.m.g;

import c.t.m.g.qc;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: c.t.m.g.ia, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0434ia implements E, L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0434ia f3234a = new C0434ia();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0425fa f3236c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, F> f3235b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f3237d = new RunnableC0440ka(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f3238e = new RunnableC0443la(this);

    private C0434ia() {
        K k = new K();
        this.f3235b.put(k.b(), k);
        I i = new I();
        this.f3235b.put(i.b(), i);
        G g = new G();
        this.f3235b.put(g.b(), g);
        Runnable runnable = this.f3237d;
        if (!fc.g() && fc.o) {
            C0430h.a().a(runnable);
            C0430h.a().a(runnable, true, com.tendcloud.tenddata.ab.R);
        }
        Runnable runnable2 = this.f3238e;
        if (fc.g() || !fc.o) {
            return;
        }
        C0430h.a().a(runnable2);
        C0430h.a().a(runnable2, true, com.tendcloud.tenddata.ab.R);
    }

    public static C0434ia d() {
        return f3234a;
    }

    @Override // c.t.m.g.E
    public final void a() {
        this.f3236c.a();
    }

    @Override // c.t.m.g.E
    public final void a(int i) {
        fc.j().post(new RunnableC0437ja(this, i));
    }

    @Override // c.t.m.g.L
    public final void a(String str, byte[] bArr, String str2) {
        Runnable runnable = this.f3238e;
        long jA = qc.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!fc.g() && fc.o) {
            C0430h.a().a(runnable);
            C0430h.a().a(runnable, true, jA);
        }
        Iterator<F> it = this.f3235b.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, bArr, str2);
        }
    }

    @Override // c.t.m.g.E
    public final void b() {
        this.f3236c.b();
    }

    @Override // c.t.m.g.L
    public final void c() {
        Iterator<F> it = this.f3235b.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public final InterfaceC0428ga e() {
        return (InterfaceC0428ga) this.f3235b.get("settings");
    }

    public final pc f() {
        return (pc) this.f3235b.get("accessscheduler");
    }

    @Override // c.t.m.g.L
    public final void a(String str, String str2) {
        Runnable runnable = this.f3237d;
        long jA = qc.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!fc.g() && fc.o) {
            C0430h.a().a(runnable);
            C0430h.a().a(runnable, true, jA);
        }
        Iterator<F> it = this.f3235b.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
    }
}
