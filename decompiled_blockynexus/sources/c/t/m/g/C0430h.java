package c.t.m.g;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: c.t.m.g.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0430h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0430h f3219a = new C0430h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Runnable, TimerTask> f3221c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f3220b = new Timer("halley_" + fc.c() + "_ConnectionTimer", true);

    private C0430h() {
    }

    public static C0430h a() {
        return f3219a;
    }

    public final void a(Runnable runnable, boolean z, long j) {
        synchronized (runnable) {
            a(runnable);
            C0433i c0433i = new C0433i(runnable);
            if (z) {
                this.f3220b.schedule(c0433i, j, j);
            } else {
                this.f3220b.schedule(c0433i, j);
            }
            this.f3221c.put(runnable, c0433i);
        }
    }

    public final boolean a(Runnable runnable) {
        synchronized (runnable) {
            TimerTask timerTask = this.f3221c.get(runnable);
            if (timerTask == null) {
                return true;
            }
            this.f3221c.remove(runnable);
            return timerTask.cancel();
        }
    }
}
