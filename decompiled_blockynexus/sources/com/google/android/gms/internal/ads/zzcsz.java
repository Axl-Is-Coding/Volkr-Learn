package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsz<DelegateT, AdapterT> implements zzcta<AdapterT> {

    @VisibleForTesting
    private final zzcta<DelegateT> zzgnq;
    private final zzdvu<DelegateT, AdapterT> zzgnr;

    public zzcsz(zzcta<DelegateT> zzctaVar, zzdvu<DelegateT, AdapterT> zzdvuVar) {
        this.zzgnq = zzctaVar;
        this.zzgnr = zzdvuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        return this.zzgnq.zza(zzdogVar, zzdnvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<AdapterT> zzb(zzdog zzdogVar, zzdnv zzdnvVar) {
        return zzdyq.zzb(this.zzgnq.zzb(zzdogVar, zzdnvVar), this.zzgnr, zzbbz.zzeep);
    }
}
