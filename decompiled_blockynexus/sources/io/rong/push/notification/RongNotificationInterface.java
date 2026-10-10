package io.rong.push.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import io.rong.imlib.common.DeviceUtils;
import io.rong.push.common.PushCacheHelper;
import io.rong.push.common.PushConst;
import io.rong.push.common.RLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RongNotificationInterface {
    private static final int NEGLECT_TIME = 3000;
    private static final int NEW_NOTIFICATION_LEVEL = 11;
    private static final int PUSH_REQUEST_CODE = 200;
    private static final String TAG = "RongNotificationInterface";
    private static long lastNotificationTimestamp;
    private static Uri mSound;
    private static HashMap<String, List<PushNotificationMessage>> messageCache = new HashMap<>();
    private static int NOTIFICATION_ID = 1000;
    private static int PUSH_SERVICE_NOTIFICATION_ID = 2000;
    private static int VOIP_NOTIFICATION_ID = 3000;
    private static boolean recallUpdate = false;

    public enum SoundType {
        DEFAULT(0),
        SILENT(1),
        VOIP(2);

        int value;

        SoundType(int i) {
            this.value = i;
        }
    }

    public static Notification createNotification(Context context, String str, PendingIntent pendingIntent, String str2, SoundType soundType, boolean z) {
        Uri defaultUri;
        int i;
        Bitmap bitmap;
        String string;
        String string2 = context.getResources().getString(context.getResources().getIdentifier("rc_notification_ticker_text", "string", context.getPackageName()));
        String notificationContent = TextUtils.isEmpty(str2) ? getNotificationContent(context) : str2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 11) {
            try {
                Notification notification = new Notification(context.getApplicationInfo().icon, string2, System.currentTimeMillis());
                Notification.class.getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, notificationContent, pendingIntent);
                notification.flags = 16;
                notification.defaults = -1;
                return notification;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        boolean z2 = i2 >= 21;
        int identifier = context.getResources().getIdentifier("notification_small_icon", "drawable", context.getPackageName());
        if (identifier <= 0 || !z2) {
            identifier = context.getApplicationInfo().icon;
        }
        if (soundType.equals(SoundType.SILENT)) {
            defaultUri = null;
            i = 4;
        } else if (soundType.equals(SoundType.VOIP)) {
            defaultUri = RingtoneManager.getDefaultUri(1);
            i = 6;
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
            i = 1;
        }
        Drawable drawableLoadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
        try {
            if (Build.VERSION.SDK_INT < 26 || !(drawableLoadIcon instanceof AdaptiveIconDrawable)) {
                bitmap = ((BitmapDrawable) drawableLoadIcon).getBitmap();
            } else {
                bitmap = Bitmap.createBitmap(drawableLoadIcon.getIntrinsicWidth(), drawableLoadIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(bitmap);
                    drawableLoadIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawableLoadIcon.draw(canvas);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                }
            }
        } catch (Exception e4) {
            e = e4;
            bitmap = null;
        }
        Notification.Builder builder = new Notification.Builder(context);
        builder.setLargeIcon(bitmap);
        if (!soundType.equals(SoundType.SILENT)) {
            builder.setVibrate(new long[]{0, 200, 250, 200});
        }
        builder.setSmallIcon(identifier);
        builder.setTicker(string2);
        if (PushCacheHelper.getInstance().getPushContentShowStatus(context) || z) {
            builder.setContentTitle(str);
            builder.setContentText(notificationContent);
        } else {
            PackageManager packageManager = context.getPackageManager();
            try {
                string = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
            } catch (PackageManager.NameNotFoundException unused) {
                string = "";
            }
            builder.setContentTitle(string);
            builder.setContentText(string2);
        }
        builder.setContentIntent(pendingIntent);
        builder.setLights(-16711936, 3000, 3000);
        builder.setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("rc_notification_id");
        }
        Uri uri = mSound;
        if (uri == null || TextUtils.isEmpty(uri.toString())) {
            builder.setSound(defaultUri);
            builder.setDefaults(i);
        } else {
            builder.setSound(mSound);
        }
        Notification notificationBuild = builder.build();
        notificationBuild.flags = 1;
        return notificationBuild;
    }

    private static PendingIntent createPendingIntent(Context context, PushNotificationMessage pushNotificationMessage, int i, boolean z) {
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_CLICKED);
        intent.putExtra("message", pushNotificationMessage);
        intent.putExtra(PushConst.IS_MULTI, z);
        intent.setPackage(context.getPackageName());
        return PendingIntent.getBroadcast(context, i, intent, 134217728);
    }

    private static String getChannelId(PushNotificationMessage pushNotificationMessage) {
        String lowerCase = DeviceUtils.getDeviceManufacturer().toLowerCase();
        if (Build.VERSION.SDK_INT >= 26) {
            if (lowerCase.contains("Xiaomi".toLowerCase())) {
                return pushNotificationMessage.getChannelIdMi();
            }
            if (lowerCase.contains("HUAWEI".toLowerCase())) {
                return pushNotificationMessage.getChannelIdHW();
            }
            if (lowerCase.contains("oppo".toLowerCase())) {
                return pushNotificationMessage.getChannelIdOPPO();
            }
        }
        return null;
    }

    private static String getNotificationContent(Context context) {
        String string = context.getResources().getString(context.getResources().getIdentifier("rc_notification_new_msg", "string", context.getPackageName()));
        String string2 = context.getResources().getString(context.getResources().getIdentifier("rc_notification_new_plural_msg", "string", context.getPackageName()));
        if (messageCache.size() == 1) {
            List<PushNotificationMessage> next = messageCache.values().iterator().next();
            PushNotificationMessage pushNotificationMessage = next.get(0);
            return next.size() == 1 ? pushNotificationMessage.getPushContent() : next.get(next.size() - 1).getObjectName().equals("RC:RcNtf") ? next.get(next.size() - 1).getPushContent() : String.format(string, pushNotificationMessage.getTargetUserName(), Integer.valueOf(next.size()));
        }
        Iterator<List<PushNotificationMessage>> it = messageCache.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return String.format(string2, Integer.valueOf(messageCache.size()), Integer.valueOf(size));
    }

    private static String getNotificationTitle(Context context) {
        return messageCache.size() == 1 ? messageCache.values().iterator().next().get(0).getTargetUserName() : (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
    }

    public static void removeAllNotification(Context context) {
        messageCache.clear();
        try {
            ((NotificationManager) context.getSystemService("notification")).cancelAll();
        } catch (Exception e2) {
            RLog.e(TAG, "removeAllNotification" + e2.getMessage());
        }
        NOTIFICATION_ID = 1000;
    }

    public static void removeAllPushNotification(Context context) {
        messageCache.clear();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.cancel(NOTIFICATION_ID);
        notificationManager.cancel(VOIP_NOTIFICATION_ID);
    }

    public static void removeAllPushServiceNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        for (int i = PUSH_SERVICE_NOTIFICATION_ID; i >= 1000; i--) {
            notificationManager.cancel(i);
        }
        PUSH_SERVICE_NOTIFICATION_ID = 2000;
    }

    public static void removeNotification(Context context, int i) {
        if (i < 0) {
            return;
        }
        if (i >= NOTIFICATION_ID && i < PUSH_SERVICE_NOTIFICATION_ID) {
            messageCache.clear();
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    public static void sendNotification(Context context, PushNotificationMessage pushNotificationMessage) {
        sendNotification(context, pushNotificationMessage, 0);
    }

    public static void setNotificationSound(Uri uri) {
        mSound = uri;
    }

    private static PendingIntent updateRecallPendingIntent(Context context, int i, boolean z) {
        PushNotificationMessage pushNotificationMessage = messageCache.values().iterator().next().get(0);
        Intent intent = new Intent();
        intent.setAction(PushConst.ACTION_NOTIFICATION_MESSAGE_CLICKED);
        intent.putExtra("message", pushNotificationMessage);
        intent.putExtra(PushConst.IS_MULTI, z);
        intent.setPackage(context.getPackageName());
        return PendingIntent.getBroadcast(context, i, intent, 134217728);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:49|(1:(2:51|(2:142|62)(3:131|57|61))(2:139|63))|64|(2:66|(1:68)(2:69|(1:71)))|72|78|(1:80)|81|(7:86|(1:88)|133|90|94|(1:96)|97)(1:85)|89|133|90|94|(0)|97) */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0210, code lost:
    
        io.rong.push.common.RLog.d(io.rong.push.notification.RongNotificationInterface.TAG, "parse notificationId exception:" + r0.toString());
        r0 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void sendNotification(android.content.Context r17, io.rong.push.notification.PushNotificationMessage r18, int r19) {
        /*
            Method dump skipped, instruction units count: 853
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.push.notification.RongNotificationInterface.sendNotification(android.content.Context, io.rong.push.notification.PushNotificationMessage, int):void");
    }

    public static Notification createNotification(Context context, String str, PendingIntent pendingIntent, String str2, SoundType soundType, String str3) {
        Uri defaultUri;
        int i;
        Bitmap bitmap;
        String string = context.getResources().getString(context.getResources().getIdentifier("rc_notification_ticker_text", "string", context.getPackageName()));
        String notificationContent = TextUtils.isEmpty(str2) ? getNotificationContent(context) : str2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 11) {
            try {
                Notification notification = new Notification(context.getApplicationInfo().icon, string, System.currentTimeMillis());
                Notification.class.getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, notificationContent, pendingIntent);
                notification.flags = 16;
                notification.defaults = -1;
                return notification;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        boolean z = i2 >= 21;
        int identifier = context.getResources().getIdentifier("notification_small_icon", "drawable", context.getPackageName());
        if (identifier <= 0 || !z) {
            identifier = context.getApplicationInfo().icon;
        }
        if (soundType.equals(SoundType.SILENT)) {
            defaultUri = null;
            i = 4;
        } else if (soundType.equals(SoundType.VOIP)) {
            defaultUri = RingtoneManager.getDefaultUri(1);
            i = 6;
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
            i = 1;
        }
        Drawable drawableLoadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
        try {
            if (Build.VERSION.SDK_INT >= 26 && (drawableLoadIcon instanceof AdaptiveIconDrawable)) {
                bitmap = Bitmap.createBitmap(drawableLoadIcon.getIntrinsicWidth(), drawableLoadIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(bitmap);
                    drawableLoadIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawableLoadIcon.draw(canvas);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                }
            } else {
                bitmap = ((BitmapDrawable) drawableLoadIcon).getBitmap();
            }
        } catch (Exception e4) {
            e = e4;
            bitmap = null;
        }
        Notification.Builder builder = new Notification.Builder(context);
        builder.setLargeIcon(bitmap);
        if (!soundType.equals(SoundType.SILENT)) {
            builder.setVibrate(new long[]{0, 200, 250, 200});
        }
        builder.setSmallIcon(identifier);
        builder.setTicker(string);
        builder.setContentTitle(str);
        builder.setContentText(notificationContent);
        builder.setContentIntent(pendingIntent);
        builder.setLights(-16711936, 3000, 3000);
        builder.setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= 26) {
            if (!TextUtils.isEmpty(str3)) {
                builder.setChannelId(str3);
            } else {
                builder.setChannelId("rc_notification_id");
            }
        }
        Uri uri = mSound;
        if (uri != null && !TextUtils.isEmpty(uri.toString())) {
            builder.setSound(mSound);
        } else {
            builder.setSound(defaultUri);
            builder.setDefaults(i);
        }
        Notification notificationBuild = builder.build();
        notificationBuild.flags = 1;
        return notificationBuild;
    }
}
