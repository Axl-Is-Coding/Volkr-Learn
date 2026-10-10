package io.rong.push.platform.google;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.common.RLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class RongFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "RongFirebaseMessagingService";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage == null) {
            return;
        }
        try {
            PushManager.getInstance().onPushRawData(this, PushType.GOOGLE_FCM, new JSONObject(remoteMessage.getData()).getString("message"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        RLog.d(TAG, "on NewToken");
        PushManager.getInstance().onReceiveToken(this, PushType.GOOGLE_FCM, str);
    }
}
