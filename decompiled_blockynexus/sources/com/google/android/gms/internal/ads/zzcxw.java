package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcxw extends zzcyc {
    private final zzbxy zzgqz;

    public zzcxw(zzbuc zzbucVar, zzbuu zzbuuVar, zzbvh zzbvhVar, zzbvr zzbvrVar, zzbyf zzbyfVar, zzbwa zzbwaVar, zzcau zzcauVar, zzbxy zzbxyVar, zzbuk zzbukVar) {
        super(zzbucVar, zzbuuVar, zzbvhVar, zzbvrVar, zzbyfVar, zzbwaVar, zzcauVar, zzbxyVar, zzbukVar);
        this.zzgqz = zzbxyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyc, com.google.android.gms.internal.ads.zzanh
    public final void onAdImpression() {
        this.zzgqz.zzajk();
    }
}
