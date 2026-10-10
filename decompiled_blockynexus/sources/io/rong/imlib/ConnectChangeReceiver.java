package io.rong.imlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.rong.common.RLog;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.NetUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectChangeReceiver extends BroadcastReceiver {
    public static final String RECONNECT_ACTION = "action_reconnect";
    private static final String TAG = "ConnectChangeReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2 = "null";
        if (intent == null || intent.getAction() == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            RLog.e(TAG, "ConnectivityManager is null");
            return;
        }
        NetworkInfo activeNetworkInfo = null;
        try {
            RLog.d(TAG, "intent : " + intent.toString());
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            StringBuilder sb = new StringBuilder();
            sb.append("network : ");
            if (activeNetworkInfo != null) {
                str = activeNetworkInfo.isAvailable() + " " + activeNetworkInfo.isConnected();
            } else {
                str = "null";
            }
            sb.append(str);
            RLog.d(TAG, sb.toString());
        } catch (Exception e2) {
            RLog.e(TAG, "getActiveNetworkInfo Exception", e2);
        }
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        NetUtils.updateCacheNetworkAvailable(z);
        FwLog.write(3, 1, FwLog.LogTag.L_NETWORK_CHANGED_S.getTag(), "network|available", DeviceUtils.getNetworkType(context), Boolean.valueOf(z));
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && z) {
            RongIMClient.reconnectServer();
            return;
        }
        if (intent.getAction().equals(RECONNECT_ACTION) && z) {
            RongIMClient.reconnectServer();
            return;
        }
        if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            if (RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE) && z) {
                RongIMClient.reconnectServer();
                return;
            }
            return;
        }
        if (intent.getAction().equals(RECONNECT_ACTION) && activeNetworkInfo != null && activeNetworkInfo.isAvailable() && !activeNetworkInfo.isConnected()) {
            if (RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE) && z) {
                RongIMClient.reconnectServer();
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Network exception, NetworkInfo = ");
        if (activeNetworkInfo != null) {
            str2 = activeNetworkInfo.isAvailable() + ", " + activeNetworkInfo.isConnected();
        }
        sb2.append(str2);
        RLog.e(TAG, sb2.toString());
    }
}
