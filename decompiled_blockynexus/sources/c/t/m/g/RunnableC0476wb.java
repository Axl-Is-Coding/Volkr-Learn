package c.t.m.g;

/* JADX INFO: renamed from: c.t.m.g.wb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0476wb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ eh f3441a;

    RunnableC0476wb(eh ehVar) {
        this.f3441a = ehVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3441a.b();
        if (this.f3441a.o > 0) {
            eh ehVar = this.f3441a;
            ehVar.a(ehVar.o);
        }
    }
}
