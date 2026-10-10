package c.t.m.g;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class Fa extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ Timer f2902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Ga f2903b;

    Fa(Ga ga, Timer timer) {
        this.f2903b = ga;
        this.f2902a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            this.f2902a.cancel();
        } catch (Throwable th) {
            C0458qa.a("timer cancel error.", th);
        }
    }
}
