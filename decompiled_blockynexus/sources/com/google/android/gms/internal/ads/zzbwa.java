package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbwa extends zzbyr<com.google.android.gms.ads.internal.overlay.zzp> implements com.google.android.gms.ads.internal.overlay.zzp {
    public zzbwa(Set<zzcab<com.google.android.gms.ads.internal.overlay.zzp>> set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onPause() {
        zza(zzbwc.zzfur);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onResume() {
        zza(zzbwf.zzfur);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzum() {
        zza(zzbwd.zzfur);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzun() {
        zza(zzbwe.zzfur);
    }
}
