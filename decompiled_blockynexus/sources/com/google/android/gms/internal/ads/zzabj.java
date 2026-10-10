package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabj {
    public static boolean zza(zzabs zzabsVar, zzabq zzabqVar, String... strArr) {
        if (zzabsVar == null || zzabqVar == null || !zzabsVar.zzczm || zzabqVar == null) {
            return false;
        }
        return zzabsVar.zza(zzabqVar, com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime(), strArr);
    }

    public static zzabq zzb(zzabs zzabsVar) {
        if (zzabsVar == null) {
            return null;
        }
        return zzabsVar.zzex(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime());
    }
}
