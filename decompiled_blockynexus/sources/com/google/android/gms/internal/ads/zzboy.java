package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzboy implements zzeoy<zzbvr> {
    private final zzbot zzfqp;
    private final zzeph<Set<zzcab<zzbvs>>> zzfqq;

    public zzboy(zzbot zzbotVar, zzeph<Set<zzcab<zzbvs>>> zzephVar) {
        this.zzfqp = zzbotVar;
        this.zzfqq = zzephVar;
    }

    public static zzbvr zza(zzbot zzbotVar, Set<zzcab<zzbvs>> set) {
        zzbvr zzbvrVarZza = zzbotVar.zza(set);
        zzepe.zza(zzbvrVarZza, "Cannot return null from a non-@Nullable @Provides method");
        return zzbvrVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfqp, this.zzfqq.get());
    }
}
