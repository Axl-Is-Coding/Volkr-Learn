package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpn implements zzeoy<zzcta<zzboq>> {
    private final zzeph<zzcxv<zzboq, zzdpa, zzcuu>> zzezl;
    private final zzeph<Boolean> zzfjp;
    private final zzeph<zzcwd> zzfjr;

    public zzbpn(zzeph<Boolean> zzephVar, zzeph<zzcwd> zzephVar2, zzeph<zzcxv<zzboq, zzdpa, zzcuu>> zzephVar3) {
        this.zzfjp = zzephVar;
        this.zzfjr = zzephVar2;
        this.zzezl = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        boolean zBooleanValue = this.zzfjp.get().booleanValue();
        zzcwd zzcwdVar = this.zzfjr.get();
        zzcxv<zzboq, zzdpa, zzcuu> zzcxvVar = this.zzezl.get();
        if (!zBooleanValue) {
            zzcwdVar = zzcxvVar;
        }
        zzepe.zza(zzcwdVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcwdVar;
    }
}
