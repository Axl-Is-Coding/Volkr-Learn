package com.disabngo.blockynexus.service;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.sandboxol.common.base.app.BaseApplication;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.RLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class PushListenerService extends FirebaseMessagingService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10495a = "PushListenerService";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(f10495a, "Message: " + remoteMessage.getData());
        if (remoteMessage != null) {
            try {
                PushManager.getInstance().onPushRawData(this, PushType.GOOGLE_FCM, new JSONObject(remoteMessage.getData()).getString("message"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        RLog.d("RongFirebaseMessagingService", "on NewToken");
        PushManager.getInstance().onReceiveToken(this, PushType.GOOGLE_FCM, str);
        FirebaseAnalytics.getInstance(BaseApplication.getContext()).setAnalyticsCollectionEnabled(true);
    }
}
