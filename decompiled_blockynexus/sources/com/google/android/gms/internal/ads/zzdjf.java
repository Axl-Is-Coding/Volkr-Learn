package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdjf implements zzeoy<String> {
    private final zzdiy zzgzp;

    public zzdjf(zzdiy zzdiyVar) {
        this.zzgzp = zzdiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        String strZzasl = this.zzgzp.zzasl();
        zzepe.zza(strZzasl, "Cannot return null from a non-@Nullable @Provides method");
        return strZzasl;
    }
}
