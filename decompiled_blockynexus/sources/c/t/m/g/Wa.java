package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class Wa extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ HandlerThread f3032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Handler f3033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ boolean f3034c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Timer f3035d;

    Wa(HandlerThread handlerThread, Handler handler, Timer timer) {
        this.f3032a = handlerThread;
        this.f3033b = handler;
        this.f3035d = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            Xa.a(this.f3032a);
            if (this.f3035d != null) {
                this.f3035d.cancel();
            }
        } catch (Throwable unused) {
        }
    }
}
