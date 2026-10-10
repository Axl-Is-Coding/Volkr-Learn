package io.rong.imkit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.rong.imkit.manager.AudioPlayManager;
import io.rong.imkit.manager.AudioRecordManager;

/* JADX INFO: loaded from: classes5.dex */
public class RongKitReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        AudioPlayManager.getInstance().stopPlay();
        AudioRecordManager.getInstance().destroyRecord();
    }
}
