package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcjd implements zzeoy<zzcje> {
    private final zzeph<zzbvh> zzfch;
    private final zzeph<zzdnv> zzfno;

    public zzcjd(zzeph<zzbvh> zzephVar, zzeph<zzdnv> zzephVar2) {
        this.zzfch = zzephVar;
        this.zzfno = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcje(this.zzfch.get(), this.zzfno.get());
    }
}
