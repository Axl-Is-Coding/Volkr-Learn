package io.rong.common;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.HeartbeatReceiver;

/* JADX INFO: loaded from: classes5.dex */
public class WakeLockUtils {
    private static final long DEF_HEARTBEAT_TIMER = 150000;
    private static final int HEARTBEAT_TIMER_MIN = 10000;
    private static final String TAG = "WakeLockUtils";
    private static volatile boolean cancelHeartbeat;
    private static long interval;

    public static void cancelHeartbeat(Context context) {
        FwLog.write(3, 1, FwLog.LogTag.L_PING_S.getTag(), "interval|enabled", Long.valueOf(interval), false);
        RLog.d(TAG, "cancelHeartbeat " + context.getPackageName());
        Intent intent = new Intent(context, (Class<?>) HeartbeatReceiver.class);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            alarmManager.cancel(broadcast);
        }
    }

    public static void cancelSDKHeartBeat(Context context) {
        RLog.d(TAG, "cancelSDKHeartBeat ");
        cancelHeartbeat = true;
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) HeartbeatReceiver.class), 2, 1);
    }

    public static void scheduleHeartbeat(Context context) {
        RLog.d(TAG, "startNextHeartbeat " + context.getPackageName() + ", cancelHeartbeat " + cancelHeartbeat);
        if (cancelHeartbeat) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) HeartbeatReceiver.class);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            RLog.e(TAG, "alarmManager is null");
            return;
        }
        Resources resources = context.getResources();
        if (interval <= 0) {
            try {
                interval = Long.parseLong(resources.getString(resources.getIdentifier("rc_heartbeat_timer", "string", context.getPackageName())));
            } catch (Exception unused) {
                interval = DEF_HEARTBEAT_TIMER;
                RLog.e(TAG, "Read config file exception. Use default heartbeat time value.");
            }
            if (interval < 10000) {
                interval = 10000L;
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() + interval;
        alarmManager.cancel(broadcast);
        FwLog.write(3, 1, FwLog.LogTag.L_PING_S.getTag(), "interval|enabled", Long.valueOf(interval), true);
        if (Build.VERSION.SDK_INT < 19) {
            alarmManager.set(2, jElapsedRealtime, broadcast);
        } else {
            alarmManager.setExact(2, jElapsedRealtime, broadcast);
        }
    }
}
