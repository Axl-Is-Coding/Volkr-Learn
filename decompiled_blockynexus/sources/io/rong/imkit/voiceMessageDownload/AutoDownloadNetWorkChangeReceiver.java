package io.rong.imkit.voiceMessageDownload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes5.dex */
public class AutoDownloadNetWorkChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            activeNetworkInfo = null;
        }
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && z) {
            HQVoiceMsgDownloadManager.getInstance().resumeDownloadService();
        } else {
            HQVoiceMsgDownloadManager.getInstance().pauseDownloadService();
        }
    }
}
