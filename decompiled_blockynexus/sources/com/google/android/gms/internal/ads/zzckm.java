package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzckm implements zzbuy {
    private final zzbgj zzdgy;

    zzckm(zzbgj zzbgjVar) {
        this.zzdgy = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcoh)).booleanValue() ? zzbgjVar : null;
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzca(Context context) {
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar != null) {
            zzbgjVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcb(Context context) {
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar != null) {
            zzbgjVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcc(Context context) {
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar != null) {
            zzbgjVar.destroy();
        }
    }
}
