package c.t.m.g;

import java.util.TimerTask;

/* JADX INFO: renamed from: c.t.m.g.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0433i extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ Runnable f3233a;

    C0433i(Runnable runnable) {
        this.f3233a = runnable;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f3233a.run();
    }
}
