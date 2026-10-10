package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzckl implements zzeoy<zzckm> {
    private final zzeph<zzbgj> zzfqh;

    private zzckl(zzeph<zzbgj> zzephVar) {
        this.zzfqh = zzephVar;
    }

    public static zzckl zzaa(zzeph<zzbgj> zzephVar) {
        return new zzckl(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzckm(this.zzfqh.get());
    }
}
