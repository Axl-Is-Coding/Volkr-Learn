package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzua;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbh implements zzeoy<zzua.zza.EnumC0120zza> {
    private final zzdbd zzgur;

    public zzdbh(zzdbd zzdbdVar) {
        this.zzgur = zzdbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzua.zza.EnumC0120zza enumC0120zzaZzari = this.zzgur.zzari();
        zzepe.zza(enumC0120zzaZzari, "Cannot return null from a non-@Nullable @Provides method");
        return enumC0120zzaZzari;
    }
}
