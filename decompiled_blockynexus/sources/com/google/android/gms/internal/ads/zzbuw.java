package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbuw implements zzeoy<zzbuu> {
    private final zzeph<Set<zzcab<zzbuz>>> zzfqq;

    private zzbuw(zzeph<Set<zzcab<zzbuz>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbuw zzi(zzeph<Set<zzcab<zzbuz>>> zzephVar) {
        return new zzbuw(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbuu(this.zzfqq.get());
    }
}
