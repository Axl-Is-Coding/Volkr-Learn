package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public final class zzbbb {
    private static zzbbb zzedj;
    String zzedk;

    private zzbbb() {
    }

    public static zzbbb zzyl() {
        if (zzedj == null) {
            zzedj = new zzbbb();
        }
        return zzedj;
    }
}
