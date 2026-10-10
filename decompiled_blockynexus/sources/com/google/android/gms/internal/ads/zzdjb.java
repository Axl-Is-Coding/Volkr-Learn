package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdjb implements zzeoy<String> {
    private final zzdiy zzgzp;

    public zzdjb(zzdiy zzdiyVar) {
        this.zzgzp = zzdiyVar;
    }

    public static String zzc(zzdiy zzdiyVar) {
        String strZzasf = zzdiyVar.zzasf();
        zzepe.zza(strZzasf, "Cannot return null from a non-@Nullable @Provides method");
        return strZzasf;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzc(this.zzgzp);
    }
}
