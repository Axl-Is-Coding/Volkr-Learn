package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class ed extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0423eb f3167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3168b;

    public ed(C0423eb c0423eb) {
        this.f3167a = c0423eb;
    }

    private void b(Handler handler) {
        if (handler != null) {
            try {
                this.f3167a.f3147c.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler);
            } catch (Exception unused) {
            }
        }
    }

    public final void a(Handler handler) {
        if (this.f3168b) {
            return;
        }
        this.f3168b = true;
        b(handler);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getBooleanExtra("noConnectivity", false)) {
                this.f3167a.b((Object) (-1));
            } else if (C0458qa.e(context)) {
                this.f3167a.b((Object) 1);
            } else {
                this.f3167a.b((Object) 0);
            }
        } catch (Exception unused) {
        }
    }

    public final void a() {
        if (this.f3168b) {
            this.f3168b = false;
            try {
                this.f3167a.f3147c.unregisterReceiver(this);
            } catch (Exception unused) {
            }
        }
    }
}
