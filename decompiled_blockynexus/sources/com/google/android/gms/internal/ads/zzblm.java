package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblm implements zzeoy<zzbbu> {
    private final zzeph<String> zzfml;

    public zzblm(zzeph<String> zzephVar) {
        this.zzfml = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbbu zzbbuVar = new zzbbu(this.zzfml.get());
        zzepe.zza(zzbbuVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbbuVar;
    }
}
