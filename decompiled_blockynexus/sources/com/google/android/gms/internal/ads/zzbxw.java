package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbxw implements zzeoy<zzbxu> {
    private final zzeph<Set<zzcab<zzbxz>>> zzfqq;

    private zzbxw(zzeph<Set<zzcab<zzbxz>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzbxw zzp(zzeph<Set<zzcab<zzbxz>>> zzephVar) {
        return new zzbxw(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbxu(this.zzfqq.get());
    }
}
