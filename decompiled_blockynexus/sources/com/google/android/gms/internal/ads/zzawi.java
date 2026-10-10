package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawi {
    public static boolean isEnabled() {
        return zzadc.zzdcj.get().booleanValue();
    }

    public static void zzef(String str) {
        if (zzadc.zzdcj.get().booleanValue()) {
            zzbbq.zzef(str);
        }
    }
}
