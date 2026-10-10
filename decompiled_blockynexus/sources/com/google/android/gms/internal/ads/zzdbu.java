package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbu implements zzeoy<zzdbv> {
    private final zzeph<zzdok> zzfqr;

    private zzdbu(zzeph<zzdok> zzephVar) {
        this.zzfqr = zzephVar;
    }

    public static zzdbu zzak(zzeph<zzdok> zzephVar) {
        return new zzdbu(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdbv(this.zzfqr.get());
    }
}
