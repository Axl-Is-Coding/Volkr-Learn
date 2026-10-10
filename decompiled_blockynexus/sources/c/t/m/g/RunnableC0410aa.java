package c.t.m.g;

/* JADX INFO: renamed from: c.t.m.g.aa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0410aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ Y f3081a;

    RunnableC0410aa(Y y) {
        this.f3081a = y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            X.c().f3041c.a(this.f3081a.f3056a.a(), N.a().b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
