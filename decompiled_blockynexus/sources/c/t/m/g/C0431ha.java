package c.t.m.g;

/* JADX INFO: renamed from: c.t.m.g.ha, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0431ha implements L, InterfaceC0425fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0431ha f3222a = new C0431ha();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC0425fa f3223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private L f3224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3225d = false;

    private C0431ha() {
    }

    public static C0431ha e() {
        return f3222a;
    }

    @Override // c.t.m.g.E
    public final void a() {
        this.f3223b.a();
    }

    @Override // c.t.m.g.E
    public final void a(int i) {
        this.f3223b.a(i);
    }

    @Override // c.t.m.g.InterfaceC0425fa
    public final void a(L l) {
        this.f3224c = l;
    }

    @Override // c.t.m.g.L
    public final void a(String str, String str2) {
        this.f3224c.a(str, str2);
    }

    @Override // c.t.m.g.L
    public final void a(String str, byte[] bArr, String str2) {
        this.f3224c.a(str, bArr, str2);
    }

    @Override // c.t.m.g.E
    public final void b() {
        this.f3223b.b();
    }

    @Override // c.t.m.g.L
    public final void c() {
        this.f3224c.c();
    }

    @Override // c.t.m.g.InterfaceC0425fa
    public final synchronized void d() {
        if (this.f3225d) {
            return;
        }
        this.f3223b = X.c();
        if (this.f3223b != null) {
            this.f3223b.a(this);
            this.f3223b.d();
        }
        this.f3225d = true;
    }
}
