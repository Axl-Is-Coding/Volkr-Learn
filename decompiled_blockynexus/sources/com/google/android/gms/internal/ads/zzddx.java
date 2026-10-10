package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddx implements zzeoy<zzdnt> {
    private final zzeph<Clock> zzfok;

    public zzddx(zzeph<Clock> zzephVar) {
        this.zzfok = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdnt zzdntVar = new zzdnt(this.zzfok.get());
        zzepe.zza(zzdntVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdntVar;
    }
}
