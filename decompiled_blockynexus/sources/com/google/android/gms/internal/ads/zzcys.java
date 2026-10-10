package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcys implements com.google.android.gms.ads.internal.zzg {
    private com.google.android.gms.ads.internal.zzg zzgrz;

    public final synchronized void zza(com.google.android.gms.ads.internal.zzg zzgVar) {
        this.zzgrz = zzgVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        if (this.zzgrz != null) {
            this.zzgrz.zzh(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzkc() {
        if (this.zzgrz != null) {
            this.zzgrz.zzkc();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzkd() {
        if (this.zzgrz != null) {
            this.zzgrz.zzkd();
        }
    }
}
