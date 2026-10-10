package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyd implements zzeoy<zzbxy> {
    private final zzeph<Set<zzcab<zzbyc>>> zzfqq;

    private zzbyd(zzeph<Set<zzcab<zzbyc>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbyd zzq(zzeph<Set<zzcab<zzbyc>>> zzephVar) {
        return new zzbyd(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbxy(this.zzfqq.get());
    }
}
