package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcah implements zzeoy<zzcaf> {
    private final zzeph<Set<zzcab<zzcak>>> zzfqq;

    private zzcah(zzeph<Set<zzcab<zzcak>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzcah zzu(zzeph<Set<zzcab<zzcak>>> zzephVar) {
        return new zzcah(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcaf(this.zzfqq.get());
    }
}
