package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbue implements zzeoy<zzbuc> {
    private final zzeph<Set<zzcab<zzux>>> zzfqq;

    private zzbue(zzeph<Set<zzcab<zzux>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbue zzg(zzeph<Set<zzcab<zzux>>> zzephVar) {
        return new zzbue(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbuc(this.zzfqq.get());
    }
}
