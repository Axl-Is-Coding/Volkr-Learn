package io.rong.push.platform.google;

import android.os.Bundle;
import com.google.android.gms.gcm.GcmListenerService;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class RongGcmListenerService extends GcmListenerService {
    private static final String TAG = "RongGcmListenerService";

    @Override // com.google.android.gms.gcm.GcmListenerService
    public void onMessageReceived(String str, Bundle bundle) {
        RLog.d(TAG, "onMessageReceived");
        if (bundle == null) {
            return;
        }
        PushManager.getInstance().onPushRawData(this, PushType.GOOGLE_GCM, bundle.getString("message"));
    }
}
