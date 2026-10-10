package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayp extends zzbbq {
    public static void zza(String str, Throwable th) {
        if (zzxa()) {
            Log.v("Ads", str, th);
        }
    }

    public static void zzei(String str) {
        if (zzxa()) {
            Log.v("Ads", str);
        }
    }

    public static boolean zzxa() {
        return zzbbq.isLoggable(2) && zzacv.zzdbq.get().booleanValue();
    }
}
