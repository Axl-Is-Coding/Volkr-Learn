package io.rong.push;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.rong.imlib.common.BuildVar;
import io.rong.imlib.statistics.Statistics;
import io.rong.push.common.PushCacheHelper;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import io.rong.push.notification.PushNotificationMessage;
import io.rong.push.notification.RongNotificationInterface;
import io.rong.push.platform.IPush;
import io.rong.push.pushconfig.PushConfig;
import io.rong.push.rongpush.PushReceiver;
import io.rong.push.rongpush.PushService;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class RongPushClient {
    private static final String TAG = "RongPushClient";
    private static String miAppId;
    private static String miAppKey;
    private static String mzAppId;
    private static String mzAppKey;
    private static PushConfig pushConfig;
    private static final ArrayList<PushType> registeredType = new ArrayList<>();

    public enum ConversationType {
        NONE(0, "none"),
        PRIVATE(1, "private"),
        DISCUSSION(2, "discussion"),
        GROUP(3, "group"),
        CHATROOM(4, "chatroom"),
        CUSTOMER_SERVICE(5, "customer_service"),
        SYSTEM(6, "system"),
        APP_PUBLIC_SERVICE(7, "app_public_service"),
        PUBLIC_SERVICE(8, "public_service"),
        PUSH_SERVICE(9, "push_service"),
        ENCRYPTED(11, "encrypted");

        private String name;
        private int value;

        ConversationType(int i, String str) {
            this.value = 1;
            this.name = "";
            this.value = i;
            this.name = str;
        }

        public static ConversationType setValue(int i) {
            for (ConversationType conversationType : values()) {
                if (i == conversationType.getValue()) {
                    return conversationType;
                }
            }
            return PRIVATE;
        }

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void cancelPushHeartBeat(Context context) {
        Intent intent = new Intent(context, (Class<?>) PushService.class);
        intent.setAction(PushConst.ACTION_CANCEL_PUSH_HEARTBEAT);
        PushService.enqueueWork(context, intent);
    }

    @Deprecated
    public static void checkManifest(Context context) {
    }

    public static void clearAllNotifications(Context context) {
        RLog.i(TAG, "clearAllNotifications");
        if (PushCacheHelper.getInstance().getConfigPushType(context).equals(PushType.XIAOMI)) {
            MiPushClient.clearNotification(context);
        }
        RongNotificationInterface.removeAllNotification(context);
    }

    public static void clearAllPushNotifications(Context context) {
        RLog.i(TAG, "clearAllPushNotifications");
        if (PushCacheHelper.getInstance().getConfigPushType(context).equals(PushType.XIAOMI)) {
            MiPushClient.clearNotification(context);
        }
        RongNotificationInterface.removeAllPushNotification(context);
    }

    public static void clearAllPushServiceNotifications(Context context) {
        if (PushCacheHelper.getInstance().getConfigPushType(context).equals(PushType.XIAOMI)) {
            MiPushClient.clearNotification(context);
        }
        RongNotificationInterface.removeAllPushServiceNotification(context);
    }

    public static void clearNotificationById(Context context, int i) {
        if (PushCacheHelper.getInstance().getConfigPushType(context).equals(PushType.XIAOMI)) {
            MiPushClient.clearNotification(context, i);
        }
        RongNotificationInterface.removeNotification(context, i);
    }

    public static PushType getCurrentPushType(Context context) {
        return PushCacheHelper.getInstance().isConfigDone(context) ? PushCacheHelper.getInstance().getConfigPushType(context) : PushType.UNKNOWN;
    }

    public static void init(Context context, String str) {
        init(context, str, "");
    }

    public static void recordHWNotificationEvent(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("options");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            if (jSONObject.has("rc")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("rc");
                String strOptString = jSONObject2.optString("id");
                if (TextUtils.isEmpty(strOptString)) {
                    RLog.d(TAG, "pushId is empty,recordNotificationEvent is failure");
                    return;
                }
                String strOptString2 = jSONObject2.optString("objectName");
                String strOptString3 = jSONObject2.optString("tId");
                String strOptString4 = jSONObject2.optString("sourceType");
                PushNotificationMessage.PushSourceType pushSourceType = PushNotificationMessage.PushSourceType.FROM_ADMIN;
                if (!TextUtils.isEmpty(strOptString4)) {
                    pushSourceType = PushNotificationMessage.PushSourceType.values()[Integer.parseInt(strOptString4)];
                }
                recordNotificationEvent(strOptString, strOptString3, strOptString2, pushSourceType);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public static void recordNotificationEvent(String str) {
        HashMap map = new HashMap();
        if (str == null || str.equals("")) {
            RLog.e(TAG, "pushId can't be null!");
        } else {
            if (!Statistics.sharedInstance().isInitialized()) {
                RLog.e(TAG, "Statistics should be initialized firstly!");
                return;
            }
            RLog.i(TAG, "recordNotificationEvent");
            map.put("id", str);
            Statistics.sharedInstance().recordEvent("pushEvent", map);
        }
    }

    public static void redirected(Context context) {
        if (TextUtils.isEmpty(PushCacheHelper.getInstance().getConfigPushType(context).getName())) {
            Intent intent = new Intent(context, (Class<?>) PushService.class);
            intent.setAction(PushConst.ACTION_REDIRECT);
            PushService.enqueueWork(context, intent);
        }
    }

    @Deprecated
    public static void registerFCM(Context context) {
        registeredType.add(PushType.GOOGLE_FCM);
    }

    @Deprecated
    public static void registerGCM(Context context) {
        registeredType.add(PushType.GOOGLE_GCM);
    }

    @Deprecated
    public static void registerHWPush(Context context) {
        registeredType.add(PushType.HUAWEI);
    }

    @Deprecated
    public static void registerMZPush(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Failed registerMZPush. appKey or appId can't be empty.");
        }
        registeredType.add(PushType.MEIZU);
        mzAppId = str;
        mzAppKey = str2;
    }

    @Deprecated
    public static void registerMiPush(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Failed registerMiPush. miAppId or miAppKey can't be empty.");
        }
        miAppId = str;
        miAppKey = str2;
        registeredType.add(PushType.XIAOMI);
    }

    public static void resolveHMSCoreUpdate(Activity activity) throws IllegalStateException {
        if (activity == null) {
            throw new IllegalStateException("resolve HWPush Error activity is null !");
        }
        PushType serverPushType = PushManager.getInstance().getServerPushType();
        if (PushCacheHelper.getInstance().isConfigDone(activity) || serverPushType == null || !serverPushType.getName().equals(PushType.HUAWEI.getName())) {
            RLog.i(TAG, "current pushType is " + serverPushType);
            return;
        }
        IPush registeredPush = PushManager.getInstance().getRegisteredPush(PushType.HUAWEI.getName());
        if (registeredPush != null) {
            registeredPush.register(activity, PushManager.getInstance().getPushConfig());
        } else {
            RLog.e(TAG, "no register HWPush");
        }
    }

    @Deprecated
    public static void resolveHWPushError(Activity activity, long j) throws IllegalStateException {
        if (activity == null) {
            throw new IllegalStateException("resolve HWPush Error activity is null !");
        }
    }

    public static void sendNotification(Context context, PushNotificationMessage pushNotificationMessage) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            RLog.e(TAG, "package name can't empty!");
            return;
        }
        if (pushNotificationMessage == null) {
            RLog.e(TAG, "notificationMessage  can't be  null!");
            return;
        }
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED);
        intent.setPackage(packageName);
        intent.putExtra(PushConst.PUSH_TYPE, PushType.RONG.getName());
        intent.putExtra("message", pushNotificationMessage);
        if (Build.VERSION.SDK_INT >= 12) {
            intent.setFlags(32);
        }
        context.sendBroadcast(intent);
    }

    public static void sendPushPing(Context context) {
        Intent intent = new Intent(context, (Class<?>) PushService.class);
        intent.setAction(PushConst.ACTION_CUSTOM_PUSH_HEARTBEAT);
        PushService.enqueueWork(context, intent);
    }

    public static void setNotifiationSound(Uri uri) {
        RongNotificationInterface.setNotificationSound(uri);
    }

    public static void setPushConfig(PushConfig pushConfig2) {
        pushConfig = pushConfig2;
    }

    @Deprecated
    public static void stopRongPush(Context context) {
        Intent intent = new Intent(context, (Class<?>) PushService.class);
        intent.setAction(PushConst.ACTION_STOP_PUSH);
        PushService.enqueueWork(context, intent);
    }

    public static void stopService(Context context) {
        try {
            if (!PushCacheHelper.getInstance().getConfigPushType(context).equals(PushType.HUAWEI) && PushCacheHelper.getInstance().getConfigPushType(context).equals(PushType.XIAOMI)) {
                MiPushClient.unregisterPush(context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, "stopService throw exception: " + e2.getMessage());
        }
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushReceiver.class), 2, 1);
        Intent intent = new Intent(context, (Class<?>) PushService.class);
        intent.setAction(PushConst.ACTION_UNINIT_PUSH);
        PushService.enqueueWork(context, intent);
    }

    public static void updatePushContentShowStatus(Context context, boolean z) {
        if (PushCacheHelper.getInstance().getPushContentShowStatus(context) ^ z) {
            PushCacheHelper.getInstance().setPushContentShowStatus(context, z);
        }
    }

    public static void init(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new ExceptionInInitializerError("appKey can't be empty!");
        }
        PushConfig pushConfig2 = pushConfig;
        if (pushConfig2 == null) {
            boolean zContains = registeredType.contains(PushType.HUAWEI);
            pushConfig = new PushConfig.Builder().enableHWPush(zContains).enableMiPush(miAppId, miAppKey).enableMeiZuPush(mzAppId, mzAppKey).enableFCM(registeredType.contains(PushType.GOOGLE_FCM)).enableGCM(registeredType.contains(PushType.GOOGLE_GCM)).setAppKey(str).setPushNaviAddress(str2).build();
        } else {
            pushConfig2.setPushNaviAddress(str2);
            pushConfig.setAppKey(str);
        }
        PushManager.getInstance().init(context, pushConfig);
    }

    public static void recordNotificationEvent(PushNotificationMessage pushNotificationMessage) {
        recordNotificationEvent(pushNotificationMessage.getPushId(), pushNotificationMessage.getToId(), pushNotificationMessage.getObjectName(), pushNotificationMessage.getSourceType());
    }

    private static void recordNotificationEvent(String str, String str2, String str3, PushNotificationMessage.PushSourceType pushSourceType) {
        HashMap map = new HashMap();
        if (!Statistics.sharedInstance().isInitialized()) {
            RLog.e(TAG, "Statistics should be initialized firstly!");
            return;
        }
        RLog.i(TAG, "recordNotificationEvent");
        map.put("id", str);
        map.put("osName", "Android");
        map.put("osVersion", String.format("%s|%s", Build.MANUFACTURER, Build.MODEL));
        map.put("sdkVersion", BuildVar.SDK_VERSION);
        if (TextUtils.isEmpty(str3)) {
            str3 = "unKnow";
        }
        map.put("objectName", str3);
        if (TextUtils.isEmpty(str2)) {
            str2 = "push_targetId";
        }
        map.put("userId", str2);
        map.put("sourceType", Integer.toString(pushSourceType.ordinal()));
        Statistics.sharedInstance().recordEvent("pushEvent", map);
    }

    public static void sendNotification(Context context, PushNotificationMessage pushNotificationMessage, int i) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            RLog.e(TAG, "package name can't empty!");
            return;
        }
        if (pushNotificationMessage == null) {
            RLog.e(TAG, "notificationMessage  can't be  null!");
            return;
        }
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_ARRIVED);
        intent.setPackage(packageName);
        intent.putExtra(PushConst.PUSH_TYPE, PushType.RONG.getName());
        intent.putExtra("message", pushNotificationMessage);
        intent.putExtra("left", i);
        if (Build.VERSION.SDK_INT >= 12) {
            intent.setFlags(32);
        }
        context.sendBroadcast(intent);
    }
}
