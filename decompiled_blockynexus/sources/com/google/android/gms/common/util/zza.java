package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zza {
    private static long zzb;
    private static final IntentFilter zza = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static float zzc = Float.NaN;

    @TargetApi(20)
    public static int zza(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, zza);
        int i = ((intentRegisterReceiver == null ? 0 : intentRegisterReceiver.getIntExtra("plugged", 0)) & (PlatformVersion.isAtLeastJellyBeanMR1() ? 7 : 3)) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return (PlatformVersion.isAtLeastKitKatWatch() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 2 : 0) | i;
    }

    public static synchronized float zzb(Context context) {
        if (SystemClock.elapsedRealtime() - zzb < 60000 && !Float.isNaN(zzc)) {
            return zzc;
        }
        if (context.getApplicationContext().registerReceiver(null, zza) != null) {
            zzc = r6.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) / r6.getIntExtra("scale", -1);
        }
        zzb = SystemClock.elapsedRealtime();
        return zzc;
    }
}
