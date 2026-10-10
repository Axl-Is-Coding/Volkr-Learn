package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static boolean zzq;
    private static com.google.android.gms.iid.zzk zzr;
    private static com.google.android.gms.iid.zzk zzs;

    private final synchronized com.google.android.gms.iid.zzk zzd(Context context, String str) {
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (zzs == null) {
                zzs = new com.google.android.gms.iid.zzk(context, str);
            }
            return zzs;
        }
        if (zzr == null) {
            zzr = new com.google.android.gms.iid.zzk(context, str);
        }
        return zzr;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc A[Catch: SecurityException -> 0x00e8, TryCatch #0 {SecurityException -> 0x00e8, blocks: (B:32:0x00b4, B:34:0x00bc, B:37:0x00cc, B:39:0x00d7, B:41:0x00dd, B:43:0x00e3, B:35:0x00c1), top: B:50:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: SecurityException -> 0x00e8, TryCatch #0 {SecurityException -> 0x00e8, blocks: (B:32:0x00b4, B:34:0x00bc, B:37:0x00cc, B:39:0x00d7, B:41:0x00dd, B:43:0x00e3, B:35:0x00c1), top: B:50:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc A[Catch: SecurityException -> 0x00e8, TryCatch #0 {SecurityException -> 0x00e8, blocks: (B:32:0x00b4, B:34:0x00bc, B:37:0x00cc, B:39:0x00d7, B:41:0x00dd, B:43:0x00e3, B:35:0x00c1), top: B:50:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: SecurityException -> 0x00e8, TryCatch #0 {SecurityException -> 0x00e8, blocks: (B:32:0x00b4, B:34:0x00bc, B:37:0x00cc, B:39:0x00d7, B:41:0x00dd, B:43:0x00e3, B:35:0x00c1), top: B:50:0x00b4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzd(android.content.Context r6, android.content.Intent r7) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmReceiver.zzd(android.content.Context, android.content.Intent):void");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        if (z) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            zzd(context, intent.getAction()).zzd(intent, goAsync());
        } else {
            "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
            zzd(context, intent);
            if (isOrderedBroadcast() && getResultCode() == 0) {
                setResultCode(-1);
            }
        }
    }
}
