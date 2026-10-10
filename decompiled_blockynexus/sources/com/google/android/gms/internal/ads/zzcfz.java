package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfz implements zzeoy<zzcfu> {
    private final zzeph<zzcil> zzffj;
    private final zzeph<zzcjt> zzgbz;

    public zzcfz(zzeph<zzcjt> zzephVar, zzeph<zzcil> zzephVar2) {
        this.zzgbz = zzephVar;
        this.zzffj = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcfu(this.zzgbz.get(), this.zzffj.get());
    }
}
