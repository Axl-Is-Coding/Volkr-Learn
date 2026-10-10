package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmf implements zzbuy {
    private final zzdpa zzfmu;

    public zzbmf(zzdpa zzdpaVar) {
        this.zzfmu = zzdpaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzca(Context context) {
        try {
            this.zzfmu.pause();
        } catch (zzdos e2) {
            zzbbq.zzd("Cannot invoke onPause for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcb(Context context) {
        try {
            this.zzfmu.resume();
            if (context != null) {
                this.zzfmu.onContextChanged(context);
            }
        } catch (zzdos e2) {
            zzbbq.zzd("Cannot invoke onResume for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcc(Context context) {
        try {
            this.zzfmu.destroy();
        } catch (zzdos e2) {
            zzbbq.zzd("Cannot invoke onDestroy for the mediation adapter.", e2);
        }
    }
}
