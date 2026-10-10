package com.disabngo.blockynexus.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.util.Log;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkConnectChangedReceiver extends BroadcastReceiver {
    private String a(int i) {
        return i == 0 ? "3G网络数据" : i == 1 ? "WIFI网络" : "";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        Parcelable parcelableExtra;
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
            Log.e("TAG", "wifiState:" + intent.getIntExtra("wifi_state", 0));
        }
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
            boolean z = ((NetworkInfo) parcelableExtra).getState() == NetworkInfo.State.CONNECTED;
            Log.e("TAG", "isConnected:" + z);
            if (z) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_APP_WIFI_CONNECT);
            }
        }
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) == null) {
            return;
        }
        if (NetworkInfo.State.CONNECTED == networkInfo.getState() && networkInfo.isAvailable()) {
            if (networkInfo.getType() == 1 || networkInfo.getType() == 0) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_APP_CHECK_UPDATE);
                return;
            }
            return;
        }
        Log.i("TAG", a(networkInfo.getType()) + "断开");
    }
}
