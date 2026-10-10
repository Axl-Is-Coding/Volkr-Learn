package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.X;

/* JADX INFO: renamed from: c.t.m.g.da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0419da implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ X f3116a;

    RunnableC0419da(X x) {
        this.f3116a = x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            qc.e();
            X.a aVarA = this.f3116a.a(qc.b());
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - aVarA.f3045a > X.c(aVarA.f3046b) || jElapsedRealtime < aVarA.f3045a) {
                X.e();
                this.f3116a.f3043e.removeCallbacks(this.f3116a.i);
                this.f3116a.f3043e.post(this.f3116a.i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
