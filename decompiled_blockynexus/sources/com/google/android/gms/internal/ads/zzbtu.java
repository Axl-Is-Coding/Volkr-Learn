package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtu implements zzeoy<String> {
    private final zzeph<zzbsa> zzevm;
    private final zzbtp zzfuk;

    private zzbtu(zzbtp zzbtpVar, zzeph<zzbsa> zzephVar) {
        this.zzfuk = zzbtpVar;
        this.zzevm = zzephVar;
    }

    public static String zza(zzbtp zzbtpVar, zzbsa zzbsaVar) {
        String strZzwd = zzbsaVar.zzwd();
        zzepe.zza(strZzwd, "Cannot return null from a non-@Nullable @Provides method");
        return strZzwd;
    }

    public static zzbtu zzb(zzbtp zzbtpVar, zzeph<zzbsa> zzephVar) {
        return new zzbtu(zzbtpVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfuk, this.zzevm.get());
    }
}
