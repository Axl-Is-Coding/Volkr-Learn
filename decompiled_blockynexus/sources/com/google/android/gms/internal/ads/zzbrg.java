package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrg implements zzeoy<String> {
    private final zzbre zzfsf;

    private zzbrg(zzbre zzbreVar) {
        this.zzfsf = zzbreVar;
    }

    public static zzbrg zzd(zzbre zzbreVar) {
        return new zzbrg(zzbreVar);
    }

    public static String zze(zzbre zzbreVar) {
        String strZzajf = zzbreVar.zzajf();
        zzepe.zza(strZzajf, "Cannot return null from a non-@Nullable @Provides method");
        return strZzajf;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zze(this.zzfsf);
    }
}
