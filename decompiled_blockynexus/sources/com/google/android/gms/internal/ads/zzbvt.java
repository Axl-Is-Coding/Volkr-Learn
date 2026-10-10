package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbvt implements zzeoy<zzbvr> {
    private final zzeph<Set<zzcab<zzbvs>>> zzfqq;

    private zzbvt(zzeph<Set<zzcab<zzbvs>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbvt zzl(zzeph<Set<zzcab<zzbvs>>> zzephVar) {
        return new zzbvt(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbvr(this.zzfqq.get());
    }
}
