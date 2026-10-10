package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzcr {
    private static UserManager zza;
    private static volatile boolean zzb = !zza();
    private static boolean zzc = false;

    private zzcr() {
    }

    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        r4 = true;
     */
    @android.annotation.TargetApi(24)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean zzb(android.content.Context r6) {
        /*
            r0 = 1
            r1 = 1
        L2:
            r2 = 2
            r3 = 0
            r4 = 0
            if (r1 > r2) goto L39
            android.os.UserManager r2 = com.google.android.gms.internal.measurement.zzcr.zza
            if (r2 != 0) goto L15
            java.lang.Class<android.os.UserManager> r2 = android.os.UserManager.class
            java.lang.Object r2 = r6.getSystemService(r2)
            android.os.UserManager r2 = (android.os.UserManager) r2
            com.google.android.gms.internal.measurement.zzcr.zza = r2
        L15:
            android.os.UserManager r2 = com.google.android.gms.internal.measurement.zzcr.zza
            if (r2 != 0) goto L1a
            return r0
        L1a:
            boolean r5 = r2.isUserUnlocked()     // Catch: java.lang.NullPointerException -> L2c
            if (r5 != 0) goto L2a
            android.os.UserHandle r5 = android.os.Process.myUserHandle()     // Catch: java.lang.NullPointerException -> L2c
            boolean r6 = r2.isUserRunning(r5)     // Catch: java.lang.NullPointerException -> L2c
            if (r6 != 0) goto L39
        L2a:
            r4 = 1
            goto L39
        L2c:
            r2 = move-exception
            java.lang.String r4 = "DirectBootUtils"
            java.lang.String r5 = "Failed to check if user is unlocked."
            android.util.Log.w(r4, r5, r2)
            com.google.android.gms.internal.measurement.zzcr.zza = r3
            int r1 = r1 + 1
            goto L2
        L39:
            if (r4 == 0) goto L3d
            com.google.android.gms.internal.measurement.zzcr.zza = r3
        L3d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcr.zzb(android.content.Context):boolean");
    }

    @TargetApi(24)
    private static boolean zzc(Context context) {
        if (zzb) {
            return true;
        }
        synchronized (zzcr.class) {
            if (zzb) {
                return true;
            }
            boolean zZzb = zzb(context);
            if (zZzb) {
                zzb = zZzb;
            }
            return zZzb;
        }
    }

    public static boolean zza(Context context) {
        return !zza() || zzc(context);
    }
}
