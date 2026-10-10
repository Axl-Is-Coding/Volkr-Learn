package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbyp implements zzeoy<zzbyg> {
    private final zzeph<Set<zzcab<zzbyo>>> zzfqq;

    private zzbyp(zzeph<Set<zzcab<zzbyo>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbyp zzs(zzeph<Set<zzcab<zzbyo>>> zzephVar) {
        return new zzbyp(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbyg(this.zzfqq.get());
    }
}
