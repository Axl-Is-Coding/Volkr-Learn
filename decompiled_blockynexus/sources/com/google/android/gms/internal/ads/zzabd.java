package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabd {
    public static boolean zzct(String str) {
        return zzf((String) zzwm.zzpx().zzd(zzabb.zzcur), str);
    }

    private static boolean zzf(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
