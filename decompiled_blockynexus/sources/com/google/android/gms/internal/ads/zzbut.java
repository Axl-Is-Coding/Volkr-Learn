package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbut implements zzeoy<zzbuo> {
    private final zzeph<Set<zzcab<zzbuv>>> zzfqq;

    private zzbut(zzeph<Set<zzcab<zzbuv>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbut zzh(zzeph<Set<zzcab<zzbuv>>> zzephVar) {
        return new zzbut(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbuo(this.zzfqq.get());
    }
}
