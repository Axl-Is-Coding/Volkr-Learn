package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbvm implements zzeoy<zzbvh> {
    private final zzeph<Set<zzcab<zzbuh>>> zzfqq;

    private zzbvm(zzeph<Set<zzcab<zzbuh>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbvm zzk(zzeph<Set<zzcab<zzbuh>>> zzephVar) {
        return new zzbvm(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbvh(this.zzfqq.get());
    }
}
