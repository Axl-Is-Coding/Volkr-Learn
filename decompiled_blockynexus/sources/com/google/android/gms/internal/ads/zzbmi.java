package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmi implements zzbui {
    private final zzdog zzfmw;
    private final zzdsr zzfmy;
    private final zzdnw zzfne;
    private final zzdst zzfnf;

    public zzbmi(zzdog zzdogVar, zzdst zzdstVar, zzdsr zzdsrVar) {
        this.zzfmw = zzdogVar;
        this.zzfnf = zzdstVar;
        this.zzfmy = zzdsrVar;
        this.zzfne = zzdogVar.zzhew.zzeou;
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(zzva zzvaVar) {
        this.zzfnf.zzj(this.zzfmy.zza(this.zzfmw, (zzdnv) null, this.zzfne.zzdkm));
    }
}
