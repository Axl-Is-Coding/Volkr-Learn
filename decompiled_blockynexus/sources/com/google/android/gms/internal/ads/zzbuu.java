package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbuu extends zzbyr<zzbuz> {
    private boolean zzfuu;

    public zzbuu(Set<zzcab<zzbuz>> set) {
        super(set);
        this.zzfuu = false;
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfuu) {
            zza(zzbux.zzfur);
            this.zzfuu = true;
        }
    }
}
