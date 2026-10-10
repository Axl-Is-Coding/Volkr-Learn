package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcds implements zzeoy<zzcil> {
    private final zzcdl zzfyp;

    public zzcds(zzcdl zzcdlVar) {
        this.zzfyp = zzcdlVar;
    }

    public static zzcil zza(zzcdl zzcdlVar) {
        zzcil zzcilVarZzalt = zzcdlVar.zzalt();
        zzepe.zza(zzcilVarZzalt, "Cannot return null from a non-@Nullable @Provides method");
        return zzcilVarZzalt;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfyp);
    }
}
