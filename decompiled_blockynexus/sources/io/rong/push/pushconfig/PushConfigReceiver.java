package io.rong.push.pushconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.rong.push.PushManager;
import io.rong.push.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class PushConfigReceiver extends BroadcastReceiver {
    private final String TAG = PushConfigReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        try {
            RLog.d(this.TAG, "intent : " + intent.toString());
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            String str2 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("network : ");
            if (activeNetworkInfo != null) {
                str = activeNetworkInfo.isAvailable() + " " + activeNetworkInfo.isConnected();
            } else {
                str = "null";
            }
            sb.append(str);
            RLog.d(str2, sb.toString());
        } catch (Exception e2) {
            RLog.e(this.TAG, "getActiveNetworkInfo Exception");
            e2.printStackTrace();
        }
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        if ((intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || intent.getAction().equals("android.intent.action.USER_PRESENT")) && z) {
            PushManager.getInstance().onNetworkReconfigEvent(context);
        }
    }
}
