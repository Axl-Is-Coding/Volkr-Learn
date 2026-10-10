package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfj implements zzeoy<zzcfh> {
    private final zzeph<zzcil> zzffj;
    private final zzeph<Clock> zzfok;

    public zzcfj(zzeph<zzcil> zzephVar, zzeph<Clock> zzephVar2) {
        this.zzffj = zzephVar;
        this.zzfok = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcfh(this.zzffj.get(), this.zzfok.get());
    }
}
