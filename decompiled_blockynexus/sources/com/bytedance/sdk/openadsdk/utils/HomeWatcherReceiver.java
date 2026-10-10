package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7080a;

    public interface a {
        void F();

        void G();
    }

    public void a(a aVar) {
        this.f7080a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        Log.i("HomeReceiver", "onReceive: action: " + action);
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
            String stringExtra = intent.getStringExtra("reason");
            Log.i("HomeReceiver", "reason: " + stringExtra);
            if ("homekey".equals(stringExtra)) {
                Log.i("HomeReceiver", "homekey");
                a aVar = this.f7080a;
                if (aVar != null) {
                    aVar.F();
                    return;
                }
                return;
            }
            if (!"recentapps".equals(stringExtra)) {
                if ("assist".equals(stringExtra)) {
                    Log.i("HomeReceiver", "assist");
                }
            } else {
                Log.i("HomeReceiver", "long press home key or activity switch");
                a aVar2 = this.f7080a;
                if (aVar2 != null) {
                    aVar2.G();
                }
            }
        }
    }
}
