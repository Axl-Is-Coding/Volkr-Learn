package io.rong.push.rongpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class PushReceiver extends BroadcastReceiver {
    private static final String TAG = "PushReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        RLog.d(TAG, "onReceive intent = " + intent);
        if (intent == null || intent.getAction() == null) {
            RLog.e(TAG, "intent or action is null.");
            return;
        }
        try {
            Intent intent2 = new Intent(context, (Class<?>) PushService.class);
            intent2.setAction(intent.getAction());
            intent2.putExtra(PushConst.PING_STRING_EXTRA, intent.getStringExtra(PushConst.PING_STRING_EXTRA));
            PushService.enqueueWork(context, intent2);
        } catch (SecurityException unused) {
            RLog.e(TAG, "SecurityException. Failed to start PushService.");
        }
    }
}
