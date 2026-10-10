package c.t.m.g;

/* JADX INFO: renamed from: c.t.m.g.ja, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0437ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ int f3255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ C0434ia f3256b;

    RunnableC0437ja(C0434ia c0434ia, int i) {
        this.f3256b = c0434ia;
        this.f3255a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3256b.f3236c.a(this.f3255a);
    }
}
