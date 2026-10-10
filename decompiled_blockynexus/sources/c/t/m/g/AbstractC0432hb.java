package c.t.m.g;

import android.os.Looper;
import android.os.PowerManager;

/* JADX INFO: renamed from: c.t.m.g.hb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0432hb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static PowerManager.WakeLock f3226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f3227b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f3228c = new byte[0];

    public abstract int a(Looper looper);

    public abstract String a();

    public final int b(Looper looper) {
        synchronized (this.f3228c) {
            if (this.f3227b) {
                return -1;
            }
            this.f3227b = true;
            a();
            return a(looper);
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f3228c) {
            z = this.f3227b;
        }
        return z;
    }
}
