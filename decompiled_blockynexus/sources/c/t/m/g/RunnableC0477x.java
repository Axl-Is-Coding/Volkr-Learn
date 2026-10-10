package c.t.m.g;

/* JADX INFO: renamed from: c.t.m.g.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0477x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ AbstractC0462s f3442a;

    RunnableC0477x(AbstractC0462s abstractC0462s) {
        this.f3442a = abstractC0462s;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3442a.f3376f.size() != 0) {
            this.f3442a.a(true, true);
        } else {
            this.f3442a.n.incrementAndGet();
            this.f3442a.b(false, true);
        }
    }
}
