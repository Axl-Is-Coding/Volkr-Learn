package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcje implements zzaia {
    private final zzbvh zzfsg;
    private final zzauv zzgfa;
    private final String zzgfb;
    private final String zzgfc;

    public zzcje(zzbvh zzbvhVar, zzdnv zzdnvVar) {
        this.zzfsg = zzbvhVar;
        this.zzgfa = zzdnvVar.zzdtc;
        this.zzgfb = zzdnvVar.zzdjz;
        this.zzgfc = zzdnvVar.zzdka;
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zza(zzauv zzauvVar) {
        String str;
        int i;
        zzauv zzauvVar2 = this.zzgfa;
        if (zzauvVar2 != null) {
            zzauvVar = zzauvVar2;
        }
        if (zzauvVar != null) {
            str = zzauvVar.type;
            i = zzauvVar.zzdvs;
        } else {
            str = "";
            i = 1;
        }
        this.zzfsg.zzb(new zzatu(str, i), this.zzgfb, this.zzgfc);
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zzta() {
        this.zzfsg.onRewardedVideoStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zztb() {
        this.zzfsg.onRewardedVideoCompleted();
    }
}
