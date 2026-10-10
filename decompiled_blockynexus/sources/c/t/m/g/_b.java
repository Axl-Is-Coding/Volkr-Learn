package c.t.m.g;

/* JADX INFO: loaded from: classes.dex */
final class _b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ cc f3078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ ac f3079b;

    _b(cc ccVar, ac acVar) {
        this.f3078a = ccVar;
        this.f3079b = acVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3079b.a(this.f3078a.a());
        this.f3079b.o.countDown();
    }
}
