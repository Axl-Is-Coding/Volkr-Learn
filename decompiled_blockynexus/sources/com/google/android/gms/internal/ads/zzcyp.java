package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyp implements zzeoy<zzcyn> {
    private final zzcyn zzgry;

    private zzcyp(zzcyn zzcynVar) {
        this.zzgry = zzcynVar;
    }

    public static zzcyp zzc(zzcyn zzcynVar) {
        return new zzcyp(zzcynVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcyn zzcynVar = this.zzgry;
        if (zzcynVar == null) {
            throw null;
        }
        zzepe.zza(zzcynVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcynVar;
    }
}
