package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcac implements zzeoy<zzbzx> {
    private final zzeph<Set<zzcab<zzbzy>>> zzfqq;

    private zzcac(zzeph<Set<zzcab<zzbzy>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzcac zzt(zzeph<Set<zzcab<zzbzy>>> zzephVar) {
        return new zzcac(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbzx(this.zzfqq.get());
    }
}
