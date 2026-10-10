package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxt extends zzcxa {
    private final zzbxy zzgqz;

    public zzcxt(zzbuc zzbucVar, zzbuu zzbuuVar, zzbvh zzbvhVar, zzbvr zzbvrVar, zzbuk zzbukVar, zzbyf zzbyfVar, zzcau zzcauVar, zzbwa zzbwaVar, zzcal zzcalVar, zzbxy zzbxyVar) {
        super(zzbucVar, zzbuuVar, zzbvhVar, zzbvrVar, zzbukVar, zzbyfVar, zzcauVar, zzbwaVar, zzcalVar, zzbxyVar);
        this.zzgqz = zzbxyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyc, com.google.android.gms.internal.ads.zzanh
    public final void onAdImpression() {
        this.zzgqz.zzajk();
    }
}
