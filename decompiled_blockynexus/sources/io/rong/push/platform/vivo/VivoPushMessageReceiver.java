package io.rong.push.platform.vivo;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import io.rong.push.PushManager;
import io.rong.push.PushType;
import io.rong.push.RongPushClient;
import io.rong.push.common.RLog;
import io.rong.push.notification.PushNotificationMessage;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class VivoPushMessageReceiver extends OpenClientPushMessageReceiver {
    private static final String TAG = "VivoPushMessageReceiver";

    private PushNotificationMessage.PushSourceType getType(int i) {
        for (PushNotificationMessage.PushSourceType pushSourceType : PushNotificationMessage.PushSourceType.values()) {
            if (pushSourceType.ordinal() == i) {
                return pushSourceType;
            }
        }
        return PushNotificationMessage.PushSourceType.LOCAL_MESSAGE;
    }

    private PushNotificationMessage transformVivoToPushMessage(String str, String str2, Map<String, String> map) {
        String str3;
        if (map == null || (str3 = map.get("rc")) == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            PushNotificationMessage pushNotificationMessage = new PushNotificationMessage();
            pushNotificationMessage.setPushTitle(str);
            pushNotificationMessage.setPushContent(str2);
            pushNotificationMessage.setConversationType(RongPushClient.ConversationType.setValue(jSONObject.optInt("conversationType")));
            pushNotificationMessage.setSourceType(getType(jSONObject.optInt("sourceType")));
            pushNotificationMessage.setSenderId(jSONObject.optString("fromUserId"));
            pushNotificationMessage.setObjectName(jSONObject.optString("objectName"));
            pushNotificationMessage.setPushId(jSONObject.optString("id"));
            pushNotificationMessage.setToId(jSONObject.optString("tId"));
            pushNotificationMessage.setTargetId(jSONObject.optString("targetId"));
            String str4 = map.get("appData");
            if (str4 != null) {
                pushNotificationMessage.setPushData(str4);
            }
            return pushNotificationMessage;
        } catch (JSONException e2) {
            RLog.e("PushUtils", "transformToPushMessage:" + e2.getMessage());
            return null;
        }
    }

    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        RLog.v(TAG, "onNotificationMessageClicked is called. " + uPSNotificationMessage.getContent() + ", " + uPSNotificationMessage.getParams());
        PushNotificationMessage pushNotificationMessageTransformVivoToPushMessage = transformVivoToPushMessage(uPSNotificationMessage.getTitle(), uPSNotificationMessage.getContent(), uPSNotificationMessage.getParams());
        if (pushNotificationMessageTransformVivoToPushMessage != null) {
            PushManager.getInstance().onNotificationMessageClicked(context, PushType.VIVO, pushNotificationMessageTransformVivoToPushMessage);
        }
    }

    public void onReceiveRegId(Context context, String str) {
        RLog.d(TAG, "Vivo onReceiveRegId:" + str);
        PushManager.getInstance().onReceiveToken(context, PushType.VIVO, str);
    }
}
