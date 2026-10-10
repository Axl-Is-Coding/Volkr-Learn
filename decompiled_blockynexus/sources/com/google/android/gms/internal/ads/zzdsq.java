package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdsq implements zzeoy<zzdsh> {
    private final zzeph<Set<zzcab<zzdso>>> zzfqq;

    private zzdsq(zzeph<Set<zzcab<zzdso>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzdsq zzar(zzeph<Set<zzcab<zzdso>>> zzephVar) {
        return new zzdsq(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdsh(this.zzfqq.get());
    }
}
