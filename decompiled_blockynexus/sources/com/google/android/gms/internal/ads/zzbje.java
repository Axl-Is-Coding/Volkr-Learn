package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbje implements zzeoy<zzctb<zzdpa, zzcuu>> {
    private final zzbja zzesn;
    private final zzeph<zzcku> zzeso;

    public zzbje(zzbja zzbjaVar, zzeph<zzcku> zzephVar) {
        this.zzesn = zzbjaVar;
        this.zzeso = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcvm zzcvmVar = new zzcvm(this.zzeso.get());
        zzepe.zza(zzcvmVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcvmVar;
    }
}
