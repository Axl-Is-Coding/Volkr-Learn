package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdox {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        zzbbq.zzfd(sb.toString());
        zzayp.zza(str, th);
        if (i == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzkv().zzb(th, str);
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            zzbbq.zzfd("This request is sent from a test device.");
            return;
        }
        zzwm.zzpt();
        String strZzbn = zzbbg.zzbn(context);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzbn).length() + 101);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(strZzbn);
        sb.append("\") to get test ads on this device.");
        zzbbq.zzfd(sb.toString());
    }
}
