package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccj implements zzeoy<zzcta<zzcbe>> {
    private final zzeph<zzdzb> zzfqk;
    private final zzeph<zzdsi> zzfqv;
    private final zzeph<zzcvi> zzfqw;
    private final zzeph<zzcxr> zzfqx;

    public zzccj(zzeph<zzdsi> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<zzcvi> zzephVar3, zzeph<zzcxr> zzephVar4) {
        this.zzfqv = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzfqw = zzephVar3;
        this.zzfqx = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcxv zzcxvVar = new zzcxv(this.zzfqv.get(), this.zzfqk.get(), this.zzfqx.get(), this.zzfqw.get());
        zzepe.zza(zzcxvVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcxvVar;
    }
}
