package io.rong.imkit.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class NotificationUtil {
    private static final String CHANNEL_ID = "rc_notification_id";
    private static final String TAG = "NotificationUtil";

    public static void clearNotification(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    private static Notification createNotification(Context context, String str, String str2, PendingIntent pendingIntent, int i) {
        String string = context.getResources().getString(context.getResources().getIdentifier("rc_notification_ticker_text", "string", context.getPackageName()));
        int i2 = Build.VERSION.SDK_INT;
        Bitmap bitmap = null;
        if (i2 < 11) {
            try {
                Notification notification = new Notification(context.getApplicationInfo().icon, string, System.currentTimeMillis());
                Notification.class.getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, str2, pendingIntent);
                notification.flags = 48;
                notification.defaults = -1;
                return notification;
            } catch (Exception e2) {
                RLog.e(TAG, "createNotification", e2);
                return null;
            }
        }
        boolean z = i2 >= 21;
        int identifier = context.getResources().getIdentifier("notification_small_icon", "drawable", context.getPackageName());
        if (identifier <= 0 || !z) {
            identifier = context.getApplicationInfo().icon;
        }
        Drawable drawableLoadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
        try {
            if (Build.VERSION.SDK_INT < 26 || !(drawableLoadIcon instanceof AdaptiveIconDrawable)) {
                bitmap = ((BitmapDrawable) drawableLoadIcon).getBitmap();
            } else {
                bitmap = Bitmap.createBitmap(drawableLoadIcon.getIntrinsicWidth(), drawableLoadIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawableLoadIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawableLoadIcon.draw(canvas);
            }
        } catch (Exception e3) {
            RLog.e(TAG, "createNotification", e3);
        }
        Notification.Builder builder = new Notification.Builder(context);
        builder.setLargeIcon(bitmap);
        builder.setSmallIcon(identifier);
        builder.setTicker(string);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setOngoing(true);
        builder.setDefaults(i);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId(CHANNEL_ID);
        }
        return builder.getNotification();
    }

    public static int getRingerMode(Context context) {
        return ((AudioManager) context.getSystemService(LibStorageUtils.AUDIO)).getRingerMode();
    }

    public static void showNotification(Context context, String str, String str2, PendingIntent pendingIntent, int i, int i2) {
        Uri uri;
        Notification notificationCreateNotification = createNotification(context, str, str2, pendingIntent, i2);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, context.getResources().getString(context.getResources().getIdentifier("rc_notification_channel_name", "string", context.getPackageName())), 3);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-16711936);
            if (notificationCreateNotification != null && (uri = notificationCreateNotification.sound) != null) {
                notificationChannel.setSound(uri, null);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        if (notificationCreateNotification != null) {
            notificationManager.notify(i, notificationCreateNotification);
        }
    }

    public static void showNotification(Context context, String str, String str2, PendingIntent pendingIntent, int i) {
        showNotification(context, str, str2, pendingIntent, i, -1);
    }
}
