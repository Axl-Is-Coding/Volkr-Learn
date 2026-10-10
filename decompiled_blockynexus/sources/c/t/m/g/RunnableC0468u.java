package c.t.m.g;

import android.os.SystemClock;

/* JADX INFO: renamed from: c.t.m.g.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0468u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ C0448n f3403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ long f3404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ C0465t f3405c;

    RunnableC0468u(C0465t c0465t, C0448n c0448n, long j) {
        this.f3405c = c0465t;
        this.f3403a = c0448n;
        this.f3404b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            C0457q c0457qA = this.f3403a.a();
            this.f3403a.k = SystemClock.elapsedRealtime() - this.f3404b;
            this.f3403a.a(false);
            if (c0457qA.f3344a == 0) {
                if (c0457qA.f3346c == 200) {
                    z = true;
                }
            }
        } catch (Throwable unused) {
        }
        C0465t.a(this.f3405c, z);
    }
}
