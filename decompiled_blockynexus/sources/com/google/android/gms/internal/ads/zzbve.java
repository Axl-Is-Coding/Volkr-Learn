package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbve implements zzeoy<zzbvb> {
    private final zzeph<Set<zzcab<zzbuy>>> zzfqq;

    private zzbve(zzeph<Set<zzcab<zzbuy>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbve zzj(zzeph<Set<zzcab<zzbuy>>> zzephVar) {
        return new zzbve(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbvb(this.zzfqq.get());
    }
}
