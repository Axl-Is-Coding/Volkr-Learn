package io.rong.push.core;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.GoogleApiAvailability;
import io.rong.common.rlog.RLog;
import io.rong.imlib.common.DeviceUtils;
import io.rong.push.PushType;
import io.rong.push.RongPushClient;
import io.rong.push.notification.PushNotificationMessage;
import io.rong.push.pushconfig.PushConfig;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class PushUtils {
    private static final String PUSH_NAVI = "nav.cn.ronghub.com";
    private static final String PUSH_NAVI_BACKUP = "nav2-cn.ronghub.com";

    public static long checkPlayServices(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }

    public static String getDefaultNavi() {
        return "nav.cn.ronghub.com;nav2-cn.ronghub.com";
    }

    public static String getPackageName(String str) {
        try {
            return new JSONObject(str).optString("packageName");
        } catch (JSONException e2) {
            RLog.e("PushUtils", "getPackageName", e2);
            return "";
        }
    }

    public static PushType getPreferPushType(Context context, PushConfig pushConfig) {
        String lowerCase = DeviceUtils.getDeviceManufacturer().toLowerCase();
        Set<PushType> enabledPushTypes = pushConfig.getEnabledPushTypes();
        return (lowerCase.contains("Xiaomi".toLowerCase()) && enabledPushTypes.contains(PushType.XIAOMI)) ? PushType.XIAOMI : (lowerCase.contains("HUAWEI".toLowerCase()) && enabledPushTypes.contains(PushType.HUAWEI)) ? PushType.HUAWEI : (lowerCase.contains("Meizu".toLowerCase()) && enabledPushTypes.contains(PushType.MEIZU)) ? PushType.MEIZU : (lowerCase.contains("oppo".toLowerCase()) && enabledPushTypes.contains(PushType.OPPO)) ? PushType.OPPO : (lowerCase.contains("VIVO".toLowerCase()) && enabledPushTypes.contains(PushType.VIVO)) ? PushType.VIVO : (enabledPushTypes.contains(PushType.GOOGLE_GCM) || enabledPushTypes.contains(PushType.GOOGLE_FCM)) ? PushType.UNKNOWN : PushType.RONG;
    }

    public static PushNotificationMessage transformToPushMessage(String str) {
        String str2;
        String strOptString;
        String strOptString2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            PushNotificationMessage pushNotificationMessage = new PushNotificationMessage();
            String strOptString3 = jSONObject.optString("channelType");
            int i = 0;
            if (!TextUtils.isEmpty(strOptString3)) {
                try {
                    i = Integer.parseInt(strOptString3);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            RongPushClient.ConversationType value = RongPushClient.ConversationType.setValue(i);
            pushNotificationMessage.setConversationType(value);
            if (value.equals(RongPushClient.ConversationType.DISCUSSION) || value.equals(RongPushClient.ConversationType.GROUP) || value.equals(RongPushClient.ConversationType.CHATROOM)) {
                pushNotificationMessage.setTargetId(jSONObject.optString("channelId"));
                pushNotificationMessage.setTargetUserName(jSONObject.optString("channelName"));
            } else {
                pushNotificationMessage.setTargetId(jSONObject.optString("fromUserId"));
                pushNotificationMessage.setTargetUserName(jSONObject.optString("fromUserName"));
            }
            pushNotificationMessage.setReceivedTime(jSONObject.optLong("timeStamp"));
            pushNotificationMessage.setObjectName(jSONObject.optString("objectName"));
            pushNotificationMessage.setSenderId(jSONObject.optString("fromUserId"));
            pushNotificationMessage.setSenderName(jSONObject.optString("fromUserName"));
            pushNotificationMessage.setSenderPortrait(TextUtils.isEmpty(jSONObject.optString("fromUserPo")) ? null : Uri.parse(jSONObject.optString("fromUserPo")));
            pushNotificationMessage.setPushTitle(jSONObject.optString("title"));
            pushNotificationMessage.setPushContent(jSONObject.optString("content"));
            pushNotificationMessage.setPushData(jSONObject.optString("appData"));
            pushNotificationMessage.setPushFlag(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            PushNotificationMessage.PushSourceType pushSourceType = PushNotificationMessage.PushSourceType.FROM_ADMIN;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rc");
            if (jSONObjectOptJSONObject == null && (strOptString2 = jSONObject.optString("rc")) != null) {
                jSONObjectOptJSONObject = new JSONObject(strOptString2);
            }
            String str3 = "";
            if (jSONObjectOptJSONObject != null) {
                String strOptString4 = jSONObjectOptJSONObject.optString("tId");
                String strOptString5 = jSONObjectOptJSONObject.optString("sourceType");
                strOptString = jSONObjectOptJSONObject.optString("id");
                str2 = strOptString4;
                str3 = strOptString5;
            } else {
                str2 = "";
                strOptString = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                pushSourceType = PushNotificationMessage.PushSourceType.values()[Integer.parseInt(str3)];
            }
            pushNotificationMessage.setToId(str2);
            pushNotificationMessage.setSourceType(pushSourceType);
            pushNotificationMessage.setPushId(strOptString);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("ext") && jSONObjectOptJSONObject.getJSONObject("ext") != null) {
                pushNotificationMessage.setExtra(jSONObjectOptJSONObject.getJSONObject("ext").toString());
            }
            return pushNotificationMessage;
        } catch (JSONException e3) {
            RLog.e("PushUtils", e3.getMessage());
            return null;
        }
    }
}
