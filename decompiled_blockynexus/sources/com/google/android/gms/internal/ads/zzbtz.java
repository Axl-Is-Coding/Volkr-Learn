package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtz implements zzeoy<zzbtp.zza> {
    private final zzbtp zzfuk;

    private zzbtz(zzbtp zzbtpVar) {
        this.zzfuk = zzbtpVar;
    }

    public static zzbtz zzo(zzbtp zzbtpVar) {
        return new zzbtz(zzbtpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbtp.zza zzaVarZzajq = this.zzfuk.zzajq();
        zzepe.zza(zzaVarZzajq, "Cannot return null from a non-@Nullable @Provides method");
        return zzaVarZzajq;
    }
}
