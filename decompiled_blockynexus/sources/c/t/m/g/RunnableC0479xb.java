package c.t.m.g;

import android.content.IntentFilter;

/* JADX INFO: renamed from: c.t.m.g.xb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0479xb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ eh f3444a;

    RunnableC0479xb(eh ehVar) {
        this.f3444a = ehVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        try {
            if (this.f3444a.h != null) {
                this.f3444a.f3171c.f3147c.registerReceiver(this.f3444a, intentFilter, null, this.f3444a.h);
            } else {
                this.f3444a.f3171c.f3147c.registerReceiver(this.f3444a, intentFilter);
            }
        } catch (Exception unused) {
        }
    }
}
