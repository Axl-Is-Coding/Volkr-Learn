package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmz implements zzeoy<zzamk> {
    private final zzeph<zzamb> zzfot;

    private zzbmz(zzeph<zzamb> zzephVar) {
        this.zzfot = zzephVar;
    }

    public static zzbmz zzb(zzeph<zzamb> zzephVar) {
        return new zzbmz(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzamk zzamkVarZztp = this.zzfot.get().zztp();
        zzepe.zza(zzamkVarZztp, "Cannot return null from a non-@Nullable @Provides method");
        return zzamkVarZztp;
    }
}
