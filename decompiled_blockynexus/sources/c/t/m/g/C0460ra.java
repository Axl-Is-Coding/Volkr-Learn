package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: c.t.m.g.ra, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class C0460ra extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ C0469ua f3369a;

    C0460ra(C0469ua c0469ua) {
        this.f3369a = c0469ua;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            return;
        }
        try {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            StringBuilder sb = new StringBuilder("intent:");
            sb.append(intent);
            sb.append(",");
            if (booleanExtra) {
                return;
            }
            C0458qa.a(this.f3369a.i, 107, 2000L);
        } catch (Throwable unused) {
        }
    }
}
