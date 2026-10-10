package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcym implements com.google.android.gms.ads.internal.zzg {
    private final /* synthetic */ zzdnv zzgqc;
    private final /* synthetic */ zzdog zzgqp;
    private final /* synthetic */ zzbcg zzgrt;
    private final /* synthetic */ zzcys zzgru;
    private final /* synthetic */ zzcyk zzgrv;

    zzcym(zzcyk zzcykVar, zzbcg zzbcgVar, zzdog zzdogVar, zzdnv zzdnvVar, zzcys zzcysVar) {
        this.zzgrv = zzcykVar;
        this.zzgrt = zzbcgVar;
        this.zzgqp = zzdogVar;
        this.zzgqc = zzdnvVar;
        this.zzgru = zzcysVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzh(View view) {
        this.zzgrt.set(this.zzgrv.zzgrs.zza(this.zzgqp, this.zzgqc, view, this.zzgru));
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkc() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkd() {
    }
}
