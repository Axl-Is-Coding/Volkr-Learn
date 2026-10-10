package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbwi implements zzeoy<zzbwg> {
    private final zzeph<zzdnv> zzfno;
    private final zzeph<Set<zzcab<zzbwl>>> zzfqq;

    private zzbwi(zzeph<Set<zzcab<zzbwl>>> zzephVar, zzeph<zzdnv> zzephVar2) {
        this.zzfqq = zzephVar;
        this.zzfno = zzephVar2;
    }

    public static zzbwi zzu(zzeph<Set<zzcab<zzbwl>>> zzephVar, zzeph<zzdnv> zzephVar2) {
        return new zzbwi(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbwg(this.zzfqq.get(), this.zzfno.get());
    }
}
