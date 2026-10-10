package io.rong.imlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.rong.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class HeartbeatReceiver extends BroadcastReceiver {
    private static final String TAG = "HeartbeatReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onReceive: ");
        sb.append(intent != null ? intent.toString() : "null");
        RLog.d(TAG, sb.toString());
        HeartBeatManager.getInstance().ping(context);
    }
}
