package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcpd implements zzdya<zzatc, zzdog> {
    private final zzbwr zzgjr;

    public zzcpd(zzbwr zzbwrVar) {
        this.zzgjr = zzbwrVar;
    }

    protected abstract zzdzc<zzdog> zzb(zzatc zzatcVar) throws zzcof;

    @Override // com.google.android.gms.internal.ads.zzdya
    public final /* synthetic */ zzdzc<zzdog> zzf(zzatc zzatcVar) throws Exception {
        zzatc zzatcVar2 = zzatcVar;
        this.zzgjr.zzd(zzatcVar2);
        zzdzc<zzdog> zzdzcVarZzb = zzb(zzatcVar2);
        zzdyq.zza(zzdzcVarZzb, new zzcpg(this), zzbbz.zzeeu);
        return zzdzcVarZzb;
    }
}
