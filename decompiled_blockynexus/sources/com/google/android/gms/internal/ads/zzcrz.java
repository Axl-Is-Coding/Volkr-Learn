package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcrz implements zzeoy<zzcsa> {
    private final zzeph<zzcsf> zzgma;

    private zzcrz(zzeph<zzcsf> zzephVar) {
        this.zzgma = zzephVar;
    }

    public static zzcrz zzag(zzeph<zzcsf> zzephVar) {
        return new zzcrz(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcsa(this.zzgma.get());
    }
}
