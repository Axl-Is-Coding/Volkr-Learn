package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrk implements zzeoy<zzbrh> {
    private final zzeph<zzbvh> zzfch;

    private zzbrk(zzeph<zzbvh> zzephVar) {
        this.zzfch = zzephVar;
    }

    public static zzbrk zze(zzeph<zzbvh> zzephVar) {
        return new zzbrk(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbrh(this.zzfch.get());
    }
}
